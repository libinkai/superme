package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/3/25 7:45
 **/

public class Problem13Better {
    private Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>(8) {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        // 加上最后一个值
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        // 在小规模数据下，map速度比switch低得多
        // return characterIntegerMap.get(ch);
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
