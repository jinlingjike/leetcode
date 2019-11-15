package com.gapon.leetcode.algorithm.test;

import java.util.PriorityQueue;

// 这是堆排序算法的一个实现，类名在这里并不重要
public class Heapify {
    /**
     * 这是一个堆排序算法
     */
    private static void heapify(int[] beSorteds) {
        int size = beSorteds.length;
        /*
         * 1、首先从当前参与排序的 完全二叉树的最后一个非叶子节点开始进行计算，也就是 (effectiveScope >> 1) - 1的索引位
         * 2、依次遍历这些非叶子节点，并基于大顶堆算法将当前非叶子节点、非叶子节点的左儿子、右儿子，进行比较交换
         * 3、第2步是需要循环完成的，每次完成以上过程后，0号索引位上的值就是最大了，然后和effectiveScope - 1的索引位进行交换
         * */

        // 步骤1：
        // effectiveScope变量，代表参与当前排序过程所有结点的总数量
        for(int effectiveScope = size ; effectiveScope > 1 ; effectiveScope--) {
            // 步骤2：
            for(int currentParent = (effectiveScope >> 1) - 1 ; currentParent >= 0 ; currentParent--) {
                // 获取左儿子和右儿子的理论索引位
                int leftChild = (currentParent << 1) + 1;
                int rightChild = leftChild + 1;
                int n;
                // 首先看左儿子的值大，还是右儿子的值大
                if(rightChild < effectiveScope && beSorteds[rightChild] > beSorteds[leftChild]) {
                    n = rightChild;
                } else {
                    n = leftChild;
                }
                // 然后比较，值较大的这个儿子和父节点哪个更大，如果后者更大就不进行交换了，否则就要交换
                if(beSorteds[n] > beSorteds[currentParent]) {
                    int c = beSorteds[currentParent];
                    beSorteds[currentParent] = beSorteds[n];
                    beSorteds[n] = c;
                }
            }

            // 步骤3：
            int c = beSorteds[effectiveScope - 1];
            beSorteds[effectiveScope - 1] = beSorteds[0];
            beSorteds[0] = c;
        }
    }

    // 通过以上堆排序算法的计算，输入的原始数组
    // 11 , 88 , 8 , 19 , 129 , 33 , 44 , 22 , 77 , 55 , 505 , 15 , 198 , 189  , 200
    // 输出的排序后的数组值为：
    // 8 , 11 , 15 , 19 , 22, 33, 44, 55, 77 , 88 , 129 , 189 , 198 , 200 , 505
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 向priorityQueue集合添加数据
        priorityQueue.add(11);
        priorityQueue.add(88);
        priorityQueue.add(8);
        priorityQueue.add(19);
        priorityQueue.add(129);
        priorityQueue.add(33);
        priorityQueue.add(44);
        priorityQueue.add(22);
        priorityQueue.add(77);
        priorityQueue.add(55);
        priorityQueue.add(505);
        priorityQueue.add(15);
        priorityQueue.add(198);
        priorityQueue.add(189);
        priorityQueue.add(200);
        // 从priorityQueue集合移除数据
        for (int index = 0 ; index < priorityQueue.size() ; ) {
            System.out.println("priorityQueue item = " + priorityQueue.poll());
        }

    }
}
