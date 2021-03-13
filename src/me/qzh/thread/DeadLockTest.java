package me.qzh.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/12 23:13
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable r1 = () -> {
            synchronized (obj1) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("thread1");
                    System.out.println(Thread.currentThread());
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (obj2) {
                try {
                    Thread.sleep(3 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println("thread2");
                    System.out.println(Thread.currentThread());
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}

