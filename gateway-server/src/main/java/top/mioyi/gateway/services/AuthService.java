package top.mioyi.gateway.services;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import top.mioyi.types.Role;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private static final String PREFIX = "Bearer ";

    private WebClient.Builder webClientBuilder;

    public Mono<Role> resolveToken(String token) {
        val uri = webClientBuilder.build()
                .get()
                .uri(
                        "http://localhost:8081/api/v1/internal/auth/token/resolve?token={token}",
                        Collections.singletonMap("token", token)
                );

        val response = uri.retrieve();

        return response.bodyToMono(Role.class)
                .onErrorResume(throwable -> Mono.just(Role.UNKNOWN));
    }

    public Optional<String> getTokenFromRequest(ServerHttpRequest request) {
        val authorization = request.getHeaders().get("Authorization");

        if (authorization != null && !authorization.isEmpty()) {
            String auth = authorization.getFirst();

            if (auth.startsWith(PREFIX)) {
                val token = auth.substring(PREFIX.length());

                return Optional.of(token);
            }
        }

        return Optional.empty();
    }
}
