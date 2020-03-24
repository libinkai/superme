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
        System.out.println("答案：" + new Problem788().rotatedDigits(10));
    }
}
