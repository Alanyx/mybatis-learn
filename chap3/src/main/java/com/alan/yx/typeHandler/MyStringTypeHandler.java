package com.alan.yx.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yinxing
 * @date 2019/9/25
 */
// 定义 JavaType 类型
@MappedTypes({String.class})
// 定义 JdbcType 类型
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyStringTypeHandler implements TypeHandler<String> {

    private Logger log = LoggerFactory.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int index, String parameter, JdbcType jdbcType) throws SQLException {
        log.info("use MyStringTypeHandler");
        ps.setString(index, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        log.info("use MyStringTypeHandler,ResultSet 列名获取字符串");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.info("use MyStringTypeHandler,ResultSet 下标获取字符串");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("use MyStringTypeHandler,CallableStatement 下标获取字符串");
        return cs.getString(columnIndex);
    }
}
