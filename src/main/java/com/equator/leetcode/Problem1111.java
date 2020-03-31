package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/4/1 7:33
 **/

public class Problem1111 {
    /**
     * 两个单括号组成的情况有四种:'((', '))', '()', ')('
     * 前两种情况，这两个单括号肯定不能在同一子序列中，因为那样会加深字符串深度，所以分别分到A，B组
     * 后两种情况，分到同一组不会加深字符串深度，所以可以分到同一组
     *
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit1(String seq) {
        int[] res = new int[seq.length()];
        for (int i = 1; i < seq.length(); i++) {
            if (seq.charAt(i) == seq.charAt(i - 1)) {
                res[i] = 1 - res[i - 1];
            } else {
                res[i] = res[i - 1];
            }
        }
        return res;
    }

    /**
     * seq对应的栈上，每个左括号都对应一个深度，而这个左括号，要么是A的，要么是B的。所以，栈上的左括号只要按奇偶分配给A和B就可以啦
     */
    public int[] maxDepthAfterSplit2(String seq) {
        int[] res = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                res[idx] = idx & 1;
            } else {
                res[idx] = (idx + 1) & 1;
            }
            idx++;
        }
        return res;
    }
}
