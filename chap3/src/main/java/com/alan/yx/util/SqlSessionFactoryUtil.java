package com.alan.yx.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * 读取加密的用户名和密码配置
 *
 * @author yinxing
 * @date 2019/9/17
 */
@Slf4j
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory initSqlSessionFactory() {
        InputStream configInputStream = null;
        Reader configReader = null;
        InputStream propertyStream = null;
        Reader propertyReader = null;
        Properties properties = null;
        try {
            // 读入配置文件
            configInputStream = Resources.getResourceAsStream("mybatis-config.xml");
            configReader = new InputStreamReader(configInputStream);
            // 读入属性文件
            propertyStream = Resources.getResourceAsStream("jdbc.properties");
            propertyReader = new InputStreamReader(propertyStream);
            properties = new Properties();
            properties.load(propertyReader);
            // 解密为明文
            properties.setProperty("username", decode(properties.getProperty("username")));
            properties.setProperty("password", decode(properties.getProperty("password")));
        } catch (IOException e) {
            log.error("SqlSessionFactory init failed,cause:" + e.getMessage());
        }
        // 线程安全
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configReader, properties);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 解密方法(此处只做演示，一般会用第三方包)
     *
     * @param key
     * @return
     */
    private static String decode(String key) {
        return "";
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            sqlSessionFactory = initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
