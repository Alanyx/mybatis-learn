package com.alan.yx.mapper;

import com.alan.yx.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    // RoleMapper1 ================================
    int countFirstName(String firstName);

    List<Role> findRoleByMap(Map<String, String> params);

    /**
     * 上述传递参数方式:[废弃]
     * List<Role> findRoleByParams(RoleParam roleParam){
     * Map<String,String> paramMap = new HashMap<>(2);
     * paramMap.put("roleName","test");
     * paramMap.put("note","test");
     * List<Role> roleList=  roleMapper.findRoleByMap(paramMap);
     */

    List<Role> findRoleByNameAndNote(@Param("roleName") String roleName,
                                     @Param("note") String note);

    // RoleMapper2 ================================
    Role getRole(long id);

    // RoleMapper3 ================================
    int insertRole(String roleName, String note);

    int insertRole2(String roleName, String note);

    // RoleMapper4 ================================
    int updateRole(String roleName, String note, long id);

    int deleteRole(long id);
}
