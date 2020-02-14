package com.nowcoder.sword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/2/14 22:39
 **/

public class Problem3 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        return false;
    }
}
