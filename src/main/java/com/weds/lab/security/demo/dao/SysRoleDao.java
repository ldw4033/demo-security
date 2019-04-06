package com.weds.lab.security.demo.dao;

import com.weds.lab.security.demo.entity.SysPermission;
import com.weds.lab.security.demo.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysRoleDao {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    /**
     * 模拟查询角色
     *
     * @param code
     * @return
     */
    public SysRole selectByCode(String code) {
        if (StringUtils.equals("ADMIN", code)) {
            SysRole sysRole = new SysRole("ADMIN", "管理员");
            List<SysPermission> sysPermissions = new LinkedList<>();
            sysPermissions.add(sysPermissionDao.selectByCode("UserIndex"));
            sysPermissions.add(sysPermissionDao.selectByCode("BookList"));
            sysPermissions.add(sysPermissionDao.selectByCode("BookAdd"));
            sysPermissions.add(sysPermissionDao.selectByCode("BookDetail"));

            sysRole.setPermissionList(sysPermissions);
            return sysRole;

        } else if (StringUtils.equals("DEVELOPER", code)) {
            SysRole sysRole = new SysRole("DEVELOPER", "开发者");
            List<SysPermission> sysPermissions = new LinkedList<>();
            sysPermissions.add(sysPermissionDao.selectByCode("UserIndex"));
            sysPermissions.add(sysPermissionDao.selectByCode("BookList"));

            sysRole.setPermissionList(sysPermissions);
            return sysRole;
        }

        return null;
    }

}
