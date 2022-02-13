package com.thread;


public class PrintABC2 {

    private volatile int state = 0;

    private class PrintRunnable implements Runnable {

        private Object lock;

        private String str;

        private int printState;

        private int nextState;

        public PrintRunnable (Object lock, String str, int currentState, int nextState) {
            this.lock = lock;
            this.str = str;
            this.printState = currentState;
            this.nextState = nextState;
        }

        public void run() {
            synchronized (lock) {
                while (true) {
                    while (state != printState) {
                        try {
                            lock.wait();
                        } catch(Exception e) {
                            return;
                        }
                    }
                    System.out.print(str);
                    state = this.nextState;
                    lock.notifyAll();
                }
            }
        }
    }

    public void test () {
        Object obj = new Object();
        Thread threadA = new Thread(new PrintRunnable(obj, "A", 0, 1));
        Thread threadB = new Thread(new PrintRunnable(obj, "B", 1, 2));
        Thread threadC = new Thread(new PrintRunnable(obj, "C", 2, 0));
        threadA.start();
        threadB.start();
        threadC.start();
    }


    public static void main (String[] args) {
        PrintABC2 printABC2 = new PrintABC2();
        printABC2.test();
    }
}
