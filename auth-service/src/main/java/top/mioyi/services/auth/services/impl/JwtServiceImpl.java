package top.mioyi.services.auth.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import top.mioyi.services.auth.services.JwtService;
import top.mioyi.utils.Snowflake;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtdecoder;
    private final JwtTimestampValidator jwtTimestampValidator;
    private final RedisTemplate<String, String> redisTemplateAccount;

    @Override
    public String generateToken(String account) {
        val now = Instant.now();

        val claims = JwtClaimsSet.builder()
                .id(Long.toString(Snowflake.INSTANCE.nextId()))
                .claim("account", account)
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .build();

        val jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims));
        val token = jwt.getTokenValue();

        val operations = redisTemplateAccount.opsForValue();
        operations.set(account, token);

        return jwt.getTokenValue();
    }

    @Override
    public Optional<String> resolveJwt(String token) {
        try {
            val jwt = jwtdecoder.decode(token);
            val account = (String) jwt.getClaim("account");
            val redisToken = redisTemplateAccount.opsForValue().get(account);

            if (!token.equals(redisToken)) {
                return Optional.empty();
            } else if (jwtTimestampValidator.validate(jwt).hasErrors()) {
                redisTemplateAccount.delete(account);
                return Optional.empty();
            } else {
                return Optional.of(account);
            }
        } catch (JwtException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean invalidateJwt(String token) {
        String account;
        try {
            val jwt = jwtdecoder.decode(token);
            account = jwt.getClaim("account");

            if (account == null) {
                return false;
            }
        } catch (JwtException e) {
            return false;
        }

        val operations = redisTemplateAccount.opsForValue();
        val dbToken = operations.get(account);

        if (!Objects.equals(token, dbToken)) {
            return false;
        }

        redisTemplateAccount.delete(account);
        return true;
    }
}
