package com.study_mars.Practice_Mars.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Doctor on 2016/9/14.
 */
//该类当中包含了常用IO工具函数
public class IOUtils {
    public static Properties loadProperties(String path){
        Properties properties = new Properties();
        try {
            //获取本项目的路径"D:\AndroidStudioProjects\Java_IO"
            String projectPath = System.getProperty("user.dir");
            //File.separator 获取系统目录分隔符
            String propertiesPath = projectPath+ File.separator+"resources";
            properties.load(new FileInputStream(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
//   public static write
}
