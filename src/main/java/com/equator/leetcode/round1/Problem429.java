package com.equator.leetcode.round1;

import com.equator.datastruct.tree.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/19 21:00
 **/

public class Problem429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Node> nodeList = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<Integer> ansItem = new LinkedList<>();
            // nodeList.size 会变化，要用一个变量保存起来
            for (int i = 0, size = nodeList.size(); i < size; i++) {
                Node node = nodeList.poll();
                ansItem.add(node.val);
                nodeList.addAll(node.children);
            }
            ans.add(ansItem);
        }
        return ans;
    }
}
