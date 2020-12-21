package com.wang.webapp

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class WebappApplication

fun main(args: Array<String>) {
    runApplication<WebappApplication>(*args)
}
