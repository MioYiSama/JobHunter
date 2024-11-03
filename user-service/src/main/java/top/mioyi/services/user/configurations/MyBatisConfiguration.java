package top.mioyi.services.user.configurations;

import lombok.val;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mioyi.types.utils.RoleEnumHandler;

@Configuration
public class MyBatisConfiguration {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            val registry = configuration.getTypeHandlerRegistry();

            registry.register(RoleEnumHandler.class);
        };
    }
}
