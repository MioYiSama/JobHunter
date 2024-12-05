package top.mioyi.services.info.configurations;

import lombok.val;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mioyi.types.utils.EducationEnumHandler;

@Configuration
public class MyBatisConfiguration {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            val registry = configuration.getTypeHandlerRegistry();

            registry.register(EducationEnumHandler.class);
        };
    }
}
