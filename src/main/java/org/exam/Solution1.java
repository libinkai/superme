package org.exam;

import java.util.Scanner;

/**
 * @Author: Equator
 * @Date: 2020/3/23 17:46
 **/

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long res = 0;
        for (long i = 1; i <= m; i++) {
            res += (count(m, i) * i);
            res = (long) (res % (10e9 + 7));
        }
        System.out.println(res);
    }

    // C n m
    private static long count(long m, long n) {
        long son = 1;
        for (long i = m; i >= n; i--) {
            son *= i;
            son = (long) (son % (10e9 + 7));
        }
        long mom = 1;
        for (long i = 1; i <= n; i++) {
            mom *= i% (10e9 + 7);
            mom = (long) (mom % (10e9 + 7));
        }
        return son / mom;
    }
}
