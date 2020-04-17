package com.equator.leetcode.round1;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/17 11:22
 **/

public class Problem1160 {
    public int countCharacters(String[] words, String chars) {
        if (chars == null || "".equals(chars)) {
            return 0;
        }
        char[] charArray = chars.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a']++;
        }
        if (words == null || words.length == 0) {
            return 0;
        }
        int len = 0;
        for (String word : words) {
            int[] copyOfMap = Arrays.copyOf(map, map.length);
            char[] wordChars = word.toCharArray();
            int tempCount = 0;
            for (char wordChar : wordChars) {
                if (copyOfMap[wordChar - 'a'] > 0) {
                    copyOfMap[wordChar - 'a']--;
                    tempCount++;
                } else {
                    break;
                }
            }
            if (tempCount == word.length()) {
                len += tempCount;
            }
        }
        return len;
    }
}
