package com.alan.yx;

import com.alan.yx.entity.Role;
import com.alan.yx.mapper.RoleMapper;
import com.alan.yx.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap2Application {

    public static void main(String[] args) {

//		SpringApplication.run(Chap2Application.class, args);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            roleMapper.insertRole(role);
            roleMapper.deleteRole(1L);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
