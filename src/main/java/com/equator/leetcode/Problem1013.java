package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/11 9:37
 **/

public class Problem1013 {
    // 有的测试用例超出时间限制
    public boolean canThreePartsEqualSum0(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int left = 0, right = A.length - 1;
        int avg = sum / 3, leftSum = 0, rightSum = 0;
        while (left < right) {
            if (leftSum < avg) {
                leftSum += A[left];
            }
            if (rightSum < avg) {
                rightSum += A[right];
            }
            if (leftSum == avg && rightSum == avg) {
                int midSum = 0;
                for (int i = left + 1; i < right; i++) {
                    midSum += A[i];
                }
                if (midSum == avg) {
                    return true;
                }
            }
            if (leftSum < avg) {
                left++;
            }
            if (rightSum < avg) {
                right--;
            }
        }
        return false;
    }

    // 参考这个双指针解决超时问题
    public boolean canThreePartsEqualSum1(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if (leftSum != sum / 3) {
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if (rightSum != sum / 3) {
                // right = 0赋予了初值，应该先right++，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int avg = sum / 3, flag = 0, temp = 0;
        for (int a : A) {
            temp += a;
            if (temp == avg) {
                temp = 0;
                flag++;
            }
        }
        return flag >= 3;
    }

    public static void main(String[] args) {
        int[] sum = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println(new Problem1013().canThreePartsEqualSum(sum));
    }
}
