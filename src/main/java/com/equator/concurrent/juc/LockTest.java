package com.equator.concurrent.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Equator
 * @Date: 2020/3/9 21:13
 **/

public class LockTest {
    private int balance = 0;
    private final Lock lock = new ReentrantLock();

    public void add() {
        lock.lock();
        try {
            this.balance++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lockTest.add();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lockTest.add();
                }
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(lockTest.balance);
    }
}
