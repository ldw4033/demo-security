package com.weds.lab.security.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 资源模块
 *
 * @author liudw
 * @date 2019-04-05 12:02
 **/
@Data
public class SysPermission implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限字符串
     */
    private String code;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * URL
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父菜单ID
     */
    private Long pid;

}
