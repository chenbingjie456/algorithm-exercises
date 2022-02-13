package com.leetcode.test.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibDynamicProxy before executor");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("CglibDynamicProxy after executor");
        return obj;
    }
}
