package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/20 6:52
 **/

public class Problem22 {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return ans;
    }

    public void generate(int left, int right, int max, String s) {
        if (left == max & right == max) {
            ans.add(s);
            return;
        }
        if (left < max) {
            generate(left + 1, right, max, s + "(");
        }
        if (right < left) {
            generate(left, right + 1, max, s + ")");
        }
    }
}
