package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log3Aspect {
    public Object compute2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("***********compute2进到增强了");
       long start=System.currentTimeMillis();
       Object retVal=pjp.proceed();
       long end=System.currentTimeMillis();
       System.out.println("compute2要退出增强了.....");
       System.out.println("********这个方法运行的时长："+(end-start));
        return retVal;
    }
}
