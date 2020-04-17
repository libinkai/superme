package com.equator.leetcode.round1;

import java.util.concurrent.Semaphore;

/**
 * @Author: Equator
 * @Date: 2020/3/19 10:19
 **/

public class Problem1115 {
// 公平锁
//    class FooBar {
//        private int n;
//
//        ReentrantLock lock = new ReentrantLock(true);
//        private volatile boolean sign = true;
//
//        public FooBar(int n) {
//            this.n = n;
//        }
//
//        public void foo(Runnable printFoo) throws InterruptedException {
//            for (int i = 0; i < n; ) {
//                lock.lock();
//                try {
//                    if (sign) {
//                        printFoo.run();
//                        sign = false;
//                        i++;
//                    }
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//
//        public void bar(Runnable printBar) throws InterruptedException {
//            for (int i = 0; i < n; ) {
//                lock.lock();
//                try {
//                    if (!sign) {
//                        printBar.run();
//                        sign = true;
//                        i++;
//                    }
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }

    // 信号量
    class FooBar {
        private int n;

        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }
}
