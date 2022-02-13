package com.leetcode.test.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

    public Object getProxy(Class tClass) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(tClass);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibDynamicProxy());
        return  enhancer.create();
    }

    public static void main(String[] args) {
        CglibProxyTest test = new CglibProxyTest();
        Ticket ticket = (Ticket) test.getProxy(Ticket.class);
        ticket.getTicket();
        ticket.refuntTicket();
    }
}
