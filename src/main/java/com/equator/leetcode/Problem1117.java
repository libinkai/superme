package com.equator.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @Author: Equator
 * @Date: 2020/3/19 18:40
 **/

public class Problem1117 {
    class H2O {
        private Semaphore oxygenSemaphore = new Semaphore(0);
        private Semaphore hydrogenSemaphore = new Semaphore(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hydrogenSemaphore.acquire();
            releaseHydrogen.run();
            oxygenSemaphore.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oxygenSemaphore.acquire(2);
            releaseOxygen.run();
            hydrogenSemaphore.release(2);
        }
    }
}
