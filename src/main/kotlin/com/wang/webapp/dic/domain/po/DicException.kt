package com.wang.webapp.dic.domain.po

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.wang.webapp.common.domain.Po

@TableName(value = "dic_exception")
data class DicException(
        @TableId(value = "exception_code")
        val exceptionCode:Int,

        @TableField(value = "exception_msg")
        val exceptionMsg:String
        ): Po