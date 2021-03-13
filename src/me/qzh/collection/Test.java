package me.qzh.collection;

import java.util.*;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/2/17 18:28
 */
public class Test {
    @org.junit.Test
    public void test(){
        List list = Arrays.asList(12,38,1,987);
        List<Object> list1 = new ArrayList();
        list1.add("a");
        list1.add("b");

        System.out.println(list.spliterator().characteristics());

        Object[] o = {};
        System.out.println(o);

        int[] i = new int[5];
        double[] d = new double[] {1,2};

        float[] f = {};
        Object[] obj = new Object[]{2,3,45,67,55};
        System.out.println(Arrays.toString(list.toArray(obj)));
        System.out.println(Arrays.toString(obj));
        System.out.println(list);
    }

    @org.junit.Test
    public void test2() {
        Map map = new HashMap();
    }

    @org.junit.Test
    public void test3(){
        List list = new ArrayList(10);

        System.out.println(list.size());
        list.add("a");
        list.add(null);
        System.out.println(list.size());

        System.out.println(list);
    }
}
