package com.wang.webapp.dic.controller

import com.wang.webapp.common.domain.dto.Response
import com.wang.webapp.common.utils.HttpResponseUtils
import com.wang.webapp.dic.domain.dto.exceptionOneByCodeDto
import com.wang.webapp.dic.service.DicExceptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dict")
class DictionaryController {

    @Autowired
    private lateinit var dicExceptionService:DicExceptionService

    @Autowired
    private lateinit var httpResponseUtils: HttpResponseUtils

    @GetMapping("/exceptionList")
    fun exceptionList() = httpResponseUtils.success(201,dicExceptionService.list())

    @PostMapping("/exceptionOneByCode")
    fun exceptionOneByCode(exceptionOneByCodeDto: exceptionOneByCodeDto) = httpResponseUtils.success(201,dicExceptionService.getById(exceptionOneByCodeDto.code))
}