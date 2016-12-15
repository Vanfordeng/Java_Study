package Network_programming;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Doctor on 2016/11/24.
 * Echo 小程序客户端
 */
public class Java_Basic_Network_Echo_Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9988);
        Scanner input = new Scanner(System.in);  //键盘输入数据
        Scanner scan =  new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        input.useDelimiter("\\n");
        scan.useDelimiter("\\n");
        while (flag){
            System.out.println("请输入要发送的数据：");
            if (input.hasNext()){
                String str = input.next().trim();
                out.println(str);
                if (str.equalsIgnoreCase("exit")){
                    System.out.println(scan.next());
                    flag = false;
                }else {
                    if (scan.hasNext()){
                        System.out.println(scan.next()); //输出回应信息
                    }
                }
            }
        }
        input.close();
        scan.close();
        out.close();
        client.close();
    }
}
