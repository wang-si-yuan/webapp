package com.wang.webapp.common.utils

import com.wang.webapp.common.domain.dto.Response
import com.wang.webapp.dic.domain.po.DicException
import com.wang.webapp.dic.service.DicExceptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Scope
@Component
class HttpResponseUtils {

    @Autowired
    private lateinit var dicExceptionService:DicExceptionService

    fun <T>success() = Response<T>(200, dicExceptionService.getById(200).exceptionMsg , null)
    fun <T> success(data:T) =  Response<T>(200, dicExceptionService.getById(200).exceptionMsg, data)
    fun <T>success(code:Int) = Response<T>(code, dicExceptionService.getById(code).exceptionMsg, null)
    fun <T>success(code: Int, data:T) = Response<T>(code, dicExceptionService.getById(code).exceptionMsg, data)
    fun <T>failed() = Response<T>(400, dicExceptionService.getById(400).exceptionMsg, null)
    fun <T> failed(data:T) =  Response<T>(400, dicExceptionService.getById(400).exceptionMsg, data)
    fun <T>failed(code:Int) = Response<T>(code, dicExceptionService.getById(code).exceptionMsg, null)
    fun <T>failed(code: Int, data:T) = Response<T>(code, dicExceptionService.getById(code).exceptionMsg, data)
}