package com.equator.leetcode.round1.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/26 10:05
 **/

public class Problem62 {
    public int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 第一次删除的数字下标为(m-1)%n记为c，之后每一次删除的数字下标均为(c+m-1)%queue.size()
        int idx = (m - 1) % n;
        while (list.size() > 1) {
            list.remove(idx);
            idx = (idx + m - 1) % list.size();
        }
        return list.get(0);
    }
}
