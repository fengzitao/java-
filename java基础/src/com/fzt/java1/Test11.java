package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/23
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(A.getA());
        //静态内部类的创建方法
        A a = new Test11.A();
        //非静态内部类的创建方法
        B b = new Test11().new B();
    }

    static class A {
        private static int a = 10;

        public static int getA() {
            return a;
        }
    }

    class B {
        private int b = 20;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}

