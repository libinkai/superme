package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/23 10:11
 **/

public class Problem860 {
    public boolean lemonadeChange(int[] bills) {
        // 5 10 20
        int[] moneyNum = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                moneyNum[0]++;
            } else if (bills[i] == 10) {
                if (moneyNum[0] > 0) {
                    moneyNum[0]--;
                    moneyNum[1]++;
                    continue;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (moneyNum[1] > 0 && moneyNum[0] > 0) {
                    moneyNum[0]--;
                    moneyNum[1]--;
                    moneyNum[2]++;
                    continue;
                } else if (moneyNum[0] >= 3) {
                    moneyNum[0] -= 3;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        new Problem860().lemonadeChange(bills);
    }
}
