package com.alan.yx.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author yinxing
 * @date 2019/9/11
 */
@Data
// 配合 别名的 package使用
@Alias("role")
public class Role {

    private Long id;

    private String roleName;

    private String note;
}
