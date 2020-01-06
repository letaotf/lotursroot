package com.food.lotusroot.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * <p>mybatis的配置</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2020/1/6 2:46 PM
 * @since V1.0
 */
@Configuration
@MapperScan("com.food.lotusroot.dal.mapper")
public class MybatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
