package me.qzh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/13 1:04
 */
public class DeadLockTest2 {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable  r1 = new Runnable1(lock1,lock2);
        Runnable  r2 = new Runnable2(lock1,lock2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

    }
}

class Runnable1 implements Runnable{
    Lock lock1 = null;
    Lock lock2 = null;

    public Runnable1(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock1.lock();
        System.out.println("lock1加锁");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("lock2加锁");
        // code

        lock1.unlock();
        lock2.unlock();
    }
}

class Runnable2 implements Runnable{
    Lock lock1 = null;
    Lock lock2 = null;

    public Runnable2(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock2.lock();
        System.out.println("lock2加锁");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println("lock1加锁");
        // code

        lock2.unlock();
        lock1.unlock();
    }
}
