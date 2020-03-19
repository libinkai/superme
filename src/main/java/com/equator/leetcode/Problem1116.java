package com.equator.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @Author: Equator
 * @Date: 2020/3/19 12:27
 **/

public class Problem1116 {
    static class ZeroEvenOdd {
        private int n;
        private Semaphore zero = new Semaphore(1);
        private Semaphore even = new Semaphore(0);
        private Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i+=2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
