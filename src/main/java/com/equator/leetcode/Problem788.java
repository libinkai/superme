package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/24 9:37
 **/

public class Problem788 {
    public int rotatedDigits(int N) {
        int c = 0;
        for (int i = 1; i <= N; i++) {
            if (judge(i)) {
                System.out.println(i);
                c++;
            }
        }
        return c;
    }

    private boolean judge(int n) {
        int rn = reserveNum(n);
        String rotatedNum = "";
        while (rn > 0) {
            int r = rotate(rn % 10);
            if (r == -1) {
                return false;
            }
            rotatedNum = rotatedNum + r;
            rn /= 10;
        }
        System.out.println("rotatedNum：" + rotatedNum);
        return !String.valueOf(n).equals(rotatedNum);
    }

    private int reserveNum(int n) {
        int reserveNum = 0;
        while (n > 0) {
            reserveNum = reserveNum * 10 + n % 10;
            n /= 10;
        }
        return reserveNum;
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
        System.out.println("答案：" + new Problem788().rotatedDigits(10));
    }
}
