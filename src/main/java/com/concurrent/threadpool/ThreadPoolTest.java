package com.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @Author: Equator
 * @Date: 2020/2/13 20:53
 **/

public class ThreadPoolTest {
    static class Task implements Runnable {
        private int id;

        public Task(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("worker "+this.id+" running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker "+this.id+" done");
        }
    }

    public static void main(String[] args) {
        int corePoolSize = 2, maxPoolSize = 4;
        long keepActiveTime = 8;
        BlockingQueue queue = new LinkedBlockingDeque();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepActiveTime, TimeUnit.SECONDS,
                queue,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r, "thread-" + System.currentTimeMillis());
                        return thread;
                    }
                }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("pool is full");
            }
        });
        for (int i = 0; i < 30; i++) {
            Task task = new Task(i);
            threadPoolExecutor.submit(task);
        }
        threadPoolExecutor.shutdown();
    }
}
