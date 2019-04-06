package com.weds.lab.security.demo.dao;

import com.weds.lab.security.demo.entity.SysRole;
import com.weds.lab.security.demo.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * 用户持久化
 *
 * @author liudw
 * @date 2019-04-05 12:06
 **/
@Slf4j
@Repository
public class SysUserDao {

    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 模拟查询用户
     *
     * @param username
     * @return
     */
    public SysUser selectByUsername(String username) {
        SysUser sysUser = null;

        if (StringUtils.equals("admin", username)) {

            sysUser = new SysUser("admin", passwordEncoder.encode("admin"));
            List<SysRole> sysRoles = new LinkedList<>();
            sysRoles.add(sysRoleDao.selectByCode("DEVELOPER"));
            sysRoles.add(sysRoleDao.selectByCode("ADMIN"));

            sysUser.setRoleList(sysRoles);

        } else if (StringUtils.equals("test", username)) {
            sysUser = new SysUser("test", passwordEncoder.encode("test"));
            List<SysRole> sysRoles = new LinkedList<>();
            sysRoles.add(sysRoleDao.selectByCode("DEVELOPER"));

            sysUser.setRoleList(sysRoles);
        }
        return sysUser;
    }


}
