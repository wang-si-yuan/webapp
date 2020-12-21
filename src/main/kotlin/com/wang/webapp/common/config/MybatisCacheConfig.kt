package com.wang.webapp.common.config

import org.apache.ibatis.cache.Cache
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import javax.annotation.Resource


class MybatisCacheConfig(id: String): Cache {
    private val logger: Logger = LoggerFactory.getLogger(MybatisCacheConfig::class.java)
    private val EXPIRE_TIME_IN_MINUTES: Long = 30
    private val id: String

    init {
        this.readWriteLock
        this.id = id
    }

    override fun getReadWriteLock(): ReadWriteLock {
        return ReentrantReadWriteLock(true)
    }

    @Resource
    private lateinit var redisTemplate: RedisTemplate<String, Any>

    override fun getId() =id

    override fun putObject(key: Any, value: Any?) {
        redisTemplate.opsForValue().set(key as String, value as Any, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES)
        logger.debug("redis cache $id put key: $key value: $value")
    }

    override fun getObject(key: Any): Any? {
        val res = redisTemplate.opsForValue().get(key)
        logger.debug("redis cache $id get key: $key")
        return res
    }

    override fun removeObject(key: Any): Any {
        val res = redisTemplate.delete(key as String)
        logger.debug("redis cache $id remove key: $key$res")
        return res
    }

    override fun clear() {
        redisTemplate.execute {
            it.flushDb()
            return@execute
        }
        logger.debug("Clear all the cached query result from redis $id")
    }

    override fun getSize() = 0

}