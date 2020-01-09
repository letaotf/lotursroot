package com.food.lotusroot.web.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>mybatis的配置</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 2:46 PM
 * @since V1.0
 */
@Configuration
@MapperScan("com.food.lotusroot.mapper")
@ComponentScan(basePackages = {"com.food.lotusroot.dal", "com.food.lotusroot.core", "com.food.lotusroot.web","com.food.lotusroot.manager"})
@EnableTransactionManagement
public class MybatisConfig {

    /**
     * 配置分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
