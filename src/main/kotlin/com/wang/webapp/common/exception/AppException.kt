package com.wang.webapp.common.exception

open class AppException(val code:Int): RuntimeException()
class OtherException(val msg:String): AppException(501)