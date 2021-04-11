package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect //切面类：你要增强的功能写到这里
@Component //IOC注解 实现让spring托管的功能
public class LogAspect {

    //切入点的声明
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void add(){

    }
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))")//切入点表达式
    private void update(){

    }
    @Pointcut("add()||update()")
    private void addAndUpdate(){

    }
    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("==========LogAspect   进到增强============");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();   //目标类的目标方法
        long end=System.currentTimeMillis();
        System.out.println("compute要退出增强了==========");
        System.out.println("==========compute这个方法运行的时长为："+(end-start));
        return retVal;
    }

    @After("com.yc.aspect.LogAspect.addAndUpdate()")
    private  void Afterlog(){
        System.out.println("----------------bye-----------");
    }

    //增加的声明
    @Before("com.yc.aspect.LogAspect.add()")
    public void log(){
        System.out.println("==================前置增强的日志================");
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr=sdf.format(d);
        System.out.println("执行时间为:"+dstr);
        System.out.println("==================前置增强的日志结束================");
    }
}
