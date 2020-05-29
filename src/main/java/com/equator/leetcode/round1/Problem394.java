package com.equator.leetcode.round1;

import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/5/28 8:35
 **/

public class Problem394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_str = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_str.addLast(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curMulti = stack_multi.removeLast();
                for (int i = 0; i < curMulti; i++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(stack_str.removeLast() + temp);
            } else if ('0' <= c && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
