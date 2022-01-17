package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/22
 */
public class Test10 {
    public static void main(String[] args) {
        //三元运算符 ：它的左右两边的类型要一致 所以1自动提升为1.0
        Object o1 = true ? new Integer(1) : new Double(2.0);
        //编译看左边 运行看右边 所以打印的不是地址 而是1.0
        System.out.println(o1.toString());

        //Integer内部定义了IntegerCache内部类（Integer对象的缓存池），IntegerCache里面
        //定义了Integer[] 保存了-128~127范围内的整数，如果我们使用自动装箱的方式给Integer赋值，
        //值的范围在-128~127范围内，则可以直接使用该数组中的元素，不必去new一个新的，如果超过该范围，
        //则必须要new一个新的。 目的：提高效率，在类加载到方法区的时候，创建一个Integer数组到内存中
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //false 不是同一个对象，地址值不一样

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); //true m、n的地址值是一样的，都是指向Interger数组中的1

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); //false 超过-128~127的范围，所以new一个新的
    }

    public void test() {

    }
}
