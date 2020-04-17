package com.equator.exam;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import java.util.*;

/**
 * 牛客网导包 import java.util.*;
 * Math属于java.lang，不需要导包
 *
 * @Author: Equator
 * @Date: 2020/3/5 23:18
 **/

public class PageTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Math.min(1, 3);
        Deque<Integer> deque = new LinkedList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
}
