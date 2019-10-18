package com.food.lotusroot.web.annotation;

import java.lang.annotation.*;

/**
 * <p>令牌桶限流</p >
 *
 * @author: 乐陶（letao@maihaoche.com）
 * @date: 2019/10/18 上午9:31
 * @since V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiterExt {

    /**
     * 令牌桶限流速度
     * @return
     */
    double value() default 1;

    /**
     * 超时时间
     * @return
     */
    long expire() default 500;

}
