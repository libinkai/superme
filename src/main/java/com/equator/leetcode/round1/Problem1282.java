package com.equator.leetcode.round1;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/3/20 12:24
 **/

public class Problem1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0) {
            return null;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                List<Integer> item = new LinkedList<>();
                item.add(i);
                map.put(groupSizes[i], item);
            } else {
                List<Integer> list = map.get(groupSizes[i]);
                list.add(i);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> peopleList = entry.getValue();
            List<Integer> item = new LinkedList<>();
            int idx = 0;
            for (Integer people : peopleList) {
                item.add(people);
                idx++;
                if (idx % key == 0) {
                    res.add(item);
                    item = new LinkedList<>();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 3, 3, 2};
        List<List<Integer>> list = new Problem1282().groupThePeople(nums);
        for (List<Integer> item : list) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }
}
