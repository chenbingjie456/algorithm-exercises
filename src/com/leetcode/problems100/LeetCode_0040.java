package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/14 19:55
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return null;
    }
/*
    private void searchList(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> array) {
        if (index < candidates.length) {
            if (array == null) {
                int k = index;
                while (k < candidates.length) {
                    if (target - candidates[k] == 0) {
                        List<Integer> rr = new ArrayList<>();
                        rr.add(candidates[k]);
                        result.add(rr);
                    } else if (target - candidates[k] > 0) {
                        List<Integer> rr = new ArrayList<>();
                        rr.add(candidates[k]);
                        searchList(candidates, target - candidates[k], k, result, rr);
                    }
                    k++;
                }
            } else  {
                int k = index;
                while ()
            }
        }
    }

 */
}
