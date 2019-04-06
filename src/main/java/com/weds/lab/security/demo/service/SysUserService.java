package com.weds.lab.security.demo.service;

import com.weds.lab.security.demo.entity.SysUser;

/**
 * 用户服务
 *
 * @author liudw
 * @date 2019-04-05 12:35
 **/
public interface SysUserService {

    /**
     * 根据用户名获取系统用户
     */
    SysUser getUserByName(String username);

}
