package com.atguigu.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 解决cors , ajax只能请求同源的跨域请求问题
 *
 * @author lyg
 * @create 2020-04-09-21:41
 */
@Configuration
public class GateCorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        //运行那些路径请求,这里如果写*,那样就不能携带cookie了
        configuration.addAllowedOrigin("http://localhost:1000");
        //允许头信息
        configuration.addAllowedHeader("*");
        //允许的请求方式
        configuration.addAllowedMethod("*");
        //允许携带cookie
        configuration.setAllowCredentials(true);
        // 添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(source);


    }
}
