package com.equator.datastruct.stack;

/**
 * @Author: Equator
 * @Date: 2020/3/11 18:36
 **/

public class MySimpleStack {
    int[] data;
    int top = 0, size = 0, capacity = 0;

    public MySimpleStack(int capacity) {
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
        MySimpleStack mySimpleStack = new MySimpleStack(4);
        System.out.println(mySimpleStack.push(1));
        System.out.println(mySimpleStack.pop());
        System.out.println(mySimpleStack.push(2));
        System.out.println(mySimpleStack.push(3));
        System.out.println(mySimpleStack.pop());
        System.out.println(mySimpleStack.push(4));
        System.out.println(mySimpleStack.push(5));
        System.out.println(mySimpleStack.push(6));
        while (!mySimpleStack.isEmpty()) {
            System.out.println(mySimpleStack.pop());
        }
    }
}
