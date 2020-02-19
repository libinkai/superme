package com.equator.leetcode;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/1/19 18:27
 **/

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = String.valueOf(charArray);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new LinkedList<>());
            }
            map.get(sortStr).add(str);
        }
        List<List<String>> lists = new LinkedList<>();
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            lists.add(iterator.next().getValue());
        }
        return lists;
    }
}
