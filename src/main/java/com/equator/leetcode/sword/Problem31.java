package com.equator.leetcode.sword;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/2/20 10:35
 **/

public class Problem31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if ((pushed == null && popped == null) || (pushed.length == 0 && popped.length == 0)) {
            return true;
        }
        if (pushed == null || popped == null || pushed.length == 0 || popped.length == 0 || pushed.length != popped.length) {
            return false;
        }
        int len = pushed.length, pushIndex = 0, popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (popIndex < len) {
            while (stack.isEmpty() || !stack.peek().equals(popped[popIndex])) {
                if (pushIndex >= len) {
                    break;
                }
                stack.push(pushed[pushIndex++]);
            }
            if (stack.pop() != popped[popIndex++]) {
                return false;
            }
        }
        return true;
    }
}
