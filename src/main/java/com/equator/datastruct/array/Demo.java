package com.equator.datastruct.array;

import com.equator.datastruct.stack.MyGenericStack;

/**
 * @Author: Equator
 * @Date: 2020/3/14 22:50
 **/

public class Demo {
    public static void main(String[] args) {
        MyGenericStack<Integer> myGenericStack = new MyGenericStack<>();
        myGenericStack.push(1);
        myGenericStack.push(2);
        myGenericStack.push(3);
        myGenericStack.push(4);
        myGenericStack.push(5);
        while (!myGenericStack.isEmpty()) {
            System.out.println(myGenericStack.pop());
        }
    }
}
