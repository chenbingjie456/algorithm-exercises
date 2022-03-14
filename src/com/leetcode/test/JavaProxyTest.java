package com.leetcode.test;

import com.leetcode.test.impl.ISayHellowServiceImpl;
import com.leetcode.test.service.SayHellowService;

import java.lang.reflect.*;

public class JavaProxyTest {
    public static Object getProxy(Object target) {
        Class proxyClazz = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces());

        Constructor constructor = null;
        try {
            constructor = proxyClazz.getConstructor(InvocationHandler.class);
            return constructor.newInstance(new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    ISayHellowServiceImpl sayHellowService1 = new ISayHellowServiceImpl();
                    return method.invoke(sayHellowService1, args);
                }
            });
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }


    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SayHellowService sayHellowService = (SayHellowService) getProxy(new ISayHellowServiceImpl());
        sayHellowService.sayHellow("123123");

    }
}
