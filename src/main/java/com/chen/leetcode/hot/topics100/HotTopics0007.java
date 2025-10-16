package com.chen.leetcode.hot.topics100;

import java.util.Stack;

/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author chenbjf
 * @since 2025-04-27 10:00
 */
public class HotTopics0007 {

    /**
     * 方法一：
     * 从暴力解法中我们可以看到，要求数组i位置可以存储的水量，需要先求出0到i位置的最大值max(arr[0...i])，再求出i到n-1位置的最大值max(arr[i...n-1])，两个值中取最小与arr[i]做差。
     * 暴力解法之所以时间复杂度比较差，是因为对于数组中的每一个元素，都需要再遍历一遍数组才能得到它左右两侧的最大值。
     * 所以我们可以通过预处理数组得到leftMax[]和rightMax[]两个数组，leftMax[i]代表数组0到i位置的最大值，leftMax[i] = max(leftMax[i-1], arr[i])；rightMax[i]代表数组i位置到n-1位置的最大值，rightMax[i] = max(rightMax[i+1], arr[i])。
     * 这样我们就得到了如下的算法流程。
     * 首先遍历数组，从左向右得到数组leftMax[]，再从右向左得到rightMax[]。然后再遍历一遍数组，对于数组的每一个位置i，通过leftMax[i]，rightMax[i]和arr[i]得到结果，将结果汇总得到的值就是最终答案。
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int result = 0;
        int[] leftMaxArr = leftMaxArr(height);
        int[] rightMaxArr = rightMaxArr(height);
        for (int i = 0; i < height.length ; i++) {
            result += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return result;
    }

    private int[] leftMaxArr(int[] height) {
        int[] leftMaxArr = new int[height.length];
        leftMaxArr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }
        return leftMaxArr;
    }
    private int[] rightMaxArr(int[] height) {
        int[] rightMaxArr = new int[height.length];
        int right = height.length - 1;
        rightMaxArr[right] = height[right];
        for (int i = right - 1; i >=0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i+1]);
        }
        return rightMaxArr;
    }


    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        HotTopics0007 hotTopics0007 = new HotTopics0007();
        int res1 = hotTopics0007.trap002(height);
        System.out.println(res1);
    }


    /**
     * 解法二中的双指针需要遍历三次数组，第一次得出数组leftMax[]，第二次得出数组rightMax[]，第三次才是根据leftMax[i]，rightMax[i]和height[i]得出结果。那我们能不能想办法把这三次遍历合并成一次呢？
     * 我们设置两个指针，left指向数组的0位置，right指针指向数组的n-1位置。再使用两个变量leftMax和rightMax，leftMax的含义是数组0...left位置的最大值，rightMax的含义是数组right...n-1位置的最大值，这几个变量设置好后就有以下几种情况。
     *
     * leftMax < rightMax，此时可以使用leftMax来结算height[left]位置的储水量。它的右侧可能还会有比rightMax更高的元素，但不会影响left位置的储水量。因为这种情况下left位置左侧的最大值是影响该位置储水量的瓶颈，此时res[left] = leftMax - height[left]。
     * leftMax > rightMax，此时可以使用rightMax来结算right位置的储水量。同样的，它的左侧可能还会有比leftMax更高的元素，但都不影响right位置的储水量。因为这种情况下right位置右侧的最大值是影响该位置储水量的瓶颈。此时res[right] = rightMax - height[right]。
     * leftMax == rightMax，此时既可以结算左侧，也可以结算右侧，或者左右两侧可以同时结算储水量。res[left] = leftMax - height[left]，res[right] = rightMax - height[right]。但是要注意如果结算前left == right，此时只能结算一侧。
     *
     * 不断重复上述流程，哪侧结算就将哪侧的指针相应移动，并在移动的过程中更新leftMax和rightMax，直到两个指针会合，结算完最后一个位置的水量为止。
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0; int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                result += leftMax - height[left++];
            } else if (height[left] > height[right]){
                result += rightMax - height[right--];
            } else {
                result += leftMax - height[left++];
                if (left <= right) {
                    result += rightMax - height[right--];
                }
            }
        }
        return result;
    }


    /**
     * <a href = "https://juejin.cn/post/7323271675331084315">接雨水的四种姿势</a>
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                result += width * h;
            }
            stack.push(i);
        }
        return result;
    }



    public int trap001(int[] height) {
        int length = height.length;
        int[] leftMaxArr = new int[length];
        int[] rightMaxArr = new int[length];
        int leftMax = height[0];
        for (int i = 0; i < length; i ++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxArr[i] = leftMax;
        }
        int rightMax = height[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMaxArr[i] = rightMax;
        }

        int result = 0;
        for (int i = 0; i < length; i ++) {
            if (height[i] < leftMaxArr[i] && height[i] < rightMaxArr[i]) {
                result+=Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            }
        }
        return result;
    }


    public int trap002(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while (left < right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }


    public int trap003(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                result += width * h;
            }
            stack.push(i);
        }
        return result;
    }

}
