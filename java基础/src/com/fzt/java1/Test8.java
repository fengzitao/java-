package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/22
 */
public class Test8 {

    public static void main(String[] args) {
        sub sub = new sub();
        //优先调用形参数量确定的方法add(int a, int b, int c)
        sub.add(1,2,3);
    }
}

class sub {
    int count;

    //arr的数量不确定
    public void add(int a, int... arr) {
        System.out.println("sub_1");
    }

    //形参数量确定，优先调用
    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}