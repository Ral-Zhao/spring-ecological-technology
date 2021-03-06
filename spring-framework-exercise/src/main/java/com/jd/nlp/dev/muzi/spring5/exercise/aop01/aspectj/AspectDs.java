package com.jd.nlp.dev.muzi.spring5.exercise.aop01.aspectj;

import com.jd.nlp.dev.muzi.spring5.exercise.annotation.TargetSource;
import com.jd.nlp.dev.muzi.spring5.exercise.datasource.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-1)
public class AspectDs {

    @Around(value = "@annotation(targetSource)",argNames = "joinPoint,targetSource")
    public void xx(ProceedingJoinPoint joinPoint, TargetSource targetSource) {

        System.out.println("========AspectDs.xx");
        String value = targetSource.value();

        if(value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
