package me.qzh.lambda;

import org.junit.Test;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/7 15:59
 */
public class LambdaTest {
    @Test
    public void test(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("let's go!");
            }
        };
        run.run();

        System.out.println("-----------------------------------");

        Runnable run2 = () -> System.out.println("go go go!");
        run2.run();
    }
}
