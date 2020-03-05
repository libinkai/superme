package com.equator.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/5 10:07
 **/

public class Problem1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int candy = 1;
        while (candies > 0) {
            for (int i = 0; i < res.length; i++) {
                res[i] += candy;
                candies -= candy;
                if (candies <= 0) {
                    return res;
                }
                if (candies < candy + 1) {
                    candy = candies;
                } else {
                    candy++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem1103().distributeCandies(7, 4)));
    }
}
