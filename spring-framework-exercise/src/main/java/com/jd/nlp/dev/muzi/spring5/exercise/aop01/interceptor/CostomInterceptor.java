package com.jd.nlp.dev.muzi.spring5.exercise.aop01.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class CostomInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("=======全局拦截========");

        return invocation.proceed();
    }
}
