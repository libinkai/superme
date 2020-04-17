package com.equator.leetcode.round1;

import java.util.*;

/**
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的（看清楚题目哥哥！）
 *
 * @Author: Equator
 * @Date: 2020/3/22 9:34
 **/

public class Problem884 {
    public String[] uncommonFromSentences0(String A, String B) {
        String[] Astrs = A.split(" ");
        String[] Bstrs = B.split(" ");
        List<String> res = new LinkedList<>();
        Map<String, Integer> Amap = fillMap(Astrs);
        Map<String, Integer> Bmap = fillMap(Bstrs);
        for (Map.Entry<String, Integer> entry : Amap.entrySet()) {
            String Akey = entry.getKey();
            Integer Avalue = entry.getValue();
            if (!Bmap.containsKey(Akey) && Avalue == 1) {
                res.add(Akey);
            }
        }
        for (Map.Entry<String, Integer> entry : Bmap.entrySet()) {
            String Bkey = entry.getKey();
            Integer Bvalue = entry.getValue();
            if (!Amap.containsKey(Bkey) && Bvalue == 1) {
                res.add(Bkey);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private Map<String, Integer> fillMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                Integer n = map.get(s);
                map.put(s, n + 1);
            }
        }
        return map;
    }

    // 全局思维！
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new LinkedList<>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                res.add(entry.getKey());
//            }
//        }
        for (String k : map.keySet()) {
            if (map.get(k) == 1) {
                res.add(k);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem884().uncommonFromSentences("apple apple", "banana")));
    }
}
