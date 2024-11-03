package top.mioyi.services.auth.configurations;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder() {
            private final ErrorDecoder defaultErrorDecoder = new Default();

            @Override
            @SneakyThrows
            public Exception decode(String methodKey, Response response) {
                if (response.status() >= 400 && response.status() <= 599) {
                    return new FeignException.FeignClientException(
                            response.status(),
                            "服务异常",
                            response.request(),
                            response.body().asInputStream().readAllBytes(),
                            null
                    );
                }

                return defaultErrorDecoder.decode(methodKey, response);
            }
        };
    }
}
