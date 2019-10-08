package com.alan.yx.example;


import com.alan.yx.entity.Role;
import com.alan.yx.mapper.RoleMapper;
import com.alan.yx.mapper.RoleMapper2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * 基于代码生成 SqlSessionFactory
 *
 * @author yinxing
 * @date 2019/9/12
 */

public class SqlSessionFactory2 {

    public SqlSessionFactory generateSqlSessionFactory() {
        // 构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 构建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // 创建数据库运行环境
        Environment environment = new Environment("development", transactionFactory, dataSource);
        // 构建 Configuration 对象
        Configuration configuration = new Configuration(environment);
        // 注册一个 Mybatis 上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        // 加入一个映射器
        configuration.addMapper(RoleMapper.class);
        configuration.addMapper(RoleMapper2.class);
        // 使用
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}
