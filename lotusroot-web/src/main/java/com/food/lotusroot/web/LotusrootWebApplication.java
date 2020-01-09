package com.food.lotusroot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LotusrootWebApplication {

	@RequestMapping("/")
	public String index(){
		return "我是测试数据";
	}

	public static void main(String[] args) {
		SpringApplication.run(LotusrootWebApplication.class, args);
	}

}

