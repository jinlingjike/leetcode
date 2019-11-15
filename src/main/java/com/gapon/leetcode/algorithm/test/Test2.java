package com.gapon.leetcode.algorithm.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test2 {
    public static void main(String[] args) {
        LinkedList<Integer> items = new LinkedList<>();
        items.add(3);
        items.add(4);
        items.add(5);

        items.forEach(i -> {
            System.out.println(i);
        });
    }
}
