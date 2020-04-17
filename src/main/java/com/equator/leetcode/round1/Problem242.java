package com.equator.leetcode.round1;

import java.util.HashMap;

/**
 * @Author: Equator
 * @Date: 2020/1/19 18:08
 **/

public class Problem242 {
    // 字母异位词指字母相同，但排列不同的字符串 官方说完全一致的字符串也是字母异位词，我不敢苟同
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length() || s.equals(t)) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                continue;
            }
            map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem242().isAnagram("anagram", "nagaram"));
        System.out.println(new Problem242().isAnagram("rat", "car"));
    }
}
