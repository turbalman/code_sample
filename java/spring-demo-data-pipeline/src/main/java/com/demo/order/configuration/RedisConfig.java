package com.demo.order.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * The type Redis config.
 */
@Configuration
@ComponentScan("com.demo.order.model")
@EnableRedisRepositories(basePackages = "com.demo.order.repository.redis")
@PropertySource({"classpath:application.properties"})
public class RedisConfig {
    /**
     * The Host.
     */
    @Value("${spring.redis.host}")
    private String host;

    /**
     * The Port.
     */
    @Value("${spring.redis.port}")
    private int port;

    /**
     * The Password.
     */
    @Value("${spring.redis.password}")
    private String password;

    /**
     * Jedis connection factory jedis connection factory.
     *
     * @return the jedis connection factory
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName(host);
        jedisConFactory.setPort(port);
        jedisConFactory.setPassword(password);
        return jedisConFactory;
    }

    /**
     * Redis template redis template.
     *
     * @return the redis template
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}
