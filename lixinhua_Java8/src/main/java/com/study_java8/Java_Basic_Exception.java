package com.study_java8;

/**
 * Created by Doctor on 2016/10/24.
 * 异常是Java的一个重大特色，合理的使用异常处理，可以使你的程序更加健壮
 * 异常：是导致程序终端执行的一种指令流，异常一旦产生如果不加处理的话，程序就会中断执行
 * try{
 *  //有可能出现异常的语句
 * }
 * [catch(异常类型 对象){
 *     异常处理;
 * }
 * catch(异常类型 对象){
 *     异常处理;
 * }
 * catch(异常类型 对象){
 *     异常处理;
 * }。。。。]
 * [finally{
 *     ;//不管是否出现异常，都执行的统一代码
 * }]
 */

class MyMath{
    public static int div(int x,int y) throws Exception{
        return x/y;
    }
}

public class Java_Basic_Exception {
    public static void main(String[] args) {
        int[] temp = new int[5];
        System.out.println("1.Before try");
        //程序是从右向左执行的,在一个;的语句中。如果右边跟着一个完整的;语句。会认为是下一条语句执行
        try {
            System.out.println(temp[6]);
            System.out.println("1:-->can I output?");System.out.println("2.除法计算：" + (10/0) + "2:-->can I output?");System.out.println("3:-->can I output??");
        }
        //出现异常是为了解决异常，所以为了能够进行异常的处理，可以使用异常类中提供的printStackTrace()方法进行异常的输出
        catch (ArithmeticException e){
            e.printStackTrace(); //输出异常信息
        }
        catch (NumberFormatException e){
            e.printStackTrace(); //输出异常信息
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace(); //输出异常信息
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //finally 始终都会执行
        finally {
            System.out.println("finally always output!");
        }
        //如果异常处理了,会执行。如果异常未被处理,如下代码不会执行
        System.out.println("3.After finally,can I output?");

    /**
     * @以上的异常都已经知道了，还让它出现(这绝对是技术问题)。为什么不加判断避免出现这些异常呢.
     * 观察异常：
     *  ArithmeticException                                                 NumberFormatException
     *
     *  java.lang.Object                                                         java.lang.Object
     *     |- java.lang.Throwable                                                   |- java.lang.Throwable
     *        |- java.lang.Exception                                                  |- java.lang.Exception
     *           |- java.lang.RuntimeException                                          |-  java.lang.RuntimeException
     *              |- java.lang..ArithmeticException                                      |-  java.lang.IllegalArgumentException
     *                                                                                        |- java.lang.NumberFormatException
     *通过观察可以发现所有的异常类都是Throwable的子类,而在Throwable下有两个子类Error, Exception
     * Error:指的是JVM错误,即：此时的程序还没有执行，如果没有执行用户就无法处理
     * Exception:导致程序终端执行的一种指令流,只的是程序中运行产生的异常，用户可以处理。
     * 也就是所谓的异常处理指的就是所有Exception以及它的子类异常
     *@面试题：JAVA中的异常的处理流程：
     * 1、当程序在运行过程之中出现了异常后,那么会由JVM自动根据异常的类型实例化一个与之类型匹配的异常类对象（此处用户不用去关心new,由系统自动负责处理）
     * 2、产生了异常对象之后会判断当前的语句上是否存在有异常处理，如果没有异常处理，那么就交给JVM进行默认的异常处理（处理的方式就是输出异常信息，而后结束程序的调用）。
     * 3、如果此时存在有异常的捕获操作，那么会有try语句来捕获产生的异常类实例化对象，而后与try语句后的每一个catch进行比较(直到找到匹配项为止)，如果现在有符合的捕获类型，则使用当前的catch语句来进行异常的处理。如果不匹配，则向下继续匹配其他的catch
     * 4、不管最后异常处理是否能够匹配，那么都要向后执行，那么此时程序中如果有finally语句，那么就先执行finally中的代码，但是执行完毕后需要根据之前的catch匹配结果来决定如何执行。如果之前已经成功的捕获了一次
     * @（并且没有throw抛出,即便catch捕获到的时候{}中括号为空白也算捕获了一次），那么就继续执行finally之后的代码，
     * 如果之前没有成功的捕获异常，那么就将此异常交给JVM进行默认的处理（直接输出异常，而后结束程序执行）。
     * @整个过程就好像我们的方法重载一样。根据catch后面的参数类型进行匹配，但是所有的Java对象都存在有自动的向上转型的操作知识，也就是说如果要真的匹配类型，鉴定的做法是匹配Exception就够了
     * @三个不执行：
     * 1.异常出现，没有处理。finally执行,后续代码中断不执行,try中出现异常点之后的代码不执行
     * 2.异常出现，catch中处理了，finally执行,后续代码执行。try中出现异常点之后的代码不执行
     * 3.异常出现, catch中没有匹配到异常，finally执行,后续代码不执行，try中出现异常点之后的代码不执行
     * @两点说明：
     * 1.在编写多个catch捕获一次的时候,捕获范围大的异常一定要放在捕获捕获范围小的异常之后，否则会出现编译错误。
     * 2.虽然直接捕获Exception比较方便，但是这样不好，因为所有的异常都会按照同样一种方式进行处理。如果在一些要求严格的项目里面，异常一定要分开处理比较好。
     */

    /**
     * @throws关键字主要用于/**@方法声明@上,指的是但方法之中出现异常后交由被调用处进行处理
     * main()方法之上也也可以加上throws 关键字,表示这个产生之后会直接通过主方法抛出。抛给main()方法的调用者JVM,默认处理，直接输出，中断后续代码执行。（
     * 因为要中断代码执行,所以在主方法中尽量不要使用throws关键字）
     */
     //System.out.println(MyMath.div(10,2)); //有未处理的异常：Unhandled exception：要么继续抛出，要么处理
        try {
            System.out.println(MyMath.div(10,2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //在主方法上如果继续抛出了异常,那么这个异常就将交给JVM进行处理也就是默认的处理方式，输出异常信息而后结束程序调用.
        //主方法上不要加上throws,因为程序如果出错了，也希望可以正常结束调用。
        /**
         * @throw在程序之中可以直接使用throw手工的抛出一个异常类的实例化对象
         */
       // throw new Exception("自定义异常");//有未处理的异常：Unhandled exception：要么继续抛出，要么处理
        try {
            throw new Exception("自定义异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*请解释throw和throws的区别
          * throw:指的是在方法之中认为的抛出一个异常类对象（可能是自己实例化，或者是抛出已经存在的）
          * throws:在方法的声明上使用,表示此方法在调用时必须处理异常。
         */

    }
}
