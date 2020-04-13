package com.equator.concurrent.thread;

/**
 * @Author: Equator
 * @Date: 2020/4/13 20:37
 **/

public class ThreadTest {
    public static void main(String[] args) {
        Thread sleepTestThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("我睡了");
                    Thread.sleep(100000);
                    System.out.println("我醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "sleepTestThread");
        sleepTestThread.start();

        Object lock = new String();
        Thread waitTestThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("我等等");
                    try {
                        lock.wait(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我不等了");
                }
            }
        }, "waitTestThread");
        waitTestThread.start();
    }
}
