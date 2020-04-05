package com.equator.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: Equator
 * @Date: 2020/4/5 18:09
 **/

public class Problem460 {
    class Node implements Comparable<Node> {
        Integer key, value, activity;
        long activityTime;

        public Node(Integer key, Integer value, Integer activity) {
            this.key = key;
            this.value = value;
            this.activity = activity;
            this.activityTime = System.nanoTime();
        }


        @Override
        public int compareTo(Node o) {
            if (activity.equals(o.activity)) {
                return (int) (activityTime - o.activityTime);
            }
            return activity - o.activity;
        }
    }

    class LFUCache {
        private PriorityQueue<Node> nodes;
        private HashMap<Integer, Node> nodeMap;
        private int capacity, size;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            if (capacity > 0) {
                nodes = new PriorityQueue<>(capacity);
            }
            nodeMap = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if (node == null) {
                return -1;
            } else {
                node.activity++;
                node.activityTime = System.nanoTime();
                nodes.remove(node);
                nodes.add(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            Node savedNode = nodeMap.get(key);
            if (savedNode == null) {
                if (size < capacity) {
                    Node node = new Node(key, value, 1);
                    nodes.add(node);
                    nodeMap.put(key, node);
                    size++;
                    return;
                }
                Node oldNode = nodes.poll();
                nodeMap.remove(oldNode.key);
                Node newNode = new Node(key, value, 1);
                nodeMap.put(key, newNode);
                nodes.add(newNode);
            } else {
                savedNode.value = value;
                savedNode.activity++;
                savedNode.activityTime = System.nanoTime();
                nodes.remove(savedNode);
                nodes.add(savedNode);
            }
        }
    }

    @Test
    public void test0() {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }

    @Test
    public void test1() {
        LFUCache cache = new LFUCache(0 /* capacity (缓存容量) */);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }

    @Test
    public void test2() {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }

    @Test
    public void testMap1() {
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(1, new Node(1, 6, 0));
        Node node0 = map.get(1);
        node0.activity++;
        Node node1 = map.get(1);
        System.out.println(node1.activity);
    }

    @Test
    public void testMap2() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        Integer val0 = map.get(1);
        val0++;
        Integer val1 = map.get(1);
        System.out.println(val1);
    }
}
