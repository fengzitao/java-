
package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/18
 */
public class Test2 {

    public static void main(String[] args) {
        /*int num1 = 21;
        //代表num * 2^2
        num1 = num1 << 2;
        System.out.println(num1); //84

        int num2 = 21;
        //代表num * 2^3
        num2 = num2 << 3;
        System.out.println(num2);*/

        //int i = 10;
        //i += 2.1;
        //System.out.println(i);
        /*Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println(num1 + " "+num2+" "+num3);
        int randomMath = (int) (Math.random() * 90);
        System.out.println(randomMath);*/

//        Scanner scanner = new Scanner(System.in);
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//        //最大公约数
//        int max = num2 <= num1? num2 : num1;
//        //最小公倍数
//        int min = num1 <= num2? num2 : num1;
//        for (int i = min; i >= 1; i--) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                min = i;
//                break;
//            }
//        }
//        while (min % num1 != 0 || min % num2 != 0) {
//            min++;
//        }
//        System.out.println("最大公约数为："+max+",最小公倍数为:"+min);


/*        int num = 1;
        int count = 0;
        do{
            if(num % 2 ==0){
                count += num;
                System.out.println(num);
            }
            num++;
        } while (num <= 100);
        System.out.println(count);*/

//        //99乘法表
//        for (int j = 1; j <=9 ; j++) {
//            for (int i = 1; i <=j ; i++) {
//                System.out.print(j +"*"+i+"="+j*i+"\t");
//            }
//            System.out.println();
//        }


//        //求100以内的质数
//        boolean result = true;
//        for (int i = 2; i <=100 ; i++) {
//            for (int j = 2; j <= Math.sqrt(i) ; j++) {
//                if (i % j == 0) {
//                    result = false;
//                    break;
//                }
//            }
//            if (result) {
//                System.out.println(i);
//            }
//            result = true;
//        }



    }
}
