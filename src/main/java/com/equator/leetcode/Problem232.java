package com.equator.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/3/1 15:46
 **/

public class Problem232 {
    class MyQueue {
        Deque<Integer> master, slave;
        Integer head = null;

        public MyQueue() {
            master = new LinkedList<>();
            slave = new LinkedList<>();
        }

        public void push(int x) {
            if (master.isEmpty()) {
                head = x;
            }
            master.push(x);
        }

        public int pop() {
            if (slave.isEmpty()) {
                while (!master.isEmpty()) {
                    slave.push(master.pop());
                }
            }
            return slave.pop();
        }

        public int peek() {
            if (!slave.isEmpty()) {
                return slave.peek();
            }
            return head;
        }

        public boolean empty() {
            return master.isEmpty() && slave.isEmpty();
        }
    }
}
