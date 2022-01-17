package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/20
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(sum(100));

        f(10);

        System.out.println(fibon(9));
    }

    //计算1-n之间的自然数总和 递归方式
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }else {
            return n + sum(n - 1);
        }
    }

    //例3：已知有一个数列，f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n) 递归方式
    public static int f(int n) {
        if (n == 0) {
            return 1;
        }else if(n == 1) {
            return 4;
        }else {
            return 2 * f(n-1) + f(n -2);
        }
    }

    //斐波那契数列 递归
    // 1 1 2 3 5 8 13 21 34 55
    public static int fibon(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return fibon(n - 1) + fibon(n - 2);
        }
    }
}
