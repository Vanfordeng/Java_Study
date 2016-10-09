package com.study_java8;



/**
 * Created by Doctor on 2016/9/29.
 */
public class Java_Basic_Array {
    public static void main(String[] args){
        //引用传递：不同的堆内存空间被不同的栈内存引用
        //数组的动态初始化
        int[] data = new int[3];
        data[0] =10;
        data[1] =20;
        data[2] =30;
        int[] temp = data;
        System.out.println(data[0]);
        temp[0]=99;
        System.out.println(temp[0]);
        //数组的静态初始化
        //完整格式
        int[] data1 = new int[]{5,4,3,2,1};
        //简单格式
        int[] data2 = {1,2,3,4};
        data2 = data1; //引用传递
        System.out.println(data1[4]);
        System.out.println(data2[4]);
        System.out.println();
        //数组的传递
        int tmp[] = new int[]{1,2,3};
        change(tmp);  //int temp[] = tmp;
        //在进行数组的引用传递的过程中,方法对数组的修改一定会影响到原始数据
        //在方法中对引用数据的使用一定会影响引用数据的原始数据
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
        System.out.println();
        int temp1[] =  new int[]{2,1,9,0,5,3,7,6,8};
        print(temp1);
        //外层控制排序的总体的次数
        for (int i = 0; i < temp1.length ; i++) {
            //内层控制每次的排序控制
            for (int y = 0; y <temp1.length - 1 ; y++) {
                if (temp1[y] > temp1[y+1]){
                    int t = temp1[y];
                    temp1[y] = temp1[y+1];
                    temp1[y+1] = t;
                }
            }
            print(temp1);
        }
        //main方法设计上市作为程序的起点存在，那么所有的程序起点都可以称为客户端。既然是客户端,客户端的
        //代码编写一定要简单,那么可以采用方法进行封装

        System.out.println();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[][] arr2 = new int[][]{{1,2,3},{5,6,7},{9,10,11}};
        print(arr2);
        reverse(arr2);
        System.out.println();
        print(arr2);
        revert1(arr);
        print(arr);
//        print(revert(arr));

        int [] dataA = new int[]{1,2,3,4,5,6,7,8};
        int [] dataB = new int[]{11,22,33,44,55,66,77,88};
        //数组的类库
        System.arraycopy(dataA,4,dataB,2,3);
        print(dataB);
        java.util.Arrays.sort(dataB);
        print(dataB);
        //对象数组
        BookAarry [] arrBook = new BookAarry[3];
        arrBook[0] =  new BookAarry("Java",79.8);
        arrBook[1] =  new BookAarry("C++",60.8);
        arrBook[2] =  new BookAarry("Python",100.0);
        for (int i = 0; i < arrBook.length; i++) {
            System.out.println(arrBook[i].getInfo());
        }
    }
    //数组的传递
    public static void change(int temp[]){
        for (int i = 0; i < temp.length; i++) {
            temp[i]*=2;
        }
    }

    //输出数组元素的方法
    public static void print(int temp[]){
        for (int i = 0; i < temp.length ; i++) {
            System.out.print(temp[i]+"\t");
        }
        System.out.println();
    }
    //输出数组元素的方法
    public static void print(int temp[][]){
        for (int i = 0; i < temp.length ; i++) {
            for (int y = 0; y < temp[i].length ; y++) {
                System.out.print(temp[i][y]+"\t");
            }
            System.out.println();
        }
    }
    //第一种转置：会产生垃圾
    //别喊方法名称，看方法的返回值。方法名称是最没用的东西
    public static int[] revert(int arr[]){
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            temp[arr.length-1-i]= arr[i];
        }
        return temp;
    }
    //第二种转置：
    public static  void revert1(int[] arr){
        int len = arr.length/2;
        int head = 0;
        int tail = arr.length-1;
        for (int i = 0; i < len ; i++) {
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail]=temp;
            head ++;
            tail --;
        }
    }
    public static void reverse(int arr[][]){
        for (int x = 0; x < arr.length ; x++) {
            for (int y = x; y < arr[x].length; y++) {
                if (x!=y){
                    int temp = arr[x][y];
                    arr[x][y] = arr[y][x];
                    arr[y][x] = temp;
                }
            }
        }
    }
}

class BookAarry{
    private String title;
    private double price;
    BookAarry(){}
    BookAarry(String t,double p){
        title = t;
        price = p;
    }

    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public void setTitle(String t){
        title = t;
    }
    public void setPrice(double p){
        price =p;
    }

    public String getInfo(){
        return  "书名：" + title + "\t价格：" + price;
    }
}