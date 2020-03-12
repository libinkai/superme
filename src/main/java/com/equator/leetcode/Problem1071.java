package com.equator.leetcode;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/3/12 12:55
 **/

public class Problem1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        String str = str1.length() < str2.length() ? str1 : str2;
        int len = str.length();
        do {
            if (judge(str1, str) && judge(str2, str)) {
                return str;
            }
            str = str.substring(0, len);
            len--;
        } while (len > 0);
        return "";
    }

    private boolean judge(String S, String T) {
        int slen = S.length(), tlen = T.length();
        int num = slen / tlen;
        while (num > 0) {
            S = S.replace(T, "");
            num--;
        }
        return S.equals("") ? true : false;
    }

    @Test
    public void testJudge() {
        System.out.println(judge("ABABAB", "ABC"));
    }

    public static void main(String[] args) {
        Problem1071 problem = new Problem1071();
        System.out.println(problem.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(problem.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(problem.gcdOfStrings("LEET", "CODE"));
    }
}
