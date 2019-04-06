package com.weds.lab.security.demo.security.support;

import com.weds.lab.security.demo.entity.SysPermission;
import com.weds.lab.security.demo.entity.SysRole;
import com.weds.lab.security.demo.entity.SysUser;
import com.weds.lab.security.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserByName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username + "不存在");

        }

        List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (SysRole sysRole : sysUser.getRoleList()) {

            for (SysPermission sysPermission : sysRole.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }


        return new User(username, sysUser.getPassword(), authorities);
    }
}
