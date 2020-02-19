package com.equator.leetcode.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * add，remove，element，旧的方法，会抛出异常
 * offer，poll，peek，新的方法，返回默认值
 *
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

    static class CStack {
        Deque master, slave;

        public CStack() {
            master = new LinkedList<>();
            slave = new LinkedList<>();
        }

        public void push(int val) {
            master.add(val);
        }

        public int pop() {
            if (master.isEmpty()) {
                return -1;
            }
            while (master.size() > 1) {
                slave.add(master.removeFirst());
            }
            Integer top = (Integer) master.removeFirst();
            Deque temp = master;
            master = slave;
            slave = temp;
            return top;
        }
    }

    public static void main(String[] args) {
        CStack stack = new CStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }
    }
}
