package top.mioyi.gateway.services;

import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;
import top.mioyi.types.Role;

import java.util.Optional;

public interface AuthService {
    Mono<Role> resolveToken(String token);

    Optional<String> getTokenFromRequest(ServerHttpRequest request);
}
