package com.leetcode.test.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2022/1/6 11:07
 */
public class CGLibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Ticket.class);
        enhancer.setCallback(new CGLibDynProxy());
        Ticket ticket = (Ticket) enhancer.create();
        ticket.buyTicket();
        ticket.refundTicket();
    }
}
