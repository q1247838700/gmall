package com.atguigu.gmall.pms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**这个类主要的作用是让spring Security放行所有的请求,
 * @author lyg
 * @create 2020-04-09-16:42
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行所有请求
        http.authorizeRequests().antMatchers("/**").permitAll();
        //禁用掉跨域请求伪造保护
        http.csrf().disable();
    }
}
