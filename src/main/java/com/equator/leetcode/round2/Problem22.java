package com.equator.leetcode.round2;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/4/9 20:18
 **/

public class Problem22 {
    List<String> res = new LinkedList<>();

    // 如果是这种二分选择的一般可以暴力搜索
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, str + "(");
        }
        if (right > left) {
            dfs(left, right - 1, str + ")");
        }
    }
}
