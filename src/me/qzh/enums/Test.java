package me.qzh.enums;


import java.util.Arrays;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/1/27 18:00
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Subject.values()));
        scan:{

        }
    }

    @org.junit.Test
    public void test(){
        System.out.println(Subject.ENGLISH.compareTo(Subject.MATH));
        System.out.println(Subject.ENGLISH.equals(Week.SUN));

        System.out.println(Subject.ENGLISH.getDeclaringClass());

        System.out.println(Week.MON.name());
        System.out.println(Week.MON.toString());
        System.out.println(Week.MON.ordinal());


        System.out.println(Enum.valueOf(Week.class, "SUN"));
    }
}
