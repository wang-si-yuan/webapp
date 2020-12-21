package com.wang.webapp.common.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MyMetaObjectHandler: MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject?) {
        this.strictUpdateFill(metaObject, "createTime", { LocalDateTime.now() }, LocalDateTime::class.java)
    }

    override fun updateFill(metaObject: MetaObject?) {
        this.strictUpdateFill(metaObject, "updateTime", { LocalDateTime.now() }, LocalDateTime::class.java)
    }
}