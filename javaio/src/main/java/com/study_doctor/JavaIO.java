package com.study_doctor;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 1.在Java语言的java.io包中，由File类提供了描述文件和目录的操作与管理方法。但File类不是InputStream、OutputStream或Reader、Writer的子类，因为它不负责数据的输入输出，而专门用来管理磁盘文件与目录。
 * 2.文件对象创建后，指定的文件或目录不一定物理上存在
 */
public class JavaIO {
    public static void main(String[] args){
        for(int i =0;i< args.length; i++){
            System.out.println("args[" + i + "] is <" + args[i] + ">");
        }
    }

    public void StandardInputOutput(){
        int b;
        try {
            System.out.println("please Input:");
            while ((b = System.in.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void File() throws IOException {
        File dir = new File("\\root");
        File f1 = new File(dir, "fileOne.txt");
        File f2 = new File(dir, "fileTwo.java");

        if (!dir.exists())
            dir.mkdir();
        if (!f1.exists())
            f1.createNewFile();
        if (!f2.exists())
            f2.createNewFile();
        System.out.println("f1's AbsolutePath=  " + f1.getAbsolutePath());
        System.out.println("f1 Canread=" + f1.canRead());
        System.out.println("f1's len= " + f1.length());
        String[] FL;
        int count = 0;
        FL = dir.list();
        for (int i = 0; i < FL.length; i++) {
            count++;
            System.out.println(FL[i] + "is in \\root");
        }
        System.out.println("there are" + count + "file in //root");
    }
    public void printWrite(){
    }
}
