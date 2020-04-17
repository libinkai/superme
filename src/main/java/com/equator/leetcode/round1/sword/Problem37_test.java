package com.equator.leetcode.round1.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Equator
 * @Date: 2020/2/21 13:09
 **/

public class Problem37_test {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String str = root.val + "!";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    //将存储好的String类型数据去掉分割符号
    //将此时数据二叉树的先序遍历结果依次压入队列
    public TreeNode deserialize(String data) {
        String[] arr = data.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        //调用先序遍历递归方法（改动后）依次重建二叉树
        return deserialize(queue);
    }

    //传入队列
    public TreeNode deserialize(Queue<String> queue) {
        //依次弹出队列中的节点值
        String str = queue.poll();
        //如果是"#",代表节点值为空,返回null
        if (str.equals("#")) {
            return null;
        }
        //若节点值不为空，将其由String转换回int
        //将其作为当前节点值新建当前节点
        TreeNode root = new TreeNode(Integer.parseInt(str));
        //递归调用连接当前节点的左右节点
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        //递归完成后返回当前节点
        return root;
    }

    public static void main(String[] args) {
        Problem37_test test = new Problem37_test();
        String str = "1!2!3!#!#!4!5";
        TreeNode root = test.deserialize(str);
        String sstr = test.serialize(root);
        System.out.println(sstr);
        TreeNode root2 = test.deserialize(sstr);
        String sstr2 = test.serialize(root2);
        System.out.println(sstr2);
    }
}
