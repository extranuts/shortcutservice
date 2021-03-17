package com.example.shortcutservice.links;


import com.example.shortcutservice.common.ShortLink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author
 * @return
 */

@Configuration
public class RedisConfiguration {

    @Bean
    RedisTemplate<String, ShortLink> template(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, ShortLink> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;

    }
}
