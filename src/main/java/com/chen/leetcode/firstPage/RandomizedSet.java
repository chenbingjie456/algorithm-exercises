package com.chen.leetcode.firstPage;

import java.util.*;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 16:39
 */
public class RandomizedSet {

    List<Integer> nums;

    Map<Integer, Integer> idxMap;

    int lastIndex;

    Random random = new Random();

    public RandomizedSet() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        lastIndex = 0;
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        } else {
            nums.add(lastIndex, val);
            idxMap.put(val, lastIndex);
            lastIndex++;
            return true;
        }
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        } else {
            int idx = idxMap.get(val);
            idxMap.remove(val);
            if (idx != lastIndex - 1) {
                nums.set(idx, nums.get(lastIndex - 1));
                idxMap.put(nums.get(idx), idx);
            }
            lastIndex--;
            return true;
        }
    }

    public int getRandom() {
        int randomIndex = random.nextInt(lastIndex);
        return nums.get(randomIndex);
    }

    //["RandomizedSet","insert","remove","remove","insert","getRandom","remove"]
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.remove(3);
        randomizedSet.remove(0);
        randomizedSet.insert(3);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(0);
    }
}
