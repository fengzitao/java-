package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/21
 */
public class Test6 {

    public static void main(String[] args) {
        Student2 student2 = new Student2();
        student2.eat();
        student2.study();

        System.out.println("*****************");
        //sleep调用子类的study方法以及父类的eat方法
        student2.sleep();
    }
}

class Person {
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void study() {
        System.out.println("学习");
    }

    //private方法不能被子类重写
    private void eat() {
        System.out.println("吃东西");
    }

    public void sleep() {
        //子类重写了study方法，所以执行子类的study方法
        study();
        //eat方法属于private，不能被子类重写，所以执行父类的eat方法
        eat();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Student2 extends Person {
    @Override
    public void study() {
        System.out.println("学生学习");
    }

    //这个并不属于重写，父类的eat(）方法的权限修饰符是private，不能被子类重写
    public void eat() {
        System.out.println("学生吃饭");
    }

    public void watchingTV() {
        System.out.println("看电视");
    }
}

