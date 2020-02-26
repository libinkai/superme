package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 20:26
 **/

public class Problem44 {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            long numbers = countOfInt(digits);
            // numbers * digits 该区间一共多少位
            if (n < numbers * digits) {
                return getIntAtIdx(n, digits);
            }
            n -= numbers * digits;
            digits++;
        }
    }

    /**
     * @param idx
     * @param digits
     * @return
     */
    private int getIntAtIdx(int idx, int digits) {
        // 目标所在的数
        long number = firstInt(digits) + idx / digits;
        int idxFromRight = digits - idx % digits;
        // 从后面取
        for (int i = 1; i < idxFromRight; i++) {
            number /= 10;
        }
        return (int) (number % 10);
    }

    /**
     * 计算digits位的数字个数 1：0~9（10），2：10~99（90），3：100~999（900）
     *
     * @param digits
     * @return
     */
    private long countOfInt(int digits) {
        if (digits == 1) {
            return 10;
        }
        long count = (long) Math.pow(10, digits - 1);
        return 9 * count;
    }

    /**
     * 获取指定位数的第一个数字
     *
     * @param digits
     * @return
     */
    private long firstInt(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (long) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Problem44().findNthDigit(1000000000));
    }
}
