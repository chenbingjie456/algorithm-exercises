package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/25 15:21
 */

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0011 {

    /**
     * 超时算法
     * @param height
     * @return
     */
    public int maxAreaOld(int[] height) {
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int value = (j - i) * Math.min(height[i], height[j]);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }
        return maxValue;
    }

    public int maxArea(int[] height) {
        int left = 0; int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int value = Math.min(height[left], height[right]) * (right - left);
            if (value > max) {
                max = value;
            }

            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        LeetCode_0011 leetCode_0011 = new LeetCode_0011();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = leetCode_0011.maxArea(height);
        System.out.println(result);
    }

}
