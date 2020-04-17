package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/24 9:37
 **/

public class Problem788 {
    // 暴力法，规规矩矩法
    public int rotatedDigits0(int N) {
        int c = 0;
        for (int i = 1; i <= N; i++) {
            if (judge(i)) {
                c++;
            }
        }
        return c;
    }

    private boolean judge(int n) {
        int source = n;
        int len = getNumLength(n);
        int rotatedNum = 0;
        while (len > 0) {
            int r = rotate((int) (n / Math.pow(10, len - 1)));
            if (r == -1) {
                return false;
            }
            n %= Math.pow(10, len - 1);
            rotatedNum = rotatedNum * 10 + r;
            len--;
        }
        return rotatedNum != source;
    }

    private int getNumLength(int n) {
        return String.valueOf(n).length();
    }

    /**
     * 0, 1, 和 8 被旋转后仍然是它们自己
     * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像），6 和 9 同理
     * 除了这些以外其他的数字旋转以后都不再是有效的数字
     */
    private int rotate(int i) {
        switch (i) {
            case 0:
            case 1:
            case 8:
                return i;
            case 2:
                return 5;
            case 5:
                return 2;
            case 6:
                return 9;
            case 9:
                return 6;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("答案：" + new Problem788().rotatedDigits(9));
    }

    // 动态规划，或者说是记忆化搜索（末位以外的数字在计算该数字前肯定计算过，妙！）
    public int rotatedDigits(int N) {
        // dp[i]对应有三个值，1是好数，0是普数，-1是坏数
        int[] tmp = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        if (N < 10) {
            int sum = 0;
            for (int i = 0; i <= N; i++) {
                if (tmp[i] == 1) {
                    sum++;
                }
            }
            return sum;
        }
        int[] dp = new int[N + 1];
        dp[3] = dp[4] = dp[7] = -1;
        dp[0] = dp[1] = dp[8] = 0;
        dp[2] = dp[5] = dp[6] = dp[9] = 1;
        int num = 0;
        // dp[i % 10]末位，dp[(int) Math.floor(i / 10)]除末位之外的部分
        for (int i = 0; i <= N; i++) {
            if (dp[i % 10] == -1 || dp[(int) Math.floor(i / 10)] == -1) {
                dp[i] = -1;
            } else {
                dp[i] = dp[i % 10] | dp[(int) Math.floor(i / 10)];
            }
            if (dp[i] == 1) {
                num++;
            }
        }
        return num;
    }
}
