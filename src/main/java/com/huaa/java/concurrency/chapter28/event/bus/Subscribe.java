package com.huaa.java.concurrency.chapter28.event.bus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    String topic() default "default-topic";
}
