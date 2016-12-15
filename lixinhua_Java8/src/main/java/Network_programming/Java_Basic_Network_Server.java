package Network_programming;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Doctor on 2016/11/24.
 * 网络编程
 * 所谓的网络编程：就是进行服务器端和客服端的编程开发操作实现
 * 网络编程有两种形式：
 *  |—：形式一：C/S结构（Client/Server）,此类模式的开发一般要编写两套程序，一套是客户端代码，另外一套属于服务器端代码。这样的开发比较麻烦，要开发和维护连他程序的使用。
 *  但是这类程序有一定好处:安全性高，因为使用的是自己的连接接口，并且使用的是自己的通讯协议。
 *  |—：形式二：B/S结构（Browser/Server）,不再单独开发客户端代码,只开发一套服务器端程序，客户端将利用浏览器进行我们的访问。这种模式只开发一套程序，但是安全性不高，因为使用的是公共的HTTP协议以及公共的80端口。
 *
 *  C/S程序开发,也可以称为Socket程序,C/S结构的程序分为两类：
 *      |—：TCP程序：采用可靠的连接方式进行的传输
 *      |—：UDP程序：不可靠的连接，属于数据报的协议
 *
 *  要进行网络编程，有两个最为核心的类：
 *  Todo 服务器类：ServerSocket:主要工作在服务器端，用于接收用户的请求
 *  ServerSocket：public class ServerSocket extends Object implements Closeable
 *  构造方法：public ServerSocket(int port) throws IOException  //设置监听端口
 *  接收客户端连接：public Socket accept() throws IOException
 *  //Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made.
 *
 *  取得客户端的输出功能,Socket类定义的方法：
 *  public OutputStream getOutputStream() throws IOException
 *  Todo 客户端类：Socket,每一个连接到服务器上的用户都通过Socket表示
 *  构造方法：public Socket(String host,int port)throws UnknownHostException,IOException
 *   |—：host表示主机的IP地址,如果是本机直接范围那么使用localhost(127.0.0.1)代替IP
 *   |—：获得输入数据：public InputStream getInputStream() throws IOException  使用Scanner封装比较合适
 *
 * Todo 服务器上的Socket是对应的客户端连接过来的Client（本质也是Socket）,所以是Socket之间的通信
 */
public class Java_Basic_Network_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);  //要想连接：除了有服务器还必须有端口。Socket表示的客户端
        System.out.println("等待客户端连接...");
        Socket server_socket = server.accept();  //等待客户端连接   造成阻塞，会造成大量资源浪费，包括端口。所以java.nio出现主要解决服务器这方面的问题
        PrintStream server_out = new PrintStream(server_socket.getOutputStream()); //用户向客户端的Socket发送数据
        Scanner server_in = new Scanner(server_socket.getInputStream());  //用于接收客户端发送过来的数据
        server_out.println("你好啊，客户端!"
                + "\nHello World"+"\nFuck Company");   //向客户端发送数据：你好啊，客户端
        if (server_in.hasNext()){//用于判断是否客户端有数据发送进来
            System.out.println(server_in.next()); //打印客户端发送进来的数据
        }
        server_out.close();
        server_in.close();
        System.out.println("连接已经断开");
        server_socket.close();
        server.close();
        //此时服务器只是输出已给Hello World字符串而后就关闭服务器操作。

    }
}

