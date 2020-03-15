package com.equator.datastruct.queue;

/**
 * @Author: Equator
 * @Date: 2020/3/15 8:58
 **/

public class Demo {
    public static void main(String[] args) throws Exception {
        MyQuickQueue myQuickQueue = new MyQuickQueue(8);
        myQuickQueue.enqueue(1);
        System.out.println(myQuickQueue.dequeue());
        myQuickQueue.enqueue(2);
        myQuickQueue.enqueue(3);
        System.out.println(myQuickQueue.dequeue());
        System.out.println(myQuickQueue.dequeue());
        myQuickQueue.enqueue(4);
        myQuickQueue.enqueue(5);
        myQuickQueue.enqueue(6);
        myQuickQueue.enqueue(7);
        myQuickQueue.enqueue(8);
        myQuickQueue.enqueue(9);
        while (!myQuickQueue.isEmpty()) {
            System.out.println(myQuickQueue.dequeue());
        }
        System.out.println("--------------------------------------------");
        MyCycleQueue<Integer> myCycleQueue = new MyCycleQueue<>(8);
        myCycleQueue.enqueue(1);
        System.out.println(myCycleQueue.dequeue());
        myCycleQueue.enqueue(2);
        myCycleQueue.enqueue(3);
        System.out.println(myCycleQueue.dequeue());
        System.out.println(myCycleQueue.dequeue());
        myCycleQueue.enqueue(4);
        myCycleQueue.enqueue(5);
        myCycleQueue.enqueue(6);
        myCycleQueue.enqueue(7);
        myCycleQueue.enqueue(8);
        myCycleQueue.enqueue(9);
        while (!myCycleQueue.isEmpty()) {
            System.out.println(myCycleQueue.dequeue());
        }
    }
}
