package com.chen.leetcode.hot.topics100;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @author chenbjf
 * @since 2025-05-12 11:25
 */
public class HotTopics0014 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> result = new ArrayList<>();
        int[] arr = intervals[0];
        for (int i = 1; i < intervals.length; i ++) {
            int[] tempArr = intervals[i];
            if (tempArr[0] <= arr[1]) {
                arr[1] = Math.max(tempArr[1], arr[1]);
            } else {
                result.add(arr);
                arr = tempArr;
            }
        }
        result.add(arr);
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        HotTopics0014 hotTopics0014 = new HotTopics0014();
        System.out.println(hotTopics0014.merge(arr));
    }
}
