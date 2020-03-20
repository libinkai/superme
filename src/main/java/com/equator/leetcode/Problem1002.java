package com.equator.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/3/20 11:46
 **/

public class Problem1002 {
    public List<String> commonChars(String[] A) {
        int[] counter = new int[26];
        for (char c : A[0].toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempCounter = new int[26];
            for (char c : A[i].toCharArray()) {
                tempCounter[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (tempCounter[j] < counter[j]) {
                    counter[j] = tempCounter[j];
                }
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (counter[i] > 0) {
                res.add("" + (char) ('a' + i));
                counter[i]--;
            }
        }
        return res;
    }
}
