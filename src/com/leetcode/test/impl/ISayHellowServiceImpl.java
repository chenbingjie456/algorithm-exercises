package com.leetcode.test.impl;

import com.leetcode.test.service.SayHellowService;

public class ISayHellowServiceImpl implements SayHellowService {
    @Override
    public String sayHellow(String msg) {
        System.out.println("I say " + msg);
        return msg;
    }
}
