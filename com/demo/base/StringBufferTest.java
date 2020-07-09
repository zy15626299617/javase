package com.demo.base;

public class StringBufferTest {
    public static void main(String[] args) {
        String name = "zhouyou";
        StringBuffer test = new StringBuffer(name);

        //内容长度
        System.out.println(test.length());
        //总空间
        System.out.println(test.capacity());

        long start,end;
        String str = "";
        int count = 0;
        start = System.currentTimeMillis();
        while (count++ < 10000){
            String tmp = randomString(10);
            str += tmp;
        }
        end = System.currentTimeMillis();
        System.out.println("+ use tie is " + (end-start));

        count = 0;
        StringBuffer strbuff = new StringBuffer();
        start = System.currentTimeMillis();
        while (count++ < 10000){
            String tmp = randomString(10);
            strbuff.append(tmp);
        }
        end = System.currentTimeMillis();
        System.out.println("append use tie is " + (end-start));

        count = 0;
        MyStringBufferTest mystrbuff = new MyStringBufferTest();
        start = System.currentTimeMillis();
        while (count++ < 10000){
            String tmp = randomString(10);
            strbuff.append(tmp);
        }
        end = System.currentTimeMillis();
        System.out.println("com.demo.base.MyStringBufferTest append use tie is " + (end-start));
    }

    static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

}
