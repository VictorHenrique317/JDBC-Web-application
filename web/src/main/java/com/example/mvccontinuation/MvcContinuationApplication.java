package com.example.mvccontinuation;

import com.example.mvccontinuation.constants.Views;
import com.example.mvccontinuation.interceptors.HeaderInterceptor;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class MvcContinuationApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MvcContinuationApplication.class, args);
    }

    @PostConstruct
    public void init() {
//		ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
//		root.setLevel(ch.qos.logback.classic.Level.DEBUG);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(Views.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor());
    }

    @Bean
    public DataSource dataSource(@Value("${sql.username}") String username,
								 @Value("${sql.password}") String password,
								 @Value("${sql.driverClassName}") String driverClassName,
								 @Value("${sql.url}") String url) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }

}
