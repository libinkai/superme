package com.nowcoder.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/15 7:53
 **/

public class Problem5 {
    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        if (string == null || "".equals(string)) {
            return "";
        }
        int numberOfBlank = 0;
        char[] oldChars = string.toCharArray();
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

    public static void main(String[] args) {
        String str = "  I am you ";
        System.out.println(new Problem5().replaceSpace(new StringBuffer(str)));
    }
}
