package com.equator.leetcode.round1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/18 8:07
 **/

public class Problem155 {
    // 错误的做法，这样无法实现最小栈的效果
    static class MinStack0 {
        List<Integer> list = new ArrayList<>();

        public MinStack0() {

        }

        public void push(int x) {
            list.add(new Integer(x));
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer val : list) {
                if (val < min) {
                    min = val;
                }
            }
            return min;
        }
    }

    // 两个栈：一个辅助栈
    static class MinStack1 {
        Stack<Integer> stack, helpStack;

        public MinStack1() {
            stack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!helpStack.empty()) {
                if (x <= helpStack.peek()) {
                    helpStack.push(x);
                }
            } else {
                helpStack.push(x);
            }
        }

        public void pop() {
            if (!stack.empty()) {
                if (stack.pop().equals(helpStack.peek())) {
                    helpStack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return helpStack.peek();
        }
    }

    // 一个栈：把次小值压栈
    static class MinStack2 {
        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                stack.push(x);
                min = x;
            } else {
                stack.push(x);
            }
        }

        public void pop() {
            /*if (stack.peek().equals(min)) {
                stack.pop();
                min = stack.pop();
            }else {
                stack.pop();
            }*/
            //简约代码如下：无论如何，至少要pop一次的
            if (stack.pop().equals(min)) {
                stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    // 差值，需要long类型
    static class MinStack {
        Stack<Long> stack;
        long min = Long.MAX_VALUE;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                min = x;
                stack.push(x - min);
            } else {
                stack.push(x - min);
                if (x < min) {
                    min = x;
                }
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            Long top = stack.pop();
            if (top < 0) {
                min = min - top;
            }
        }

        public int top() {
            Long top = stack.peek();
            if (top < 0) {
                return (int) min;
            } else {
                return (int) (top + min);
            }
        }

        public int getMin() {
            return (int) min;
        }
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
