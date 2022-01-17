package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/21
 */
public class Test7 {
    public static void main(String[] args) {
        Person p = new Student2();
        //name和age来自于Person类中 因为并未初始化 所以name和age都是默认值
        System.out.println(p.getName()+","+p.getAge());
        //编译看左边，运行看右边（动态绑定）
        //编译的时候不确定具体执行的方法是什么，在运行中才确定（执行子类重写的方法）
        p.study();

        //找不到该方法，因为父类中并没有定义此方法，所以编译时报错
        //p.watchingTV();

        //要想调用该方法，必须向下转型
        ((Student2)p).watchingTV();
    }


}
