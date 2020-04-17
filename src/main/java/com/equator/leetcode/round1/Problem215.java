package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/3/23 8:30
 **/

public class Problem215 {
    // 插入排序
    class InsertSortContainer {
        private int size, capacity;
        private int[] data;

        public InsertSortContainer(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.data = new int[capacity];
        }

        public void add(int e) {
            if (size == 0) {
                data[size] = e;
                size++;
                return;
            }
            if (size == capacity && e < data[size - 1]) {
                return;
            }
            data[size == capacity ? capacity - 1 : size] = e;
            if (size < capacity) {
                size++;
            }
            sort();
        }

        private void sort() {
            for (int i = 1; i < size; i++) {
                int tmp = data[i];
                int j = i;
                while (j > 0 && tmp > data[j - 1]) {
                    data[j] = data[j - 1];
                    j--;
                }
                if (j != i) {
                    data[j] = tmp;
                }
            }
        }

        public int getMaximum() {
            if (size == 0) {
                throw new RuntimeException("data is empty !");
            }
            return data[0];
        }

        public int getMinimum() {
            if (size == 0) {
                throw new RuntimeException("data is empty !");
            }
            return data[size - 1];
        }
    }

    // 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
    public int findKthLargest(int[] nums, int k) {
        InsertSortContainer container = new InsertSortContainer(k);
        for (int num : nums) {
            container.add(num);
        }
        return container.getMinimum();
    }

    @Test
    public void test0() {
        InsertSortContainer container = new InsertSortContainer(4);
        container.add(3);
        container.add(2);
        container.add(1);
        container.add(5);
        container.add(6);
        container.add(4);
        System.out.println(container.getMinimum());
    }

    @Test
    public void test1() {
        InsertSortContainer container = new InsertSortContainer(2);
        container.add(1);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(3);
        System.out.println(container.getMinimum());
    }
}
