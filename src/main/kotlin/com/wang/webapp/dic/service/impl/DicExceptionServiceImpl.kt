package com.wang.webapp.dic.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.wang.webapp.dic.domain.po.DicException
import com.wang.webapp.dic.mapper.DicExceptionMapper
import com.wang.webapp.dic.service.DicExceptionService
import org.springframework.stereotype.Service

@Service
class DicExceptionServiceImpl:DicExceptionService, ServiceImpl<DicExceptionMapper, DicException>()