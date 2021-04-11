package com.yc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class LogAspect implements InvocationHandler {

    private Object target;//目标类对象

    public LogAspect(Object target){
        this.target=target;
    }

    public Object createProxy(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类的对象："+proxy.getClass());
        System.out.println("目标类的方法:"+method);
        System.out.println("方法中的参数:"+args);

        if (method.getName().startsWith("add")){
            log();
        }
        Object returnValue=method.invoke(this.target,args);


        return returnValue;
    }

    private void log() {
        System.out.println("=======before advice=======");
        System.out.println("hello,this is"+new Date());
        System.out.println("===========");
    }
}
