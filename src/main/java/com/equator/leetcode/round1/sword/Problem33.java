package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/20 16:44
 **/

public class Problem33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2) {
            return true;
        }
        return rec(postorder, 0, postorder.length - 1);
    }

    private boolean rec(int[] postorder, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int rootVal = postorder[end]; // 后序遍历最后一个数就是根
        // 判断当前子树代表的后序遍历数组，是否存左边一半小于rootVal，右边一半大于rootVal，
        // 或者只有左子树（值都小于rootVal），或者只有右子树（值都大于rootVal） start of right tree
        int firstBiggerIndex = -1;
        for (int i = start; i < end; i++) {
            if (postorder[i] > rootVal) {
                firstBiggerIndex = i;
                break;
            }
        }
        if (firstBiggerIndex == -1) {
            // 所有的数都小于rootVal，也就是认为只有左子树
            return rec(postorder, start, end - 1);
        }
        // 发现一个比rootVal大，那么后面就一定都要比rootVal大，因为他是右子树
        for (int i = firstBiggerIndex + 1; i < end; i++) {
            if (postorder[i] < rootVal) {
                return false;
            }
        }
        if (firstBiggerIndex == start) {
            // 所有的数都大于rootVal，也就是认为只有右子树
            return rec(postorder, start, end - 1);
        }
        return rec(postorder, start, firstBiggerIndex - 1) && rec(postorder, firstBiggerIndex, end - 1);
    }

    /**
     * 超时（不是）
     * public boolean rec(int[] postorder, int start, int end) {
     * if (start >= end) {
     * return true;
     * }
     * // start of right tree
     * int i;
     * for (i = start; i < end; i++) {
     * if (postorder[i] > postorder[end]) {
     * break;
     * }
     * }
     * // 验证后面的是否都大于sequence[end] 即可
     * for (int j = i; j < end; j++) {
     * if (postorder[j] < postorder[end]) {
     * return false;
     * }
     * }
     * return rec(postorder, start, i - 1) && rec(postorder, i, end - 1);
     * }
     **/

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5};
        System.out.println(new Problem33().verifyPostorder(nums));
    }
}
