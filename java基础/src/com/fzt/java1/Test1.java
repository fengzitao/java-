package com.fzt.java1;

public class Test1 {
    public static void main(String[] args) {
        float a = 153.161f;
        int i = (int) a;
        System.out.println(i);

        int b = 1016;
        float c = b;
        System.out.println(c);

        char c1 = 'a';
        char c2 = 97;
        System.out.println(c1);
        System.out.println(c2);

        char c3 = 98;
        char c4 = '5';
        System.out.println(c3);
        System.out.println(c4);

        //53
        int d = c4;
        System.out.println(d);

        String s1 = new String("aabb");
        String s2 = new String("aabb");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }


}

