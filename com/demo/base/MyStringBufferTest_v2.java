package com.demo.base;

public class MyStringBufferTest_v2 implements MyStringBuffer{
    private int length = 0;
    private int capacity = 16;
    private char[]  ans;

    public MyStringBufferTest_v2(){
        ans = new char[capacity];
    }

    public MyStringBufferTest_v2(String str){
        this();
        if(str == null)  return;

        if(str.length() > capacity){
            capacity = str.length() * 2;
            ans = new char[capacity];
        }

        System.arraycopy(str.toCharArray(),0,ans,0,str.length());

        length = str.length();
    }

    @Override
    public void append(String str) {
        insert(length,str);
    }

    @Override
    public void append(char c) {
        insert(length,c);
    }

    @Override
    public void insert(int pos, char b) {
        insert(pos,String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) {
        if (pos < 0) return;
        else if (pos > length) return;
        else if(b == null) return;

        if(length + b.length() > capacity){
            capacity = (length + b.length()) * 2;
            char[] swap = new char[capacity];
            System.arraycopy(ans,0,swap,0,length);
            ans = swap;
        }

        char[] swap = b.toCharArray();

        System.arraycopy(ans,pos,ans,pos + swap.length,length-pos);
        System.arraycopy(swap,0,ans,pos,swap.length);

        length = length + swap.length;
    }

    @Override
    public void delete(int start) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void reverse() {
        for (int i = 0; i < length/2; i++) {
            char swap = ans[i];
            ans[i] = ans[length - 1 - i];
            ans[length - 1 - i] = swap;
        }
    }

    @Override
    public int length() {
        return length;
    }

    public int capacity() {
        return capacity;
    }

    public String toString() {
        return new String(ans);
    }

    public static void main(String[] args) {
        MyStringBufferTest_v2 sb = new MyStringBufferTest_v2("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);
        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
