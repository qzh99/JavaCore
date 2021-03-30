package me.qzh.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author qinzhenghua
 * @version 0.0.1
 * @since 2021/3/30 21:45
 */
public class OptionalTest {
    @Test
    public void test(){
        Integer a = null;
        Integer o = Optional.ofNullable(a).orElse(3);
        System.out.println(o);

        //空指针异常，of()方法的参数必须非空
//        System.out.println(Optional.of(null).orElse("3"));

        System.out.println(Optional.of(4).isPresent());
    }
}
