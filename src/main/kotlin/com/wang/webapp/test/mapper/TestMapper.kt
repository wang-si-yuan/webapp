package com.wang.webapp.test.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.wang.webapp.test.domain.Test
import org.apache.ibatis.annotations.Mapper

@Mapper
interface TestMapper: BaseMapper<Test>