package com.equator.leetcode;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/3/1 16:12
 **/

public class Problem690 {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return bfs(map, map.get(id));
    }

    private int bfs(Map<Integer, Employee> map, Employee root) {
        if (root == null) {
            return 0;
        }
        Deque<Employee> queue = new LinkedList<>();
        queue.add(root);
        int total = 0;
        while (!queue.isEmpty()) {
            Employee node = queue.remove();
            System.out.println(node);
            total += node.importance;
            for (Integer subordinateId : node.subordinates) {
                System.out.println(subordinateId);
                queue.add(map.get(subordinateId));
            }
            System.out.println(map.size());
        }
        return total;
    }
}
