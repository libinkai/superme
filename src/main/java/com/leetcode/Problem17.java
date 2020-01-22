package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/1/22 14:24
 **/

public class Problem17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        Map<Character, String> numberToChar = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new LinkedList<>();
        search(numberToChar, ans, digits, 0, "");
        return ans;
    }

    public void search(Map<Character, String> numberToChar, List<String> ans, String digits, int level, String current) {
        if (level == digits.length()) {
            ans.add(current);
            return;
        }
        String letters = numberToChar.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            search(numberToChar, ans, digits, level + 1, current + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem17().letterCombinations("23"));
    }
}
