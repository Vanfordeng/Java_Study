package design_mode;

/**
 * Created by Doctor on 2016/10/25.
 * 异常的使用格式模型
 */
class MyMath{
    public static int div(int x,int y) throws Exception{
        int result = 0;
        System.out.println("1-|-:除法计算开始");
        try {
            result = x / y;
        }catch (Exception e){   //catch也可以省略，但是建议不这么做
            System.out.println("我要准备抛出异常给调用我的程序,让它知道出错了，我自己的finally之后的代码就不要执行了");
            e.printStackTrace();   //[如果注释掉下行代码：throw e;]异常我自己处理了,不用给调用我的人去处理..那么我的finally之后的代码就可以执行.
            throw e;
//            System.out.println("异常已经抛出了,我还能执行吗？");   //Unreachable statement:无法到达的语句，永远不会执行。也就是说什么地方抛出异常,程序就从什么地方中断。（虽然catch到了异常但是自己没有处理）
// 从另一方面来说,throw是将程序执行流交给了调用者，自己则中断执行流
        }finally {
            System.out.println("2-|-:除法计算结束");
        }
        System.out.println("Finish");
        return  result;
    }
}
public class Exception_Mode {
    public static void main(String[] args) throws Exception {
        try {
            //如果代买10/2出现异常,那么在div方法中出现异常点x/y之后的代码不会再执行。但是我们需要后续代码执行
            System.out.println(MyMath.div(10,0));
        }
        //catch(Exception e){}如果打括号内为空,也表示处理了异常
        catch (Exception e) {
            throw e;
//            e.printStackTrace();
        }

        System.out.println("main()或者MyMath自己处理了异常,所以我才能能执行");
    }
}
