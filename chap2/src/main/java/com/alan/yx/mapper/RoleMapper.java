package com.alan.yx.mapper;


import com.alan.yx.entity.Role;

/**
 * 基于配置文件
 *
 * @author yinxing
 * @date 2019/9/12
 */

public interface RoleMapper {

    Role getRoleById(Long id);

    int insertRole(Role role);

    int deleteRole(Long id);
}
