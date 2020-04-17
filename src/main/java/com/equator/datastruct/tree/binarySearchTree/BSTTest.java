package com.equator.datastruct.tree.binarySearchTree;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/4/17 15:51
 **/

public class BSTTest {
    @Test
    public void test() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(41);
        bst.add(22);
        bst.add(58);
        bst.add(33);
        bst.add(50);
        bst.add(37);
        bst.add(42);
        bst.add(53);
        bst.levelOrder();
        System.out.println("-----");
        System.out.println(bst.removeMax());
        System.out.println("-----");
        System.out.println(bst.removeMin());
        System.out.println("-----");
        bst.levelOrder();
        System.out.println("-----");
        bst.remove(50);
        bst.levelOrder();
        System.out.println("-----");
    }
}
