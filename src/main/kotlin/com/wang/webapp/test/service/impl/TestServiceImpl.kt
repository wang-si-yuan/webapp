package com.wang.webapp.test.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.wang.webapp.test.domain.Test
import com.wang.webapp.test.mapper.TestMapper
import com.wang.webapp.test.service.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImpl:ServiceImpl<TestMapper, Test>(), TestService