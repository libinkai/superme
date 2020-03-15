package com.equator.datastruct.queue;

/**
 * 数组实现队列，O(1)时间内插入与删除数据
 *
 * @Author: Equator
 * @Date: 2020/3/11 19:14
 **/

public class MyQuickQueue<E> implements MyQueue<E> {
    E[] data;
    int capacity = 0, size = 0;
    int head = 0, tail = 0;

    public MyQuickQueue() {
        this(16);
    }

    public MyQuickQueue(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        if (size == capacity) {
            return;
        }
        data[tail] = e;
        tail++;
        size++;
        if (tail == capacity) {
            tail = 0;
        }
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("queue is empty");
        }
        E headVal = data[head];
        head++;
        size--;
        if (head == capacity) {
            head = 0;
        }
        return headVal;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
