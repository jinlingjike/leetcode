package com.gapon.leetcode.algorithm.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //int[][]   intervals = new int[][]{{11,14},{15,16},{16,18},{0,0},{2,5},{3,6},{1,3}};
       // int[][]   intervals = new int[][]{{1,4},{0,2},{3,5}};
       // int[][]   intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][]   intervals = new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}};
        merge(intervals);

    }
        public  static  int[][] merge(int[][] intervals) {
            List<IntervalCheck>  intervallist = new ArrayList<IntervalCheck>();
            if (intervals.length == 0) {
                return new int[0][0];
            }

            for (int i = 0; i < intervals.length; i++) {
                IntervalCheck node = new IntervalCheck();
                IntervalCheck node2 = new IntervalCheck();
                node.key = intervals[i][0];
                node.flag = true;
                node2.key = intervals[i][1];
                node2.flag = false;
                intervallist.add(node);
                intervallist.add(node2);
            }
            List<Interval>  returnlist = new ArrayList<Interval>();
            Collections.sort(intervallist, new IntervalComparator());
            Interval interval = new Interval();
            interval.start = intervallist.get(0).key;
            int temp = intervallist.get(0).key;
            boolean flag = true;
            int m = 1;
            int n = 0;
            for(int i = 1 ;i<intervallist.size();i++){
                int tempi = intervallist.get(i).key;
                boolean flagi = intervallist.get(i).flag;
                if(flag == true && flagi == true ){
                     m++;
                    System.out.println("m= " + m);

                }else if(flag == false && flagi == false){
                    n++;
                    System.out.println("n= " + n);
                    interval.end = tempi ;
                }else if(flag == true && flagi == false){
                    n++;
                    System.out.println("n= " + n);
                    interval.end = tempi ;
                }else if(flag == false && flagi == true  &&  m != n  ){
                    m++;
                    System.out.println("m= " + m);
                }else if(flag == false && flagi == true  && tempi == temp &&  m == n  ){
                    m++;
                    System.out.println("m= " + m);
                } else if(flag == false && flagi == true && tempi != temp  &&  m == n  ){
                    returnlist.add(interval);
                    m = 1;
                    n = 0;
                    interval = new Interval();
                    interval.start = tempi ;
                }
                /*if(flagi == true && interval.start == Integer.MIN_VALUE){
                    interval.start = tempi ;
                }
                if(flagi == false && interval.end == Integer.MIN_VALUE){
                    interval.end = tempi ;
                }*/
                temp = intervallist.get(i).key;
                flag = intervallist.get(i).flag;
            }
            returnlist.add(interval);
            int[][] newIntervals = new int[returnlist.size()][2];
            for (int i = 0;i<returnlist.size();i++) {
                System.out.println(returnlist.get(i).start + " "+ returnlist.get(i).end);
                newIntervals[i][0] = returnlist.get(i).start;
                newIntervals[i][1] = returnlist.get(i).end;
            }

            return  newIntervals;
        }
        public static class IntervalCheck{
            int key;
            boolean flag = false;
        }
    public static class Interval {
        int start;
        int end;
        Interval() {
                start = Integer.MIN_VALUE;
                end = Integer.MIN_VALUE;
        }
    }
    public static class IntervalComparator   implements Comparator<IntervalCheck> {
        @Override
        public int compare(IntervalCheck a, IntervalCheck b) {
            return a.key < b.key ? -1 : a.key == b.key ? 0 : 1;
        }
    }
}
