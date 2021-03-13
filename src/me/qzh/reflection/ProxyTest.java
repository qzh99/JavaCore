package me.qzh.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/6 18:42
 */
public class ProxyTest {
    public static void main(String[] args) {
        //被代理对象
        SuperMan superMan = new SuperMan();

        //代理对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        //代理类对象自动调用被代理类对象的方法
        proxyInstance.belief();
        proxyInstance.eat("火锅");
    }
}

interface Human{
    void belief();
    void eat(String food);

}

class SuperMan implements Human {

    @Override
    public void belief() {
        System.out.println("I believe i can fly!");
    }

    @Override
    public void eat(String food) {
        System.out.println("我爱吃" + food);
    }
}

class ProxyFactory{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        Class<?> aClass = obj.getClass();
       return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    //被代理对象
    private Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }

    //代理对象调用的方法，此方法调用被代理类对象的同名方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}