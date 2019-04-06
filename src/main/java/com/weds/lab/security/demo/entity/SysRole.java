package com.weds.lab.security.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色模块
 *
 * @author liudw
 * @date 2019-04-05 12:00
 **/
@Data
public class SysRole implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色拥有的权限
     */
    private List<SysPermission> permissionList;

    public SysRole(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
