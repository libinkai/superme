package com.equator.datastruct.queue;

import com.equator.datastruct.array.MyGenericArray;

/**
 * 实现一个数组队列 入队O(1)，出队O(n)
 * 注意一个泛型类实现一个泛型接口的写法
 *
 * @Author: Equator
 * @Date: 2020/3/15 7:47
 **/

public class MyArrayQueue<E> implements MyQueue<E> {

    private MyGenericArray<E> array;

    public MyArrayQueue(int capacity) {
        this.array = new MyGenericArray<>(capacity);
    }

    public MyArrayQueue() {
        this.array = new MyGenericArray<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
