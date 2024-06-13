package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href= "https://leetcode.cn/problems/integer-to-roman/description/">12. 整数转罗马数字</a>
 *
 * @author chenbjf
 * @since 2024-06-13 16:03
 */
public class LeetCode0012 {

    public String intToRoman(int num) {
        String[] k=new String[]{"","M","MM","MMM"};
        String[] h=new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] t=new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] o=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return k[num/1000] + h[(num%1000)/100] + t[(num%100)/10] + o[(num%10)];
    }
}
