package com.wang.webapp.common.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {

    @Autowired
    lateinit var lettuceConnectionFactory: LettuceConnectionFactory

    fun redisTemplate(): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        initDomainRedisTemplate(redisTemplate,lettuceConnectionFactory)
        return redisTemplate
    }

    fun initDomainRedisTemplate(template: RedisTemplate<String, Any>, factory: LettuceConnectionFactory) {
        // 定义 key 的序列化方式为 string
        // 需要注意这里Key使用了 StringRedisSerializer，那么Key只能是String类型的，不能为Long，Integer，否则会报错抛异常。
        template.keySerializer = StringRedisSerializer()

        //定义value的序列化为json
        // 定义 value 的序列化方式为 jsons
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        val objectMapper = ObjectMapper()
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper)

        template.hashKeySerializer = jackson2JsonRedisSerializer
        template.hashValueSerializer = jackson2JsonRedisSerializer
        template.setEnableTransactionSupport(true)
        template.setConnectionFactory(factory)
    }
}