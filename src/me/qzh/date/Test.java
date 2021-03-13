package me.qzh.date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/1/27 17:52
 */
public class Test {
    @org.junit.Test
    public void test(){
        System.out.println(Arrays.toString(DayOfWeek.values()));
        System.out.println(DayOfWeek.from(LocalDate.now()));
        System.out.println(DayOfWeek.from(LocalDateTime.now()));
    }

    @org.junit.Test
    public void test2(){
        System.out.println(ZoneId.of("+8").getClass());
        System.out.println(ZoneId.of("+8"));
        System.out.println(ZoneId.of("Asia/Shanghai"));
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        System.out.println(ZoneOffset.of("+8"));
        System.out.println(ZoneOffset.of("+8").getTotalSeconds());
    }

    @org.junit.Test
    public void test3(){
        System.out.println(DayOfWeek.from(LocalDateTime.now()));
        System.out.println(MonthDay.now());
        System.out.println(LocalDate.now().until(LocalDate.of(2021, 2, 15)));
        System.out.println(LocalDate.now().until(LocalDate.of(2021, 2, 15), ChronoUnit.DAYS));
        System.out.println(LocalDate.now().until(LocalDate.of(2021, 2, 15), ChronoUnit.MONTHS));
    }

    @org.junit.Test
    public void test4(){
        System.out.println(LocalDate.now().atStartOfDay());
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0,0)));
        System.out.println(LocalDate.now().toEpochDay());
    }

    @org.junit.Test
    public void test5(){
        LocalTime.now();
    }
}
