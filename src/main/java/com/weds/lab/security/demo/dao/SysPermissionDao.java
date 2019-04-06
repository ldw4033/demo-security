package com.weds.lab.security.demo.dao;

import com.weds.lab.security.demo.entity.SysPermission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 用户持久化
 *
 * @author liudw
 * @date 2019-04-05 12:06
 **/
@Slf4j
@Repository
public class SysPermissionDao {
    private static final SysPermission p1;
    private static final SysPermission p2;
    private static final SysPermission p3;
    private static final SysPermission p4;

    static {

        p1 = new SysPermission();
        p1.setCode("UserIndex");
        p1.setName("个人中心");
        p1.setUrl("/user/index.html");

        p2 = new SysPermission();
        p2.setCode("BookList");
        p2.setName("图书列表");
        p2.setUrl("/book/list");

        p3 = new SysPermission();
        p3.setCode("BookAdd");
        p3.setName("添加图书");
        p3.setUrl("/book/add");

        p4 = new SysPermission();
        p4.setCode("BookDetail");
        p4.setName("查看图书");
        p4.setUrl("/book/detail");


    }


    /**
     * 模拟查询资源
     *
     * @param code
     * @return
     */
    public SysPermission selectByCode(String code) {
        if (StringUtils.equals("UserIndex", code)) {
            return p1;
        } else if (StringUtils.equals("BookList", code)) {
            return p2;
        } else if (StringUtils.equals("BookAdd", code)) {
            return p3;
        } else if (StringUtils.equals("BookDetail", code)) {
            return p4;
        }

        return null;
    }


}
