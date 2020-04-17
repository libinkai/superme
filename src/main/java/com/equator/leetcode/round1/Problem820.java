package com.equator.leetcode.round1;

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
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        int len = 0;
        Trie trie = new Trie();
        for (String word : words) {
            // 倒着插入
            if (!trie.startsWith(reverse(word))) {
                len += word.length() + 1;
                trie.insert(reverse(word));
            }
        }
        return len;
    }

    private String reverse(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
        return new String(chars);
    }
}
