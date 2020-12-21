package com.wang.webapp.test

import com.wang.webapp.common.domain.builder
import com.wang.webapp.common.domain.dto.Response
import com.wang.webapp.user.domain.po.User
import com.wang.webapp.common.exception.OtherException
import com.wang.webapp.test.domain.Test
import com.wang.webapp.test.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class Controller{

    @Autowired
    private lateinit var testService: TestService

    @GetMapping("/test")
    fun testAPI() = testService.list()

    @GetMapping("/testException")
    @Throws(OtherException::class)
    fun testException(): Response<Any> = throw OtherException("测试异常")

    fun a(){
        var a = Test().builder {
            test = "a"
        }
        User().

    }
}
