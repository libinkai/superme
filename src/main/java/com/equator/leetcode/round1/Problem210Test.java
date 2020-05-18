package com.equator.leetcode.round1;

import java.util.*;

/**
 * 3
 * [[2,0],[2,1]] 用例无法通过
 *
 * @Author: Equator
 * @Date: 2020/3/23 16:26
 **/

public class Problem210Test {
    class Node {
        int id;
        int input = 0;
        List<Node> nextClass = new LinkedList<>();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 没有限制则全部可以修
        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = i;
            }
            return res;
        }
        Map<Integer, Node> idNodeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node();
            node.id = i;
            idNodeMap.put(i, node);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node preNode = idNodeMap.get(prerequisites[i][1]);
            Node nextNode = idNodeMap.get(prerequisites[i][0]);
            preNode.nextClass.add(nextNode);
            nextNode.input++;
        }
        List<Integer> res = new LinkedList<>();
        Set<Integer> marked = new HashSet<>();
        while (res.size() != numCourses) {
            boolean isZero = false;
            for (Node node : idNodeMap.values()) {
                if (!marked.contains(node.id) && node.input == 0) {
                    isZero = true;
                    res.add(node.id);
                    marked.add(node.id);
                    for (Node nextClass : node.nextClass) {
                        nextClass.input--;
                    }
                    break;
                }
            }
            if (!isZero) {
                break;
            }
        }
        if (res.size() != numCourses) {
            return new int[]{};
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int num = 4;
        int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new Problem210Test().findOrder(num, courses)));
    }
}
