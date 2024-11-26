package top.mioyi.services.auth.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public License customLicense() {
        return new License()
                .name("GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
                .url("https://www.gnu.org/licenses/agpl-3.0.md")
                .identifier("AGPL-3.0");
    }

    @Bean
    public Contact customContact() {
        return new Contact()
                .name("MioYiSama")
                .email("mioyisama@gmail.com")
                .url("https://www.mioyi.top");
    }

    @Bean
    public Info customInfo(Contact contact, License license) {
        return new Info()
                .title("Job Hunter - Auth服务")
                .version("1.0.0")
                .description("API文档")
                .contact(contact)
                .license(license);
    }

    @Bean
    public OpenAPI customOpenAPI(Info info) {
        return new OpenAPI().info(info);
    }
}
