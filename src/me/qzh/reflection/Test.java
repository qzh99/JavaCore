package me.qzh.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/5 22:42
 */
public class Test {
    @org.junit.Test
    public void test2() throws IllegalAccessException, InstantiationException {
        Class<String> stringClass = String.class;
        String s = stringClass.newInstance();
        Constructor<?>[] declaredConstructors = stringClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println();

        Annotation[] annotations = stringClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @org.junit.Test
    public void test() throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        String s = "";
        Class<? extends String> aClass = s.getClass();
        System.out.println(aClass);

        Class<?> aClass1 = Class.forName("java.lang.String");
        System.out.println(aClass1);


        ClassLoader classLoader = Test.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("java.lang.String");
        System.out.println(aClass2);
    }
}
