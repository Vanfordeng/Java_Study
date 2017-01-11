package DAO_design_mode;

/**
 * Created by Doctor on 2017/1/5.
 */
public class Java_DAO_Project_Summary {
    public static void main(String[] args) {
        //Todo 项目准备
        /**首先可以设置一个项目名称,DAOProject,并且由于此项目需要使用Oracle数据库,需要将其配置好数据库的驱动程序
         *请保证数据库打开监听与实例服务
         * 为了方便的进行程序的统一管理,所有的项目的父包名称统一设置为DAO_Project.而子包要根据不同的功能模块进行划分
         */
        //Todo 数据库连接类
        /**
         * 本次的操作既然要进行数据库的开发,那么久必须进行数据库的连接取得与关闭才可以正常操作,那么几乎所有的数据库的连接
         * 都是固定的步骤，那么就可以单独定义一个 DatebaseConnection类,这个类主要负责数据库的连接对象的取得以及数据库的关闭操作
         * 既然是一个专门用于数据库的连接操作，那么可以将其保存在dbc子包中：
         */
    }
}
