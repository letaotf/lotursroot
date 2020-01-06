package com.food.lotusroot.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.food.lotusroot.dal", "com.food.lotusroot.core", "com.food.lotusroot.web","com.food.lotusroot.manager"})
@MapperScan(basePackages = "com.food.lotusroot.mapper")
public class LotusrootWebApplication {

	@RequestMapping("/")
	public String index(){
		return "我是测试数据";
	}

	public static void main(String[] args) {
		SpringApplication.run(LotusrootWebApplication.class, args);
	}

}

