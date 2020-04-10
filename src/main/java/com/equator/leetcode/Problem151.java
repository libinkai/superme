package com.equator.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/4/10 15:42
 **/

public class Problem151 {
    // 随缘打卡，还有一个思路是两遍反转
    public String reverseWords(String s) {
        if ("".equals(s) || s == null) {
            return "";
        }
        Deque<String> stack = new LinkedList<>();
        for (String word : s.split(" ")) {
            if (!"".equals(word)) {
                stack.addLast(word.trim());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                sb.append(stack.pollLast());
            } else {
                sb.append(stack.pollLast() + " ");
            }
        }
        return sb.toString();
    }
}
