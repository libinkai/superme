package com.equator.datastruct.array;

import java.util.Arrays;

/**
 * 实现一个泛型动态数组
 *
 * @Author: Equator
 * @Date: 2020/3/14 14:35
 **/

public class MyGenericArray<E> {
    E[] data;
    // size 既是数组的当前持有元素的数量，也是数组中第一个没有元素的索引
    private int size;

    // 创建指定容量大小的数组
    public MyGenericArray(int capacity) {
        if (capacity > 0) {
            // 不支持这样的语法 data = new E[capacity];
            data = (E[]) new Object[capacity];
            size = 0;
        }
    }

    // 创建默认容量为16的数组
    public MyGenericArray() {
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

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 在指定位置插入元素
    public void add(int index, E e) {
        if (0 > index || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        // 为什么是两倍呢？这保证了新数组的容量与旧的数组容量在同一个数量级上
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        data[index] = e;
    }

    public int index(E e) {
        for (int i = 0; i < size; i++) {
            // 泛型数组，需要使用equals而不是==
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        if (index(e) == -1) {
            return false;
        }
        return true;
    }

    public E remove(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // help GC
        data[size] = null;
        size--;
        // 如果在data.length/2处进行缩小容量，如果在此处频繁做增减，有可能造成时间复杂度的震荡
        // 震荡的避免：在数组元素为容量的1/4时缩容一半，而不是在数组元素为容量的1/2时缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int idx = index(e);
        if (idx != -1) {
            remove(idx);
        }
    }

    @Override
    public String toString() {
        return "MyIntArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
