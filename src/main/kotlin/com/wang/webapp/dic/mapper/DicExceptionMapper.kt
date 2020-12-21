package com.wang.webapp.dic.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.wang.webapp.dic.domain.po.DicException
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DicExceptionMapper: BaseMapper<DicException>