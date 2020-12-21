package com.wang.webapp.common.utils

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.servlet.LocaleResolver
import java.util.*
import javax.servlet.http.HttpServletRequest


@Component
class SpringUtils: ApplicationContextAware {

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        SpringUtils.applicationContext = applicationContext
    }

    companion object {
        private var applicationContext: ApplicationContext? = null

        fun<T> getBean(type: Class<T>): T = applicationContext!!.getBean(type)

        fun<T> getBean(name: String, type: Class<T>): T = applicationContext!!.getBean(name, type)

        fun getCurrentReq(): HttpServletRequest? {
            return (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes? ?: return null).request
        }

        fun getMessage(code: String?, vararg args: Any?): String = applicationContext!!.getMessage(code!!, args, getBean(LocaleResolver::class.java).resolveLocale(getCurrentReq()!!))
    }

}