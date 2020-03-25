package com.equator.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/3/25 7:45
 **/

public class Problem13 {
    private Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>(8) {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    private Map<String, Integer> stringIntegerMap = new HashMap<String, Integer>(8) {{
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};

    public int romanToInt(String s) {
        switch (s) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default: {
                char[] chars = s.toCharArray();
                int num = 0;
                for (int i = 0; i < chars.length; i++) {
                    if (i != chars.length - 1) {
                        String str = "" + chars[i] + chars[i + 1];
                        if (stringIntegerMap.containsKey(str)) {
                            num += stringIntegerMap.get(str);
                            i++;
                        } else {
                            num += characterIntegerMap.get(chars[i]);
                        }
                    } else {
                        num += characterIntegerMap.get(chars[i]);
                    }
                }
                return num;
            }
        }
    }
}
