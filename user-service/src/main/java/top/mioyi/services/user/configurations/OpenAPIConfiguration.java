package top.mioyi.services.user.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mioyi.utils.OpenAPIUtils;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public Info customInfo() {
        return new Info()
                .title("Job Hunter - User服务")
                .version(OpenAPIUtils.VERSION)
                .description(OpenAPIUtils.DESCRIPTION)
                .contact(OpenAPIUtils.CONTACT)
                .license(OpenAPIUtils.LICENSE);
    }

    @Bean
    public OpenAPI customOpenAPI(Info info) {
        return new OpenAPI().info(info);
    }
}
