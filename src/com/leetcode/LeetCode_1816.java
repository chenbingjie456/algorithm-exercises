package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/6 10:45
 */

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 *
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/truncate-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1816 {

    public String truncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                count ++;

                if (count == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode_1816 leetCode_1816 = new LeetCode_1816();
        System.out.println(leetCode_1816.truncateSentence("Hello how are you Contestant", 5));
    }
}
