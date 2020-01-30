package com.equator.bit;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/1/30 21:57
 **/

public class Shift {
    @Test
    public void left() {
        int num = 0b0010;
        int res = num << 1;
        System.out.println(Integer.toBinaryString(res));
    }

    @Test
    public void right() {
        int num = 0b0100;
        int res = num >> 1;
        System.out.println(Integer.toBinaryString(res));
    }
}
