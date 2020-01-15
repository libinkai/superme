package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/1/14 12:04
 **/

public class Test {
    public void test1() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> li1 = new LinkedList<>();
        li1.add(1);
        li1.add(2);
        li1.add(3);
        set.add(li1);

        List<Integer> li2 = new LinkedList<>();
        li2.add(1);
        li2.add(2);
        li2.add(4);
        System.out.println(set.contains(li2));
    }

    public static void main(String[] args) {
        new Test().test1();
    }
}
