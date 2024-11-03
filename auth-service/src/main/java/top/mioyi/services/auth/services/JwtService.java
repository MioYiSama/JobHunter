package top.mioyi.services.auth.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import top.mioyi.utils.Snowflake;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@AllArgsConstructor

public class JwtService {
    private final JwtEncoder jwtEncoder;
    private final JwtTimestampValidator jwtTimestampValidator;
    private final Snowflake snowflake;
    private final RedisTemplate<String, Jwt> redisTemplate;

    public String generateToken(String account) {
        val now = Instant.now();

        val claims = JwtClaimsSet.builder()
                .id(Long.toString(snowflake.nextId()))
                .claim("account", account)
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .build();

        val jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims));
        val token = jwt.getTokenValue();

        val operations = redisTemplate.opsForValue();
        operations.set(account, jwt);
        operations.set(token, jwt);

        return jwt.getTokenValue();
    }

    /**
     * @return JWT中包含的账号信息
     */
    public Optional<String> resolveJwt(String token) {
        try {
            val jwt = redisTemplate.opsForValue().get(token);

            if (jwt != null) {
                final String account = jwt.getClaim("account");

                if (!jwtTimestampValidator.validate(jwt).hasErrors()) {
                    return Optional.ofNullable(account);
                } else {
                    redisTemplate.delete(token);
                    redisTemplate.delete(account);
                }
            }
        } catch (JwtException e) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
