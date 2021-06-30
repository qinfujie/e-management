package com.basic.management.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 *
 * @author fujie
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 功能描述 跟JacksonJsonRedisSerializer实际上是一样的
     * 它不仅可以将对象序列化，还可以将对象转换为json字符串并保存到redis中，但需要和jackson配合一起使用。用JacksonJsonRedisSerializer序列化的话，
     * 被序列化的对象不用实现Serializable接口。Jackson是利用反射和getter和setter方法进行读取的，如果不想因为getter和setter方法来影响存储，
     * 就要使用注解来定义被序列化的对象。
     *
     * @param lettuceConnectionFactory lettuceConnectionFactory
     * @return RedisTemplate
     */
    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    RedisTemplate<String, Object> objRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        //Jackson2JsonRedisSerializer
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(om.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //连接
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //事务支持
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(lettuceConnectionFactory);
        return template;
    }
}