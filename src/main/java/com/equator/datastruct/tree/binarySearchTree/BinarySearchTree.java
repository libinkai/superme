package com.equator.datastruct.tree.binarySearchTree;

/**
 * 该BST默认不包含重复元素，如果想要包含重复元素，需要包含重复元素的话，需要修改BST的定义：左子树小于等于根节点或者右子树大于等于根节点
 *
 * @Author: Equator
 * @Date: 2020/4/12 20:14
 **/

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * BST添加元素的非递归写法与链表添加节点类似
     * public void add(E e) {
     * if (root == null) {
     * root = new Node(e);
     * size++;
     * } else {
     * add(root, e);
     * }
     * }
     * <p>
     * private void add(Node node, E e) {
     * if (e.compareTo(node.e) < 0) {
     * if (node.left == null) {
     * node.left = new Node(e);
     * size++;
     * } else {
     * add(node.left, e);
     * }
     * } else if (e.compareTo(node.e) > 0) {
     * if (node.right == null) {
     * node.right = new Node(e);
     * size++;
     * } else {
     * add(node.right, e);
     * }
     * } else {
     * // e.equals(node.e)
     * return;
     * }
     * }
     **/

    /**
     * 添加元素（逻辑优化）
     *
     * @param e
     */
    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {
        // NULL 也是一棵特殊的BST，统一了操作
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else {
            // do nothing
        }
        // node是不改变的
        return node;
    }

    /**
     * 查询
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
}
