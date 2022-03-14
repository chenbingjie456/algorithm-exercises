package com.leetcode.test.cglibproxy;

public class Ticket {

    public String getTicket() {
        System.out.println("买了一张火车票");
        return "success";
    }

    final public void refuntTicket() {
        System.out.println("退了张火车票");
    }
}
