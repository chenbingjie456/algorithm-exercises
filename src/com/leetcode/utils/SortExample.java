package com.leetcode.utils;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/26 10:21
 */
public class SortExample {


    /**
     * 归并排序
     * @param arrays
     * @return
     */
    public int[] mergeSort(int[] arrays) {
        int left = 0;
        int right = arrays.length -1;
        int[] tmpArray = new int[arrays.length];
        partingArray(arrays, left, right, tmpArray);
        return tmpArray;
    }


    private void  partingArray(int[] array, int left,  int right, int[] tmpArray) {
        if (right == left) {
            return;
        }
        int middle = left + (right - left) / 2;
        partingArray(array, left, middle, tmpArray);
        partingArray(array, middle + 1, right, tmpArray);

        int i = left; int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                tmpArray[k] = array[i];
                i++;
            } else {
                tmpArray[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            tmpArray[k] = array[i];
            k++; i++;
        }
        while(j <= right) {
            tmpArray[k] = array[j];
            k++; j++;
        }

        i = left;
        j = 0;
        while (j < k) {
            array[i] = tmpArray[j];
            i ++; j++;
        }
    }


    public static void main(String[] args) {
        SortExample sortExample = new SortExample();
        int[] arrays = {7, 15, 5, 6, 2, 15, 18, 22, 16, 5};
        int[] result = sortExample.mergeSort(arrays);
        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
