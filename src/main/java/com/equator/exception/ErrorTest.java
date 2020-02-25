package com.equator.exception;

/**
 * @Author: Equator
 * @Date: 2020/2/25 19:25
 **/

public class ErrorTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable e) {
            System.out.println("throwable");
            // e.printStackTrace();
        }
    }

    public static void test() throws Error {
        throw new StackOverflowError();
    }
}
