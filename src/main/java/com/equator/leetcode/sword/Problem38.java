package com.equator.leetcode.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/2/26 23:05
 **/

public class Problem38 {
    Set<String> set = new HashSet<>();
    String str = null;
    boolean[] marked = null;

    public String[] permutation(String s) {
        if (s == null) {
            return new String[]{};
        }
        str = s;
        marked = new boolean[s.length()];
        travel("");
        return set.toArray(new String[s.length()]);
    }

    // 全排列 回溯
    private void travel(String cur) {
        if (cur.length() == str.length()) {
            set.add(cur);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            travel(cur + ch);
            marked[i] = false;
        }
    }
}
