package com.weds.lab.security.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户模块
 *
 * @author liudw
 * @date 2019-04-05 11:57
 **/
@Data
public class SysUser implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色
     */
    private List<SysRole> roleList;

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
