package com.weds.lab.security.demo.service.impl;

import com.weds.lab.security.demo.dao.SysUserDao;
import com.weds.lab.security.demo.entity.SysUser;
import com.weds.lab.security.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户模块实现
 *
 * @author liudw
 * @date 2019-04-05 12:37
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser getUserByName(String username) {
        return sysUserDao.selectByUsername(username);
    }
}
