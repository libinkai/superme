package com.equator.datastruct.tree.binarySearchTree;

/**
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

    /**
     * 查找BST的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            return null;
        }
        return minimum(root).e;
    }

    /**
     * 返回已node为根的BST的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除最小值所在的节点
     *
     * @return
     */
    public E removeMin() {
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    /**
     * 删除以node为根的BST中的最小节点
     * 返回删除节点之后的BST的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 查找BST的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            return null;
        }
        return maximum(root).e;
    }

    /**
     * 返回已node为根的BST的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最大值所在的节点
     *
     * @return
     */
    public E removeMax() {
        E max = minimum();
        root = removeMax(root);
        return max;
    }

    /**
     * 删除以node为根的BST中的最大节点
     * 返回删除节点之后的BST的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，返回删除节点之后的BST的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // equals
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                // removeMin内部size--，但是那个节点并没有被删除，是successor，故这里应该有size++
                successor.left = node.left;
                node.left = node.right = null;
                // size--
                return successor;
            }
        }
    }
}
