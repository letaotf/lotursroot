package com.food.lotusroot.web.controller;

import com.food.lotusroot.web.annotation.RateLimiterExt;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>hello</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2019/10/17 下午8:37
 * @since V1.0
 */
@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

     //令牌桶算法--服务限流
     RateLimiter rateLimiter = RateLimiter.create(10.0);

     @GetMapping("")
     @RateLimiterExt
     public String getHello(){
         log.info("我是乐陶，你来啊");
         return "我是乐陶，你来啊";
     }


}
