package com.equator.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Equator
 * @Date: 2020/3/20 10:45
 **/

public class Problem819 {
    private static String reg = "(\\!)|(\\?)|(\\')|(\\,)|(\\;)|(\\.)";

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        String[] strings = paragraph.split("(\\!)|(\\?)|(\\')|(\\,)|(\\;)|(\\.)|(\\s)");
        for (String s : strings) {
            if (s.equals("")) {
                continue;
            }
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(s);
            String str = matcher.replaceAll("");
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                Integer times = map.get(str);
                map.put(str, times + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxString = null;
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!bannedSet.contains(key)) {
                if (value > max) {
                    maxString = key;
                    max = value;
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        String[] banned = {"a"};
        System.out.println(new Problem819().mostCommonWord("a, a, a, a, b,b,b,c, c", banned));
    }

    @Test
    public void test() {
        String reg = "(!)|(,)";
        String input = "hello world! I am lee!,,";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        String str = matcher.replaceAll("");
        System.out.println(str);
    }
}
