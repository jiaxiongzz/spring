package com.yc.biz;

import com.yc.AppConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldTest extends TestCase {
    private ApplicationContext ac;
    @Override
    public void setUp() throws Exception {
        ac=new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testHello() {

        HelloWorld hw= (HelloWorld) ac.getBean("helloWorld");
        hw.hello();

        HelloWorld hw2= (HelloWorld) ac.getBean("helloWorld");

        //spring容器是单例模型
    }
}