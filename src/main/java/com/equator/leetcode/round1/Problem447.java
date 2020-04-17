package com.equator.leetcode.round1;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/2/7 12:37
 **/

public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        int num = 0, distance;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                // distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                // num += 2 * map.getOrDefault(distance, 0);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            Iterator<Integer> iterator = map.values().iterator();
            while (iterator.hasNext()) {
                int t = iterator.next();
                if (t >= 2) {
                    num += t * (t - 1);
                }
            }
        }
        return num;
    }
}
