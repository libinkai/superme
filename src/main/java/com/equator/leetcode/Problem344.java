package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/2 22:10
 **/

public class Problem344 {
    public void reverseString(char[] s) {
        char temp;
        int i = 0, j = s.length - 1;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
