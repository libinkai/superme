package com.equator.leetcode.round1;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Equator
 * @Date: 2020/2/27 21:15
 **/

public class Problem1114 {
    class Foo0 {
        private volatile int sign = 1;

        public Foo0() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            sign = 2;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (sign != 2) {

            }
            printSecond.run();
            sign = 3;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (sign != 3) {

            }
            printThird.run();
        }
    }

    class Foo1 {
        private CountDownLatch latch2 = new CountDownLatch(1);
        private CountDownLatch latch3 = new CountDownLatch(1);

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            latch2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            latch2.await();
            printSecond.run();
            latch3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latch3.await();
            printThird.run();
        }
    }
}
