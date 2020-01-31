package com.leetcode;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/1/31 9:04
 **/

public class Problem146 {
    /* 使用java的双向队列，remove自身复杂度为O(n)
    class LRUCache {
        class Node {
            private int key, val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int capacity;
        private Map<Integer, Node> map;
        private Deque<Node> list;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            list = new LinkedList<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                list.remove(map.get(key));
                list.addFirst(node);
                map.put(key, node);
            } else {
                if (map.size() == capacity) {
                    Node last = list.removeLast();
                    map.remove(last.key);
                }
                map.put(key, node);
                list.addFirst(node);
            }
        }
    }
    */

    class LRUCache {
        class Node {
            private int key, val;
            private Node prev, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        // 实现一个可以O(1)时间内remove指定节点的双向链表
        class DoubleList {
            private int size;
            private Node head, tail;

            public DoubleList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
                size++;
            }

            public Node removeLast() {
                if (tail.prev == head) {
                    return null;
                }
                Node last = tail.prev;
                remove(last);
                return last;
            }

            // O(1) 时间复杂度内实现删除
            public void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            public int getSize() {
                return size;
            }
        }

        private int capacity;
        private Map<Integer, Node> map;
        private DoubleList doubleList;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            doubleList = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                doubleList.remove(map.get(key));
                doubleList.addFirst(node);
                map.put(key, node);
            } else {
                if (capacity == doubleList.size) {
                    Node last = doubleList.removeLast();
                    map.remove(last.key);
                }
                doubleList.addFirst(node);
                map.put(key, node);
            }
        }
    }
}
