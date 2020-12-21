package com.wang.webapp.test.domain

import cn.hutool.core.clone.CloneSupport
import com.baomidou.mybatisplus.annotation.TableName
import com.wang.webapp.common.annotation.NoArg
import com.wang.webapp.common.domain.Entity

@TableName(value = "test")
@NoArg
data class Test(var test: String? = null): Entity