package com.demo.base;

public class TypeChangeTest {
    public static void main(String[] args) {
        char c = 'A';
        short s = 80;

        c = (char) s;
        s = (short) c;

        byte b = 5;
        int i1 = 10;
        int i2 = 500;

        b = (byte)i1;
        System.out.println(b);

        b = (byte)i2;
        System.out.println(b);

        System.out.println(Integer.toBinaryString(i2));
    }
}
