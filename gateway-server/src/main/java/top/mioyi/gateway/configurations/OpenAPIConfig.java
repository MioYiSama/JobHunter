package top.mioyi.gateway.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mioyi.utils.OpenAPIUtils;

@Configuration
public class OpenAPIConfig {
    @Bean
    public Info customInfo() {
        return new Info()
                .title("Job Hunter - " + OpenAPIUtils.DESCRIPTION)
                .version(OpenAPIUtils.VERSION);
    }

    @Bean
    public OpenAPI customOpenAPI(Info info) {
        return new OpenAPI().info(info);
    }
}
