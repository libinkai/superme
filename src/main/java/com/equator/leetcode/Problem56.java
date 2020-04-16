package com.equator.leetcode;

import com.equator.leetcode.util.ArrayPrinter;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/4/16 7:48
 **/

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Deque<int[]> res = new LinkedList<>();
        for (int[] interval : intervals) {
            // 如果结果集最后一个元素的右边界比当前区间的左边界小，直接加入结果集
            if (res.size() == 0 || res.peekLast()[1] < interval[0]) {
                res.addLast(interval);
            } else {
                //当前区间和结果集最后一个区间有重合，更新区间右边界即可
                int[] last = res.pollLast();
                last[1] = Math.max(last[1], interval[1]);
                res.addLast(last);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        System.out.println(ArrayPrinter.print(new Problem56().merge(arr)));
    }
}
