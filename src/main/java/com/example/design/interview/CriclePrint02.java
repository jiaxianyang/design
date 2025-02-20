package com.example.design.interview;

/**
 * @author jiaxianyang
 * @date 2024/6/13 17:07
 */
public class CriclePrint02 {

    private static final Object lock = new Object();
    private static int currentThread = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask(1));
        Thread t2 = new Thread(new PrintTask(2));
        Thread t3 = new Thread(new PrintTask(3));

        t1.start();
        t2.start();
        t3.start();
    }

   static class PrintTask implements Runnable {

        private int threadId;

        public PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (currentThread != threadId) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Thread " + threadId + " is printing");
                    currentThread = (currentThread % 3) + 1;
                    lock.notifyAll();
                }
            }
        }
    }
}
