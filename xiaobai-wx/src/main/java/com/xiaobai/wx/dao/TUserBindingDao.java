package com.xiaobai.wx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaobai.wx.entity.TUserBinding;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户绑定信息
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:38
 */
@Mapper
public interface TUserBindingDao extends BaseMapper<TUserBinding> {

}
