package com.equator.leetcode.round1.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/2/25 22:18
 **/

public class Problem59_2 {
    class MaxQueue {
        LinkedList<Integer> master;
        Deque<Integer> slave;

        public MaxQueue() {
            master = new LinkedList<>();
            slave = new LinkedList<>();
        }

        public int max_value() {
            return slave.isEmpty() ? -1 : slave.peekFirst();
        }

        public void push_back(int value) {
            master.add(value);
            while (!slave.isEmpty() && value > slave.peekLast()) {
                slave.pollLast();
            }
            slave.addLast(value);
        }

        public int pop_front() {
            if (master.isEmpty()) {
                return -1;
            }
            Integer pop = master.pollFirst();
            if (pop.equals(slave.peekFirst())) {
                slave.pollFirst();
            }
            return pop;
        }
    }
}
