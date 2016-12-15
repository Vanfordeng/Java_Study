package Network_programming;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Doctor on 2016/11/24.
 * 网络编程经典案例：Echo 程序
 * 本程序的意义在于：客户端随意输入信息并且将信息发送给服务器端,服务器端接收之后前面加上一个“ECHO”的标记返回
 *  本程序设计如下：
 *        由于需要采用多次输入的形式,所以不能够每次连接后立刻关闭服务器
 *        可以设置一个字符串,如果输入了“exit"，那么才表示结束本次的Echo操作
 *@总结：
 *@服务器开发的基础要素：网络支持类,IO,多线程(还有：资源同步,线程之间的通讯)
 *@网络需要端口
 *
 */
class EchoThread implements Runnable{
    private Socket client;
    private ServerSocket server;
    public static int foot = 0;
    public EchoThread(Socket client,ServerSocket server){
        this.client = client;
        this.server = server;
        foot ++;
    }

    @Override
    public void run() {
        try {
            //得到客户端输入数据以及向客户端输出数据的对象
            Scanner scan = new Scanner(client.getInputStream());
            PrintStream out = new PrintStream(client.getOutputStream());

            boolean flag = true;  //给While循环设置一个开关：但满足某个条件的时候,将开关关掉以跳出循环和给While循环社会一个脚标：脚标的目的是为了在满足某个数量执行某个操作或者满足某个条件得到脚标数量
            scan.useDelimiter("\\n");
            while (flag) {
                if (scan.hasNext()) {
                    String str = scan.next().trim();//得到客户端发送的内容
                    if (str.equalsIgnoreCase("exit")) { //程序要结束
                        out.println("服务器告诉客户端,我已经断开连接,byebye" + new Date());
                        System.out.println("服务器给自己说,咱已经关闭了" + new Date());
                        flag = false;
                    } else {//应该回应输入信息
                        out.println("ECHO:" + str);
                    }
                }
            }
            client.close();
            this.foot -- ;
            System.out.println("还剩下" + this.foot + "个用户");
            scan.close();
            out.close();
            if (this.foot == 0){
                server.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class Java_Basic_Network_Echo_Server {
    public static void main(String[] args) throws Exception{
        //实现服务器代码
        ServerSocket server = new ServerSocket(9988);
//        Socket client = server.accept();   //启用服务器监听
        boolean flag = true;  //给While循环设置一个开关：但满足某个条件的时候,将开关关掉以跳出循环和给While循环社会一个脚标：脚标的目的是为了在满足某个数量执行某个操作或者满足某个条件得到脚标数量
        while (flag){
//            foot++;  ++符号的先使用foot的值再加1和++foot先加1再使用foot的值的特性是在表达式中。如：foot++!=0，但是for循环的自增和自减是在表达式判断之后,如果成立执行for循环体后再执行for(i=0；i<10;i++)
            Socket client = server.accept();  //启动服务器监听,每次来一个客户端连接就新建一个client
            new Thread(new EchoThread(client,server)).start();
            System.out.println("第" + EchoThread.foot + "客户端连接成功!");
        }

        //得到客户端输入数据以及向客户端输出数据的对象
//        Scanner scan =  new Scanner(client.getInputStream());
//        PrintStream out = new PrintStream(client.getOutputStream());
//
//        scan.useDelimiter("\\n");
//        while (flag){
//            if (scan.hasNext()){
//                String str = scan.next().trim();//得到客户端发送的内容
//                if (str.equalsIgnoreCase("byebye")){ //程序要结束
//                    out.println("服务器告诉客户端,我已经断开连接,byebye" + new Date());
//                    System.out.println("服务器给自己说,咱已经关闭了" + new Date());
//                    flag = false;
//                }else {//应该回应输入信息
//                    out.println("ECHO:" + str);
//                }
//            }
//        }
//        client.close();
//        scan.close();
//        out.close();

        //此时的程序只能够连接一个客户端,而不能够连接其它客户端,因为所有的操作都是在主线程上进行的开发。
        //此时的程序属于但线程的网络应用，实际中不能如此进行。所以必须改为多线程描述。
    }
}
