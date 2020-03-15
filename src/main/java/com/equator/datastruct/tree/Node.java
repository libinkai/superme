package com.equator.datastruct.tree;

import java.util.List;

/**
 * 多叉树
 * @Author: Equator
 * @Date: 2020/1/19 21:30
 **/

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}