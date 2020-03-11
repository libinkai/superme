package com.equator.datastruct.stack;

/**
 * @Author: Equator
 * @Date: 2020/3/11 18:36
 **/

public class MyStack {
    int[] data;
    int top = 0, size = 0, capacity = 0;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public boolean push(int val) {
        if (size == capacity) {
            return false;
        }
        data[top] = val;
        top++;
        size++;
        return true;
    }

    public int pop() throws Exception {
        if (top == 0) {
            throw new Exception();
        }
        size--;
        // 先减一再获取数据
        return data[--top];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(4);
        System.out.println(myStack.push(1));
        System.out.println(myStack.pop());
        System.out.println(myStack.push(2));
        System.out.println(myStack.push(3));
        System.out.println(myStack.pop());
        System.out.println(myStack.push(4));
        System.out.println(myStack.push(5));
        System.out.println(myStack.push(6));
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
