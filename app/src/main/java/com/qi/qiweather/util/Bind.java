package com.qi.qiweather.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 王俊杰 on 2017/8/18.
 */
@Target(ElementType.FIELD)//设置当前注解的使用范围  变量
@Retention(RetentionPolicy.RUNTIME)//当前注解生命时长 虚拟机
public @interface Bind {
    int value();
}
