package me.qzh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/1/22 15:45
 */
public class TestCreateThread {
    public static void main(String[] args) {
        new Book().start();

        Car car = new Car();
        new Thread(car).start();

        Good good = new Good();
        FutureTask futureTask;
        futureTask = new FutureTask(good);
        new Thread(futureTask).start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
    }
}

class Book extends Thread {
    @Override
    public void run() {
        System.out.println("继承");
    }
}

class Car implements Runnable {
    @Override
    public void run() {
        System.out.println("实现");
    }
}

class Good implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }
}
