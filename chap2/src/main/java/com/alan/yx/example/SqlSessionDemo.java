package com.alan.yx.example;

import com.alan.yx.entity.Role;
import com.alan.yx.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * 标准 SqlSession 使用方法
 *
 * @author yinxing
 * @date 2019/9/12
 */

public class SqlSessionDemo {

    public void sqlSessionUse() throws IOException {
        SqlSessionFactory1 sqlSessionFactory1 = new SqlSessionFactory1();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory1.generateSqlSessionFactory();

        // 定义 SqlSession
        SqlSession sqlSession = null;
        try {
            // 打开 SqlSession 会话
            sqlSession = sqlSessionFactory.openSession();
            // some code ...
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRoleById(1L);
            System.out.println(role.getRoleName());

            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
