package com.equator.leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/22 14:30
 **/

public class Problem40 {
    class Heap {
        private int[] heap;
        private int capacity;
        private int size;
        private boolean build = false;

        public Heap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }

        public boolean append(int val) {
            if (size == capacity) {
                if (!build) {
                    for (int i = (capacity - 2) / 2; i >= 0; i--) {
                        heapify(i);
                    }
                    build = true;
                }
                if (val < heap[0]) {
                    heap[0] = val;
                    heapify(0);
                    return true;
                } else {
                    return false;
                }
            } else {
                heap[size] = val;
                size++;
                return true;
            }
        }

        private void heapify(int idx) {
            if (idx > capacity) {
                return;
            }
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int max = idx;
            if (left < capacity && heap[left] > heap[max]) {
                max = left;
            }
            if (right < capacity && heap[right] > heap[max]) {
                max = right;
            }
            if (max != idx) {
                swap(idx, max);
                heapify(max);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public int[] getValue() {
            return heap;
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }
        Heap heap = new Heap(k);
        for (int i : arr) {
            heap.append(i);
        }
        return heap.getValue();
    }

    public static void main(String[] args) {
        int[] nums = {11, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(new Problem40().getLeastNumbers(nums, 1)));
    }
}
