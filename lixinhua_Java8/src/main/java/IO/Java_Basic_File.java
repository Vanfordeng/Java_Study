package IO;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Doctor on 2016/11/17.
 * Java IO：File
 * Since JDK1.0
 * 学习原则：抽象类中定义的抽象方法会根据实例化其子类的不同，也会完成不同的功能
 * 使用File类进行文件的操作：public class File extends Object implements Serializable, Comparable<File>
 * java.io包中有5个核心类和一个核心接口：
 *   | 五个核心类：File、InputStream、OutputStream、Reader、Writer
 *   | 一个核心接口: Serializable
 * File类的构造方法：
 *  | 设置完整路径：public File(String pathname)
 *  | 设置父路径与子文件路径：public File(File parent,String child)
 * 核心方法：
 *  | 创建新文件：public boolean createNewFile() throws IOException  //异常：如果目录不存在,如果文件重名或者文件名称错误
 *  | 删除文件：public boolean delete()
 *  | 判断文件是否存在：public boolean exists()
 */
public class Java_Basic_File {
    public static void main(String[] args) throws IOException {  //直接抛出异常
        //路径："D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\test.txt“只是一个字符串，\t会变成制表符，所以要加上\表示转义
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"test.txt");
        if (file.exists()){ //文件存在,删除文件
            System.out.println("删除文件：" + file.delete());
        }else {  //文件不存在，新建
            System.out.println("新建文件：" + file.createNewFile());
        }
        //以上程序完成了具体的文件创建和删除操作,但是有两个问题：
        //1.文件路径字符：Windows 使用的是：“\" 路径分隔符,Linux下使用的是“/"
             //|——在File中提供有一个常量：public static final String separator   //separator为什么是小写.Java的历史问题
        //2.在java.io操作的过程之中,会出现延迟的情况，因为Java程序是通过JVM间接的调用的操作系统的文件处理函数进行的文件处理操作
        //所以中间会出现延迟情况。
        File f1 = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"Demo\\test.txt");
        //由于Demo路径不存在,异常： java.io.IOException 系统找不到指定的路径。所以要判断父路径是否存在
        // 获取父路径： public String getParent() {
        //获取父目录：public File getParentFile()
        //创建一级目录：public boolean mkdir()
        //创建多级目录：public boolean mkdirs()
        System.out.println(f1.getParent());
        System.out.println(f1.getParentFile().exists());

        if (f1.getParentFile().exists()){
            f1.delete();
        }else {
            f1.getParentFile().mkdir();
            f1.createNewFile();
        }
        //在File类里面还提供有几个关于文件的相关信息的方法：
          //|——取得文件的大小：public long length()
          //|——取得是否是文件：public boolean isFile()
          //|——取得是否是目录：public boolean isDirectory()
          //|——取得最后的修改时间：public long lastModified()
          //|——取得文件的路径,默认打印file也是打印文件路径： public String getPath()
        File f2 = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"Talk Love.mp3");
        if (f2.exists()){
            System.out.println("文件大小：" +new BigDecimal((double)f2.length()/1024/1024).divide(new BigDecimal(1),2, BigDecimal.ROUND_HALF_UP) + "M");
            System.out.println("最后一次修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(f2.lastModified())));
            System.out.println("文件名称：" + f2.getName());
            System.out.println("文件路径：" + f2.getPath());
            System.out.println("文件所在磁盘的可用空间：" + f2.getUsableSpace()/1024/1024/1024 + "G");
        }
        //在File类里面有定义如下的两个列出目录的方法：
        //|——列出目录下文件和目录的名称信息：public String[] list()
        //|——列出目录下文件和目录的完成路径信息以File类对象包装：public File[] listFiles()
        File f3 = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main");
        if (f3.isDirectory()){
            String[] str_d = f3.list();
            System.out.println(Arrays.toString(str_d));
            File[] f_d = f3.listFiles();
            System.out.println(Arrays.toString(f_d));
            for (int i = 0; i < f_d.length ; i++) {
                System.out.println(f_d[i].getName() + "\t\t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:ss").format(new Date(f_d[i].lastModified())) + "\t\t\t\t" +(f_d[i].isDirectory()?"文件夹":"文件") + "\t\t\t\t"+ (f_d[i].isFile()?new BigDecimal((double)f_d[i].length()/1024).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP)+"KB":""));
            }
        }

        //递归列出某个目录中的所有子目录
        print(f3);
    }

    public static void print(File file){
        if (file.isDirectory()){  //如果现在给定的是一个路径
            System.out.println(file.getPath());
//            System.out.println(file.delete());//恶意代码
            File result[] = file.listFiles(); //列出子目录
            if (result!=null){  //有可能有的文件夹不能列出
                for (int i = 0; i < result.length ; i++) {
                    print(result[i]); //继续列出
                }
            }
        }
    }

}
