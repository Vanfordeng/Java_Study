package Network_programming;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Doctor on 2016/11/24.
 * TCP 客户端
 */
public class Java_Basic_Network_Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);  //连接服务器端
        Scanner scanner_client = new Scanner(client.getInputStream());
        scanner_client.useDelimiter("\n");
        PrintStream out_client = new PrintStream(client.getOutputStream());
        if (scanner_client.hasNext()){
            System.out.println(scanner_client.next());
        }
        out_client.println("你好呀，服务器");
        scanner_client.close();
        out_client.close();
        client.close();
    }
}
