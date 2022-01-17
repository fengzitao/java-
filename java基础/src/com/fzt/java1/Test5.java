package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/21
 */
public class Test5 {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("id:" + student.getId() + ",name:" + student.getName());

        Teacher teacher = new Teacher(23, "com/fzt");

    }
}

class Student {
    //初始值为0
    private int id;

    //初始值为null
    private String name;

    public int getId() {
        return id;
    }

    public int getId2() {
        //局部变量必须初始化一个值
        int id2;
        //报错，"Variable 'id2' might not have been initialized"
        //System.out.println(id2);
        return 0;
    }

    public String getName() {
        return name;
    }

}

class Teacher {
    private int age;
    private String name;

    public Teacher(int age, String name) {
        //this()必须在首行 不然会报错
        this();
        this.age = age;
        this.name = name;
    }

    public Teacher() {
        System.out.println("无参构造函数Teacher（）");
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

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

