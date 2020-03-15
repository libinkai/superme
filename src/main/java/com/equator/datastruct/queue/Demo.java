package com.equator.datastruct.queue;

/**
 * @Author: Equator
 * @Date: 2020/3/15 8:58
 **/

public class Demo {
    public static void main(String[] args) throws Exception {
        MyQuickList myQuickList = new MyQuickList(6);
        System.out.println(myQuickList.add(1));
        System.out.println(myQuickList.remove());
        System.out.println(myQuickList.add(2));
        System.out.println(myQuickList.add(3));
        System.out.println(myQuickList.remove());
        System.out.println(myQuickList.remove());
        System.out.println(myQuickList.add(4));
        System.out.println(myQuickList.add(5));
        System.out.println(myQuickList.add(6));
        System.out.println(myQuickList.add(7));
        System.out.println(myQuickList.add(8));
        System.out.println(myQuickList.add(9));
        while (!myQuickList.isEmpty()) {
            System.out.println(myQuickList.remove());
        }
        System.out.println("--------------------------------------------");
        MyCycleQueue<Integer> myCycleQueue = new MyCycleQueue<>(4);
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
