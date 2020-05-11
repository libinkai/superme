package com.equator.leetcode.round2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/5/12 7:32
 **/

public class Solution155 {
    class MinStack {
        Deque<Integer> master = new LinkedList<>();
        Deque<Integer> slave = new LinkedList<>();

        public MinStack() {

        }

        public void push(int x) {
            if (slave.isEmpty()) {
                slave.addLast(x);
            } else if (x < slave.peekLast()) {
                slave.addLast(x);
            } else {
                slave.addLast(slave.peekLast());
            }
            master.addLast(x);
        }

        public void pop() {
            master.pollLast();
            slave.pollLast();
        }

        public int top() {
            return master.peekLast();
        }

        public int getMin() {
            return slave.peekLast();
        }
    }
}
