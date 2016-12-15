package class_library;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Doctor on 2016/11/3.
 * Math类：public final class Math extends Object
 * Math里面都是static方法,一个类里面所有都是static方法,因为它没有普通常量
 * Since JDK1.0
 * @包含主要方法如下：
 * 四舍五入：public static long round(double a)
 *以8位二进制机器码举例如下：
        [+5]原 =[+5]反 =[+5]补 =0000 0101b  正数的反码，补码就是起本身，负数的反码，按位取反，补码：反码+1
        [-5]原 =1000 0101b
        [-5]反 =1111 1010b
        [-5]补 =1111 1011b
 *
 * BigDecimal和BigInteger 都是Number的子类：6个方法，拆箱,装箱
 *
 */
public class Java_lib_Math {
    public static void main(String[] args) {
        System.out.println(Math.round(15.5));  //16
        System.out.println(Math.round(-15.5));  //todo 15
        System.out.println(Math.round(-15.51));  //-16
        //如果进行负数四舍五入的时候,操作的数据小数位大于0.5才进位，小于等于0.5不进位

        Random ran = new Random();
        for (int i = 0; i < 10 ; i++) {
            System.out.print("、"+ ran.nextInt(100));
        }
        System.out.println();
        System.out.println("--------------------------------");

        int[] data = new int[7];
        int foot = 0;  //此为数组操作脚标，脚标的意义在于通过控制条件控制数组元素的访问进度。（如果使用for循环访问,无法使用条件控制索引的变化）

        while (foot < data.length){  //如何数组中每个元素都必须设置到,while循环不知道循环次数的时候使用
            int t = new Random().nextInt(37);  //生成一个不大于37的随机数
            if (!isRepeated(data,t)){
                data[foot++] = t;
            }
        }
        Arrays.sort(data);
        for (int i = 0; i <data.length ; i++) {
            System.out.print("、"+(data[i]));
        }
        System.out.println("--------------------------------");

        System.out.println(Double.MAX_VALUE * Double.MAX_VALUE);   //Infinity
        //todo 面试题：请问当前假设有两个很大的数字要进行数学计算（超过了dobule范围），该怎么做
        /*如果超过了double的范围,肯定无法使用double进行保存。只有String才可以准确的保存好着数据。如果真要进行
         *大数字的数学计算，只能将其变为String型，而后按位取出每个一个字符保存的数据进行手工的计算
         *在Java里面考虑到了大数字的操作麻烦,就提供了BigInteger,和BigDecimal两种大数字
         */

        System.out.println();
        BigInteger bigA = new BigInteger("33333333333333333333333333333333333333331111111111111111111111111111111111111111111111111111111111111");
        BigInteger bigB = new BigInteger("3333333333333333333333333333333333333333");
        System.out.println(bigA.add(bigB));
        System.out.println(bigA.multiply(bigB));
        BigInteger result[] = bigA.divideAndRemainder(bigB);
        System.out.println("商：" + result[0] + "余：" + result[1]);

        System.out.println();

        //public class BigDecimal extends Number implements Comparable<BigDecimal>
        //构造一：public BigDecimal(String val)
        //构造而：public BigDecimal(double val)
        //BigDecimal 可以进行精确的四舍五入
        //public BigDecimal divide(BigDecimal divisor,int scale,RoundingMode roundingMode)
        // |--BigDecimal divisor：被除数
        // |--int scale：保留的小数位
        // |--RoundingMode roundingMode：进位模式  public static final int ROUND_HALF_UP

        System.out.println();
        System.out.println(round(103.234675235,5));  //103.23468

        System.out.println(new BigDecimal(103.234675235).divide(new BigDecimal(1),5,BigDecimal.ROUND_HALF_UP));


    }
    public static double round(double num,int scale){
        BigDecimal bigA = new BigDecimal(num);  //接收double的构造函数
        BigDecimal BigB = new BigDecimal(1);     //接收
        return bigA.divide(BigB,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static boolean isRepeated(int[] temp,int num){
        if (num == 0){  //如果数字为0,则直接返回true.
            return true;
        }
        for (int i = 0; i < temp.length ; i++) {
            if (temp[i] == num){
                return true;
            }
        }
        return false;
    }
}
