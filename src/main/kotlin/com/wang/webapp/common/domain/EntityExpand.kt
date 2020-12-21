package com.wang.webapp.common.domain

import cn.hutool.core.bean.BeanUtil
import cn.hutool.core.bean.DynaBean
import com.wang.webapp.common.annotation.NoArg
import java.time.LocalDateTime


interface Builder
interface Transfor
interface Entity: Builder
interface Dto: Entity, Transfor
interface Bo: Entity, Transfor
interface Po: Entity, Transfor

public inline fun <T: Builder>T.builder(builder: T.() -> Unit): T{
    return this
}

public inline fun <reified T>Entity.getBean(): T{
    return DynaBean.create(T::class).getBean()
}

public inline fun <T: Transfor, reified To>T.doForward(): To{
    val to = DynaBean.create(To::class).getBean<To>()
    BeanUtil.copyProperties(this,to)
    return to
}

public inline fun <T: Transfor, reified Re>T.doForback(re: Re): T{
    BeanUtil.copyProperties(re,this)
    return this
}