package com.equator.leetcode.round1.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/26 20:18
 **/

public class Problem45 {
    public String minNumber(int[] nums) {
        List<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
        }
        strings.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
