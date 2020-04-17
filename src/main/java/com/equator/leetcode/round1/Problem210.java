package com.equator.leetcode.round1;

import java.util.*;

/**
 * 3 [[1,0]] 用例无法通过
 *
 * @Author: Equator
 * @Date: 2020/3/23 16:26
 **/

public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 没有限制则全部可以修
        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = i;
            }
            return res;
        }
        // 课程有多少先修课
        Map<Integer, Integer> prevCourseCount = new HashMap<>();
        // 课程与它的第一级子课程
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int c = prerequisites[i][0];
            int p = prerequisites[i][1];
            prevCourseCount.put(c, prevCourseCount.getOrDefault(c, 0) + 1);
            prevCourseCount.put(p, prevCourseCount.getOrDefault(p, 0));
            if (courseMap.containsKey(p)) {
                List<Integer> list = courseMap.get(p);
                list.add(c);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(c);
                courseMap.put(p, list);
            }
        }
        int start = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : prevCourseCount.entrySet()) {
            Integer c = entry.getValue();
            if (c == 0) {
                start = entry.getKey();
                break;
            }
        }
        // 没有课程
        if (start == Integer.MIN_VALUE) {
            return new int[0];
        } else {
            List<Integer> res = new LinkedList<>();
            Set<Integer> studiedCourse = new HashSet<>();
            // BFS
            Deque<Integer> queue = new LinkedList<>();
            queue.addLast(start);
            while (!queue.isEmpty()) {
                Integer c = queue.pollFirst();
                if (!studiedCourse.contains(c)) {
                    queue.addAll(courseMap.getOrDefault(c, new LinkedList<>()));
                    res.add(c);
                    studiedCourse.add(c);
                }
            }
            if (res.size() != numCourses) {
                return new int[0];
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        int num = 3;
        int[][] courses = {{1, 0}};
        System.out.println(Arrays.toString(new Problem210().findOrder(num, courses)));
    }
}
