package com.equator.exception;

/**
 * @Author: Equator
 * @Date: 2020/2/25 19:21
 **/

public class ThrowableTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void test() throws Throwable {
        throw new Error();
    }
}
