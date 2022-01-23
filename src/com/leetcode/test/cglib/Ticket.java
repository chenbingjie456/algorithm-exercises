package com.leetcode.test.cglib;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2022/1/6 11:01
 */
public class Ticket {

    public String buyTicket() {
        System.out.println("buy a ticket");
        return "success";
    }

    public final void refundTicket() {
        System.out.println("refundTicket a ticket");
    }
}
