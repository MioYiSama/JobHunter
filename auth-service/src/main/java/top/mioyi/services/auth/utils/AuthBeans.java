package top.mioyi.services.auth.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.mioyi.utils.Snowflake;

@Component
public class AuthBeans {
    @Bean
    public Snowflake snowflake() {
        return new Snowflake();
    }
}