package com.alan.yx.mapper;

import com.alan.yx.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 基于注解
 *
 * @author yinxing
 * @date 2019/9/12
 */
@Mapper
public interface RoleMapper2 {

    @Select("SELECT id,role_name AS roleName,note FROM t_role WHERE id=#{id}")
    Role getRoleById(@Param(value = "id") Long id);
}
