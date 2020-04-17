package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/15 7:53
 **/

public class Problem5 {
    public String replaceSpace(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int numberOfBlank = 0;
        char[] oldChars = s.toCharArray();
        for (char oldChar : oldChars) {
            if (' ' == oldChar) {
                numberOfBlank++;
            }
        }
        char[] newChars = new char[oldChars.length + numberOfBlank * 2];
        int oldIndex = oldChars.length - 1, newIndex = newChars.length - 1;
        while (oldIndex >= 0) {
            if (oldChars[oldIndex] == ' ') {
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex--] = '%';
            } else {
                newChars[newIndex--] = oldChars[oldIndex];
            }
            oldIndex--;
        }
        return new String(newChars);
    }
}
