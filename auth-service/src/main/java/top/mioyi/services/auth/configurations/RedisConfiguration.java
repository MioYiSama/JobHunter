package top.mioyi.services.auth.configurations;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.oauth2.jwt.Jwt;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Jwt> redisTemplate(RedisConnectionFactory factory) {
        val template = new RedisTemplate<String, Jwt>();
        val stringSerializer = new StringRedisSerializer();
        val jwtSerializer = new JdkSerializationRedisSerializer();

        template.setConnectionFactory(factory);

        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);

        template.setValueSerializer(jwtSerializer);
        template.setHashValueSerializer(jwtSerializer);

        return template;
    }
}
