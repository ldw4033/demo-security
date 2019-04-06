http://blog.didispace.com/springbootsecurity/

https://www.cnblogs.com/cjsblog/p/9152455.html

https://blog.csdn.net/qq_29580525/article/details/79317969

https://segmentfault.com/a/1190000015191298

https://docs.spring.io/spring-security/site/docs/current/


Spring security 5.0中新增了多种加密方式，也改变了密码的格式。会报错:

解决办法:
Spring Security的配置类WebSecurityConfig中新增下面代码

```bash
There is no PasswordEncoder mapped for the id "null"
```

解决办法:
Spring Security的配置类WebSecurityConfig中新增下面代码

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            //.password("admin")
            .roles("ADMIN");
}
```

