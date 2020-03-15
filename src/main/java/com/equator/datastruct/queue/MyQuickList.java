package com.equator.datastruct.queue;

/**
 * 数组实现队列，O(1)时间内插入与删除数据
 *
 * @Author: Equator
 * @Date: 2020/3/11 19:14
 **/

public class MyQuickList {
    int[] data;
    int capacity = 0, size = 0;
    int head = 0, tail = 0;

    public MyQuickList(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public boolean add(int val) {
        if (size == capacity) {
            return false;
        }
        data[tail] = val;
        tail++;
        size++;
        if (tail == capacity) {
            tail = 0;
        }
        return true;
    }

    public int remove() throws Exception {
        if (size == 0) {
            throw new Exception();
        }
        int headVal = data[head];
        head++;
        size--;
        if (head == capacity) {
            head = 0;
        }
        return headVal;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
