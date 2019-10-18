package com.food.lotusroot.web.aop;

import com.food.lotusroot.web.annotation.RateLimiterExt;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>令牌桶限流aop</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2019/10/18 上午9:35
 * @since V1.0
 */
@Aspect
@Component
@Slf4j
public class RateLimiterAop {

    /**
     * 令牌桶缓存
     */
    private static Map<String,RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    /**
     * 定义了切点与切面
     */
    @Pointcut("execution(public * com.food.lotusroot.web.controller.*.*(..))")
    public void pointcut(){}

    /**
     * 环绕增强
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //根据java反射的原理获取RateLimiterExt注解所在的方法
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        RateLimiterExt ext = methodSignature.getMethod().getDeclaredAnnotation(RateLimiterExt.class);
        //如果不存在该注解，不进行限流判断
        if(Objects.isNull(ext)){
            return joinPoint.proceed();
        }
        //获取令牌生成的速率
        double value = ext.value();
        //超过改时间还未获得令牌，则采用服务降级
        long expire = ext.expire();
        //获取该方法的Uri
        RateLimiter rateLimiter = getRateLimiter(value);
        //获取令牌是否成功
        boolean tryAcquire = rateLimiter.tryAcquire(expire, TimeUnit.MICROSECONDS);
        if(!tryAcquire){
            //进行服务降级操作
            serviceDown();
            return null;
        }
        return joinPoint.proceed();
    }

    /**
     * 从缓存中获取 RateLimiter
     * @param value
     * @return
     */
    private RateLimiter getRateLimiter(double value){
        //获取请求的url
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes )RequestContextHolder.getRequestAttributes();
        //获取请求
        HttpServletRequest request = requestAttributes.getRequest();
        //拿到请求链接
        String requestURI = request.getRequestURI();
        if(!rateLimiterMap.containsKey(requestURI)){
            RateLimiter rateLimiter = RateLimiter.create(value);
            rateLimiterMap.put(requestURI,rateLimiter);
        }
        return rateLimiterMap.get(requestURI);
    }

    /**
     * 服务降级
     */
    private void serviceDown(){
        log.info("服务降级开始");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes )RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print("执行降级方法,亲,服务器忙！请稍后重试!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(Objects.nonNull(writer)){
                writer.close();
            }
        }
    }


}
