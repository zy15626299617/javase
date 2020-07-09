package com.demo.base;

public class StringTypeTest {
    public static void main(String[] args) {
        String a = new String("abqd");
        String b = new String("abc");

//        Object的hashCode()默认是返回内存地址的，但是hashCode()可以重写，所以hashCode()不能代表内存地址的不同
//
//        System.identityHashCode(Object)方法可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法。

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }
}
