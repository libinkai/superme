package com.equator.datastruct.array;

import com.equator.datastruct.stack.MyArrayStack;

/**
 * @Author: Equator
 * @Date: 2020/3/14 22:50
 **/

public class Demo {
    public static void main(String[] args) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();
        myArrayStack.push(1);
        myArrayStack.push(2);
        myArrayStack.push(3);
        myArrayStack.push(4);
        myArrayStack.push(5);
        while (!myArrayStack.isEmpty()) {
            System.out.println(myArrayStack.pop());
        }
    }
}
