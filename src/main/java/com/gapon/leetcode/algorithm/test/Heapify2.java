package com.gapon.leetcode.algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class Heapify2 {
    //当前非叶子结点的左儿子索引位 = 当前节点索引位 * 2 + 1，实际上更准确的说法是：当前节点索引位 << 1 + 1
    //当前非叶子结点的右儿子索引位 = 当前节点索引位 * 2 + 2，实际上更准确的说法是：当前节点索引位 << 1 + 2
    //当前结点的父节点索引位 = (当前节点索引位 - 1) / 2，实际上更准确的说法是：(当前节点索引位 - 1) >> 1
    //另一个关键点是，完全二叉树降维后形成的数组长度为n，只有数组的后半段是叶子节点，计算公式为 (n >> 1) - 1。
    /*
     * 1、首先从当前参与排序的 完全二叉树的最后一个非叶子节点开始进行计算，也就是 (effectiveScope >> 1) - 1的索引位
     * 2、依次遍历这些非叶子节点，并基于大顶堆算法将当前非叶子节点、非叶子节点的左儿子、右儿子，进行比较交换
     * 3、第2步是需要循环完成的，每次完成以上过程后，0号索引位上的值就是最大了，然后和effectiveScope - 1的索引位进行交换
     * */

    public static List<Integer> sortArray(int[] nums) {
        int size = nums.length;
        for (int effectiveScope = size; effectiveScope >0; effectiveScope--) {
            for (int currentParent = (effectiveScope>>1) -1; currentParent >= 0; currentParent--) {
                int leftChild = (currentParent << 1) + 1;
                int rightChild = leftChild + 1;
                int temp;
                if (rightChild < effectiveScope && nums[leftChild] < nums[rightChild]) {
                     temp = rightChild;
                } else {
                    temp = leftChild;
                }
                if (nums[currentParent] < nums[temp]) {
                    int flag = nums[currentParent];
                    nums[currentParent] = nums[temp];
                    nums[temp] = flag;
                }
            }
            int change = nums[effectiveScope - 1];
            nums[effectiveScope - 1] = nums[0];
            nums[0] = change;
        }
        List<Integer> resultList = new ArrayList<>(nums.length);
        for (Integer s : nums) {
            resultList.add(s);
            System.out.print(s);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sortArray( nums);
    }
}
