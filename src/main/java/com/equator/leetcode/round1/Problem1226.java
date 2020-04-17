package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/19 21:14
 **/

public class Problem1226 {
    class DiningPhilosophers {
        private volatile boolean[] forks = new boolean[5];

        public DiningPhilosophers() {

        }

        private synchronized boolean getFork(int philosopher) {
            if (!forks[philosopher] && !forks[philosopher == 0 ? 4 : philosopher - 1]) {
                forks[philosopher] = true;
                forks[philosopher == 0 ? 4 : philosopher - 1] = true;
                return true;
            }
            return false;
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            while (!getFork(philosopher)) {
                Thread.sleep(1);
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            forks[philosopher] = false;
            putLeftFork.run();
            forks[philosopher == 0 ? 4 : philosopher - 1] = false;
        }
    }
}
