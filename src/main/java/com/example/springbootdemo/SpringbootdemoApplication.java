package com.example.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableTransactionManagement// 开启事务
@ConfigurationProperties(prefix="spring.datasource")
@MapperScan("com.example.springbootdemo.mapper")
public class SpringbootdemoApplication extends WebMvcConfigurerAdapter {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicAuthHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/*.js", "/*.png", "/*.jpg", "/*.jpeg", "/*.css", "/*.jsp","/*.eot","/*.svg","/*.ttf","/*.woff","login" );
    }
    @Bean
    public BasicAuthHandlerInterceptor basicAuthHandlerInterceptor(){
        return new BasicAuthHandlerInterceptor();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }
}
