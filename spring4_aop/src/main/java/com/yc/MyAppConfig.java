package com.yc;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.yc"})
@EnableAspectJAutoProxy //启用aspect支持
public class MyAppConfig {

//    @MyBean
//    public HelloWorld hw(){
//        return new HelloWorld();
//    }
//
//    @MyBean
//    public HelloWorld hw2(){
//        return new HelloWorld();
//    }
}
