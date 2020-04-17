package com.equator.leetcode.round1.sword;

import java.util.PriorityQueue;

/**
 * 优先级队列的元素按照其自然顺序进行排序或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
 * 该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)
 *
 * @Author: Equator
 * @Date: 2020/2/26 23:22
 **/

public class Problem41 {
    class MedianFinder {
        private int size = 0;
        private PriorityQueue<Integer> left, right;

        public MedianFinder() {
            // 大顶堆
            left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            // 小顶堆
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if ((size & 1) == 0) {
                left.add(num);
                right.add(left.poll());
            } else {
                right.add(num);
                left.add(right.poll());
            }
            size++;
        }

        public double findMedian() {
            if ((size & 1) == 0) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return (double)right.peek();
            }
        }
    }
}
