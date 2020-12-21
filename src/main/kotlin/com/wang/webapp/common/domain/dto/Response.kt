package com.wang.webapp.common.domain.dto

import com.wang.webapp.common.annotation.NoArg
import com.wang.webapp.common.domain.Dto

@NoArg
data class Response<T>(val code:Int = 0, val msg:String? = null, val data:T? = null): Dto