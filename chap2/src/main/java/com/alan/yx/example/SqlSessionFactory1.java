package com.alan.yx.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 基于配置文件生成 SqlSessionFactory
 *
 * @author yinxing
 * @date 2019/9/12
 */

public class SqlSessionFactory1 {

    public SqlSessionFactory generateSqlSessionFactory() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
