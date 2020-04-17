package com.equator.leetcode.round1.sword;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/2/20 9:57
 **/

public class Problem30 {
    // 最值栈：设置辅助栈，辅助栈与数据栈size一致，辅助栈保存当前每一次push时的最值
    class MinStack {
        Stack<Integer> master, slave;

        public MinStack() {
            master = new Stack<>();
            slave = new Stack<>();
        }

        public void push(int x) {
            if (slave.isEmpty() || x < slave.peek()) {
                slave.push(x);
            } else {
                slave.push(slave.peek());
            }
            master.push(x);
        }

        public void pop() {
            if (master.isEmpty() || slave.isEmpty()) {
                return;
            }
            master.pop();
            slave.pop();
        }

        public int top() {
            if (master.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return master.peek();
        }

        public int min() {
            if (slave.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return slave.peek();
        }
    }
}
