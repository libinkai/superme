package com.equator.demo;

/**
 * @Author: Equator
 * @Date: 2020/3/4 15:41
 **/

public class TwoNumberSwapDemo {
    // 利用中间变量（最稳妥）
    public void swap0(int a, int b) {
        System.out.printf("（中间变量）交换之前：%d，%d\n", a, b);
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("（中间变量）交换之后：%d，%d\n", a, b);
    }

    // 利用相加相减（有溢出风险）
    public void swap1(int a, int b) {
        System.out.printf("（相加减）交换之前：%d，%d\n", a, b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("（相加减）交换之后：%d，%d\n", a, b);
    }

    // 利用异或运算 原理：如果c=a^b，那么a^c=b,b^c=a
    public void swap2(int a, int b) {
        System.out.printf("（异或运算）交换之前：%d，%d\n", a, b);
        // 如果a==b，导致这一步a就等于0了
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("（异或运算）交换之后：%d，%d\n", a, b);
    }

    public static void main(String[] args) {
        TwoNumberSwapDemo twoNumberSwap = new TwoNumberSwapDemo();
        twoNumberSwap.swap0(2, 3);
        twoNumberSwap.swap1(2, 3);
        twoNumberSwap.swap2(2, 3);
        System.out.println("--------");
        twoNumberSwap.swap0(2, 2);
        twoNumberSwap.swap1(2, 2);
        twoNumberSwap.swap2(2, 2);
        System.out.println("--------");
        twoNumberSwap.swap0(2, -2);
        twoNumberSwap.swap1(2, -2);
        twoNumberSwap.swap2(2, -2);
        System.out.println("--------");
        twoNumberSwap.swap0(Integer.MAX_VALUE, Integer.MAX_VALUE);
        twoNumberSwap.swap1(Integer.MAX_VALUE, Integer.MAX_VALUE);
        twoNumberSwap.swap2(Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println("--------");
    }
}
