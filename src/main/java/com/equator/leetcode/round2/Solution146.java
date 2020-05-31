package com.equator.leetcode.round2;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/5/25 10:18
 **/

public class Solution146 {
    class LRUCache {
        class Node {
            int key, val;
            Node pre, nxt;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class MyDeque {
            private Node head, tail;

            public MyDeque() {
                head = new Node(0, 0);
                tail = head;
            }

            public void add(Node node) {
                node.pre = tail;
                tail.nxt = node;
                tail = node;
                head.val++;
            }

            public Node removeFirst() {
                Node deleteNode = head.nxt;
                if (deleteNode == null) {
                    return null;
                }
                head.nxt = deleteNode.nxt;
                if (deleteNode.nxt != null) {
                    deleteNode.nxt.pre = head;
                }
                deleteNode.pre = null;
                deleteNode.nxt = null;
                head.val--;
                return deleteNode;
            }

            public void remove(Node node) {
                if (node.equals(tail)) {
                    tail = tail.pre;
                    tail.nxt = null;
                    node.pre = null;
                } else {
                    node.pre.nxt = node.nxt;
                    node.nxt.pre = node.pre;
                    node.pre = null;
                    node.nxt = null;
                }
                head.val--;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("size:[");
                sb.append(head.val);
                sb.append("]");
                Node p = head.nxt;
                while (p != null) {
                    sb.append(p.val);
                    sb.append("->");
                    p = p.nxt;
                }
                return sb.toString();
            }

            public int getSize() {
                return head.val;
            }
        }

        private int capacity;
        Map<Integer, Node> map = null;
        MyDeque myDeque = null;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            myDeque = new MyDeque();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                myDeque.remove(node);
                myDeque.add(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                myDeque.remove(map.get(key));

            } else if (myDeque.getSize() == capacity) {
                // System.out.println("full ...");
                Node firstNode = myDeque.removeFirst();
                map.remove(firstNode.key);
            } else {

            }
            map.put(key, node);
            myDeque.add(node);
        }
    }

    @Test
    public void testLRU() {
        LRUCache cache = new LRUCache(4);
        for (int i = 1; i < 10; i++) {
            System.out.println("add " + i);
            cache.put(i, i);
            System.out.println(cache.myDeque);
            System.out.println(cache.map.size());
            System.out.println("---------------");
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(cache.get(i));
        }
    }

    @Test
    public void testLRU1() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
    }

    @Test
    public void testLRU2() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    @Test
    public void testLRU3() {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
