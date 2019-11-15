package com.gapon.leetcode.algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class Heapify4 {

    public  int[] QuickSort(int[] array, int start, int end) {
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    public  int partition(int[] array, int start, int end) {
        int smallIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public  void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public  List<Integer> sortArray(int[] nums) {
        QuickSort(nums,0,nums.length-1);
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (Integer s : nums) {
            resultList.add(s);
            System.out.print(s);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Heapify4 h = new Heapify4();
        int[] nums = {5,2,3,1};
        h.sortArray( nums);
    }

}
