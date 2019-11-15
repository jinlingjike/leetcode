package com.gapon.leetcode.algorithm.stringUtils;

public class IntReverse {
    public static int reverse(int x) {

        int tmp;
        long  resp = 0 ;
        while(x != 0){
            tmp = x%10;
            resp = 10*resp + tmp;
            x = x/10;
        }
        if (resp > Integer.MAX_VALUE || resp < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)resp;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
