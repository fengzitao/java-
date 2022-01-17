package com.fzt.java1;

/**
 * @author fengzitao
 * @date 2021/12/19
 */
public class test3 {
    public static void main(String[] args) {
//        int[] ids = new int[10];
//        for (int i = 0; i < 9; i++) {
//            ids[i] = i;
//        }
//        //三种写法都可以
//        int[][] arr1 = new int[3][4];
//        int[] arr2[] = new int[3][4];
//        int arr3[][] = new int[3][4];
//        //增强for循环
//        for (int id : ids) {
//            System.out.println(id);
//        }

        //杨辉三角
//        int[][] arr = new int[10][];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new int[i+1];
//            for (int j = 0; j <= i; j++) {
//                if(j==0 || j==i) {
//                    arr[i][j] = 1;
//                }else {
//                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+"\t");
//            }
//            System.out.println();
//        }

//        //数组的复制并赋值到另一个数组中
//        int[][] arr2 = new int[][]{{1,2,3},{4,5,6},{7,8}};
//        int[][] arr3 =  Arrays.copyOf(arr2,3);
//        for (int i = 0; i < arr3.length; i++) {
//            for (int j = 0; j < arr3[i].length; j++) {
//                System.out.print(arr3[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        System.out.println(arr2);
//        System.out.println(arr3);


//        //冒泡算法
//        int[] arr4 = new int[]{17, 43, 48, 53, 39, 529, 329, 345, 12, 96};
//        int temp;
//        for (int i = 0; i < arr4.length - 1; i++) {
//            for (int j = 0; j < arr4.length - 1 - i; j++) {
//                if (arr4[j] > arr4[j + 1]) {
//                    temp = arr4[j];
//                    arr4[j] = arr4[j + 1];
//                    arr4[j + 1] = temp;
//                }
//            }
//        }
//        for (int a : arr4) {
//            System.out.print(a + " ");
//        }

//        //二分查找
//        int[] arr5 = {12,17,39,43,46,53,96,329,345,529};
//        //目标值
//        int dest = 329;
//        int head = 0;
//        int end = arr5.length -1;
//        int middle;
//        boolean isflag = true;
//        while (head <= end) {
//            middle = (head + end)/2;
//            if (dest == arr5[middle]) {
//                isflag = false;
//                System.out.println("找到目标值，位置在arr["+middle+"]");
//                break;
//            } else if (dest < arr5[middle]) {
//                end = middle - 1;
//            } else {
//                head = middle + 1;
//            }
//        }
//        if (isflag) {
//            System.out.println("抱歉，并未找到目标值哦");
//        }
        String name = "com/fzt";

    }

    //可变参数 int...必须放到参数列表的末尾
    public static String getName(int... id) {
        return "";
    }



}
