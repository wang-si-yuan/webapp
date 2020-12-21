package com.wang.webapp.user.domain.po

import com.baomidou.mybatisplus.annotation.*
import com.wang.webapp.common.domain.Po
import java.time.LocalDateTime

@TableName(value = "sys_user")
data class User(

        @TableId(value = "user_code", type = IdType.ASSIGN_UUID)
        var userCode:Int? = null,

        @TableField(value = "user_email")
        var userEmail:String? = null,

        @TableField(value = "user_phone")
        var userPhone:String? = null,

        @TableField(value = "user_password")
        var userPassword:String? = null,

        @TableField(value = "user_role")
        var userRole:Int? = null,

        @TableField(value = "user_last_name")
        var userLastName:String? = null,

        @TableField(value = "user_first_name")
        var userFirstName:String? = null,

        @TableField(value = "user_bickname")
        var userBickname:String? =null,

        @TableField(value = "user_introduction")
        var userIntroduction:String? =null,

        @TableField(value = "create_time", fill = FieldFill.INSERT)
        var createTime: LocalDateTime? = null,

        @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
        var updateTime: LocalDateTime? = null,

        @TableField(value = "del_flag")
        var delFlag:Int? = null

): Po