package com.equator.exception;

/**
 * @Author: Equator
 * @Date: 2020/2/25 19:17
 **/

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() throws Exception {
        throw new Exception();
    }
}
