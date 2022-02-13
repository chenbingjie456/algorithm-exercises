package com.thread;
import java.util.concurrent.locks.*;

public class PrintABC {

    class PrintThread implements Runnable {
        ReentrantLock lock;
        String printString;
        Condition thisCondition;
        Condition nextCondition;


        public PrintThread (ReentrantLock lock, Condition thisCondition, Condition nextCondition,   String printString) {
            this.printString = printString;
            this.lock = lock;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
        }

        public void run() {
            lock.lock();
            try {
                while (true) {
                    System.out.print(printString);
                    this.nextCondition.signal();
                    this.thisCondition.await();
                }
            }catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void test() {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread threadA = new Thread(new PrintThread(lock, conditionA, conditionB, "A"));
        Thread threadB = new Thread(new PrintThread(lock, conditionB, conditionC, "B"));
        Thread threadC = new Thread(new PrintThread(lock, conditionC, conditionA, "C"));
        try {
            threadA.start();
            Thread.sleep(1000);
            threadB.start();
            Thread.sleep(1000);
            threadC.start();
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args)  {
        PrintABC printABC = new PrintABC();
        printABC.test();
    }
}
