package top.mioyi.gateway.filters;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.mioyi.gateway.services.AuthService;
import top.mioyi.types.ServiceEnum;

@Component
@AllArgsConstructor
public class AuthFilter implements GlobalFilter {
    private AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        val request = exchange.getRequest();
        val path = request.getURI().getPath();

        if (path.startsWith("/api/v1/auth")) {
            return chain.filter(exchange);
        }

        val response = exchange.getResponse();
        val token = authService.getTokenFromRequest(request);

        if (token.isPresent()) {
            val result = authService.resolveToken(token.get());

            return result.flatMap(role -> {
                if (role == null) {
                    return unauthorized(response);
                }

                val service = ServiceEnum.parseFromPath(path);

                if (service.isEmpty() || !service.get().allow(role)) {
                    return unauthorized(response);
                }

                return chain.filter(exchange);
            });
        }

        return unauthorized(response);
    }

    private Mono<Void> unauthorized(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
