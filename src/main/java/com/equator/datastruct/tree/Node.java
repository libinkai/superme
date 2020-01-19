package com.equator.datastruct.tree;

import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/19 21:30
 **/

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}