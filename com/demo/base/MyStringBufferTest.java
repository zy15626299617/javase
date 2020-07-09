package com.demo.base;

import java.util.Arrays;

public class MyStringBufferTest implements MyStringBuffer{
    private int length;
    private int capacity;
    private char[] str;

    MyStringBufferTest(){
        length = 0;
        capacity = 10;
        this.str = new char[capacity];
    }

    MyStringBufferTest(String str){
//        length = str.length();
//        capacity = length >= capacity ? length + 15 : capacity;
//        this.str = new char[capacity];
//        for (int i = 0; i < length; i++) this.str[i] = str.charAt(i);


    }
    @Override
    public void append(String str) {
        int start_index = length;
        length += str.length();
        if(length >= capacity){
            char[] tmp = Arrays.copyOf(this.str,length + 15);
            for (int i = 0,j = start_index; i < str.length(); i++,j++) tmp[j] = str.charAt(i);
            capacity = length + 15;
            this.str = tmp;
        }else{
            for (int i = 0,j = start_index; i < str.length(); i++,j++) this.str[j] = str.charAt(i);
        }
    }

    @Override
    public void append(char c) {
        int start_index = length++;
        if(length >= capacity){
            char[] tmp = Arrays.copyOf(this.str,length + 15);
            tmp[start_index] = c;
            capacity = length + 15;
            this.str = tmp;
        }else{
            this.str[start_index] = c;
        }
    }

    @Override
    public void insert(int pos, char b) {
        if(length + 1 >= capacity){
            char[] tmp = Arrays.copyOfRange(this.str,pos,length);
            this.str = Arrays.copyOf(Arrays.copyOfRange(this.str,0,pos - 1),length + 16);
            this.str[pos] = b;
            for (char c : tmp){
                this.str[++pos] = c;
            }
            capacity = length + 16;
        }else{
            char[] tmp = Arrays.copyOfRange(this.str,pos,length);
            this.str[pos] = b;
            for (char c : tmp){
                this.str[++pos] = c;
            }
        }
        length += 1;
    }

    @Override
    public void insert(int pos, String b) {

    }

    @Override
    public void delete(int start) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public int length() {
        return length;
    }

    public String toString(){
        return new String(str);
    }
    public int capacity() {return capacity;};

    public static void main(String[] args) {
        MyStringBufferTest test = new MyStringBufferTest("zhouyou");
        System.out.println(test.toString() + " 内容长度:" + String.valueOf(test.length()) + " 实际容量:" + test.capacity());
        test.append(" is 周游");
        System.out.println(test.toString() + " 内容长度:" + String.valueOf(test.length()) + " 实际容量:" + test.capacity());
        test.append(" is 周游 1");
        System.out.println(test.toString() + " 内容长度:" + String.valueOf(test.length()) + " 实际容量:" + test.capacity());
        test.append('A');
        System.out.println(test.toString() + " 内容长度:" + String.valueOf(test.length()) + " 实际容量:" + test.capacity());
        test.insert(22,'Z');
        System.out.println(test.toString() + " 内容长度:" + String.valueOf(test.length()) + " 实际容量:" + test.capacity());

    }
}
