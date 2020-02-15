package com.leetcode.sword;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/2/15 15:17
 **/

public class Problem9 {
    class CQueue {
        Stack<Integer> master, slave;

        public CQueue() {
            master = new Stack<>();
            slave = new Stack<>();
        }

        public void appendTail(int value) {
            master.push(value);
        }

        public int deleteHead() {
            if (slave.isEmpty()) {
                while (!master.isEmpty()) {
                    slave.push(master.pop());
                }
            }
            return slave.isEmpty() ? -1 : slave.pop();
        }
    }
}
