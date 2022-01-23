package com.leetcode.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2022/1/6 11:05
 */
public class CGLibDynProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLibDynProxy call before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLibDynProxy call after");
        return result;
    }
}
