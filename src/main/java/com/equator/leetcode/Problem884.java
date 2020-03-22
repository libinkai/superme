package com.equator.leetcode;

import java.util.*;

/**
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的（看清楚题目哥哥！）
 *
 * @Author: Equator
 * @Date: 2020/3/22 9:34
 **/

public class Problem884 {
    public String[] uncommonFromSentences(String A, String B) {
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem884().uncommonFromSentences("apple apple", "banana")));
    }
}
