package com.atguigu.gmall.pms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lyg
 * @create 2020-04-09-17:06
 */
//Spring boot方式
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

