package com.equator.datastruct;

/**
 * 实现一个整形数组
 *
 * @Author: Equator
 * @Date: 2020/3/14 14:35
 **/

public class MyIntArray {
    int[] data;
    private int size;

    // 创建指定容量大小的数组
    public MyIntArray(int capacity) {
        if (capacity > 0) {
            data = new int[capacity];
            size = 0;
        }
    }

    // 创建默认容量为16的数组
    public MyIntArray() {
        this(16);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
