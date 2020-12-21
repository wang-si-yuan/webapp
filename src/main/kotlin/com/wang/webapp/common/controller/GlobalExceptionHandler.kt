package com.wang.webapp.common.controller

import com.wang.webapp.common.domain.dto.Response
import com.wang.webapp.common.exception.AppException
import com.wang.webapp.common.utils.HttpResponseUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class GlobalExceptionHandler {

    @Autowired
    private lateinit var result:HttpResponseUtils

    @ExceptionHandler(value = [AppException::class])
    public fun appExceoption(appException: AppException): Response<Any> = result.failed()
}