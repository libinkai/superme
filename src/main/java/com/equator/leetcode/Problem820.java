package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/28 14:40
 **/

public class Problem820 {
    // 排序
    public int minimumLengthEncoding0(String[] words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        for (String word : words) {
            String str = word + "#";
            // 只需要判断有没有即可，不一定要在最后
            if (sb.lastIndexOf(str) == -1) {
                sb.append(str);
            }
        }
        return sb.toString().length();
    }

    // 字典树
    public int minimumLengthEncoding1(String[] words) {

    }
}
