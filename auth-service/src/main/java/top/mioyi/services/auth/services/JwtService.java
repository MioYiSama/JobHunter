package top.mioyi.services.auth.services;

import java.util.Optional;

public interface JwtService {
    String generateToken(String account);

    /**
     * @return JWT中包含的账号信息
     */
    Optional<String> resolveJwt(String token);

    boolean invalidateJwt(String token);
}
