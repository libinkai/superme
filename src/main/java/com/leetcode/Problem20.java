package com.leetcode;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/18 7:39
 **/

public class Problem20 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '(' || charArray[i] == '[') {
                stack.push(charArray[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (!((temp == '{' && charArray[i] == '}') || (temp == '(' && charArray[i] == ')') || (temp == '[' && charArray[i] == ']'))) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
