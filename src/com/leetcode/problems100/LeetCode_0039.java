package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/7 15:49
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combintionNums(candidates, target,0, result, null);
        return result;
    }

    private void combintionNums(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> array) {
        if(i < candidates.length) {
            if (array == null) {
                int k = i;
                while (k < candidates.length) {
                    List<Integer> list = new ArrayList<>();
                    if (candidates[k] == target) {
                        list.add(candidates[k]);
                        result.add(list);
                    } else if(candidates[k] < target) {
                        list.add(candidates[k]);
                        combintionNums(candidates, target, k, result, list);
                    }
                    k++;
                }
            } else {
                int k = i;
                while (k < candidates.length) {
                    int sum = sumList(array, candidates[k]);
                    if (sum == target) {
                        List<Integer> rr = new ArrayList<>(array);
                        rr.add(candidates[k]);
                        result.add(rr);
                    } else if (sum < target) {
                        List<Integer> rr = new ArrayList<>(array);
                        rr.add(candidates[k]);
                        combintionNums(candidates, target, k, result, rr);
                    }
                    k++;
                }
            }
        }
    }
    private int sumList(List<Integer> array, int value) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum = sum + array.get(i);
        }
        return sum + value;
    }

    public static void main(String[] args) {
        LeetCode_0039 leetCode_0039 = new LeetCode_0039();
        int[] candidates = {2,3,5};
        System.out.println(leetCode_0039.combinationSum(candidates, 8));
    }
}
