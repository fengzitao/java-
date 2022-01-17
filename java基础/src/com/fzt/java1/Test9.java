package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/22
 */
public class Test9 {

    public static void main(String[] args) {
        // == 比较基本数据类型的变量，比较的是他的数据值
        // 比较引用数据类型，则比较的是他的地址值
        // equals()只能适用于引用数据类型
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(i == d);

        char c = 10;
        System.out.println(i == c);

        char c1 = 97;
        char c2 = 'a';
        System.out.println(c1 == c2);

        String s = "aa";

        Integer i1 = new Integer(10);
        Double d1 = new Double(10.0);
        int i2 = 10;
        //xxxValue 可转换为xxx类型
        int i3 = i1.intValue();
        double d2 = d1.doubleValue();
        //自动拆箱
        int i4 = i1;
        //自动装箱
        Integer i5 = i2;
        //包装类或基本数据类型转换成String类型的方法
        //1.valueOf() 2、xxx + ""
        String s1 = String.valueOf(i2);
        s1 = String.valueOf(i1);
        String s2 = i2 + "";
        //String类型==》基本数据类型 parseXXX()
        String s3 = "10";
        int i6 = Integer.parseInt(s3);
        String s4 = "10.0";
        double d3 = Double.parseDouble(s4);

    }
}

