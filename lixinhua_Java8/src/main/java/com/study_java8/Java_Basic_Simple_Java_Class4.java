package com.study_java8;

import org.omg.PortableInterceptor.ACTIVE;

/**
 * Created by Doctor on 2016/10/9.
 * 多对多
 * 生成的只能是实体表的转换操作
 */
class Admin{
    private String aid;
    private String password;
    private Role role;
    public Admin(String aid,String password) {
        this.aid = aid;
        this.password = password;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return  this.role;
    }
    public String getInfo(){
        return "管理员编号：" + this.aid + "\t管理员密码：" + this.password;
    }
}
class Role{
    private int rid;
    private String title;
    private Admin[] admins;
    private Group[] groups;  //一个角色有多个权限
    public Role(int rid,String title){
        this.rid = rid;
        this.title =  title;
    }
    public void setAdmins(Admin[] admins){
        this.admins = admins;
    }
    public Admin[] getAdmins(){
        return this.admins;
    }
    public void setGroups(Group[] groups){
        this.groups =  groups;
    }
    public Group[] getGroups(){
        return this.groups;
    }
    public String getInfo(){
        return "角色编号：" + this.rid + "\t角色名称:" + this.title;
    }
}
class Group{
    private int gid;
    private String title;
    private Role[] roles;  //一个权限组有多个角色
    private Action[] action;

    public Group(int gid,String title){
        this.gid = gid;
        this.title = title;
    }
    public void setRoles(Role[] roles){
        this.roles = roles;
    }
    public Role[] getRoles(){
        return this.roles;
    }
    public void setAction(Action[] action) {
        this.action = action;
    }
    public Action[] getAction() {
        return this.action;
    }
    public String getInfo(){
        return "权限组编号：" + this.gid + "\t权限组名称：" + this.title;
    }
}
class Action{
    private  int aid;
    private String title;
    private String url;
    private Group group;

    public Action(int aid, String title, String url){
        this.aid = aid;
        this.title = title;
        this.url = url;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public String getInfo(){
        return "权限编号:" + this.aid + "\t权限名称:" + this.title + "\t权限URL：" + this.url;
    }
}
//实际上多对多和一对多从类的定义上来讲区别不是很大
public class Java_Basic_Simple_Java_Class4 {
    public static void main(String[] args){
        //第一步：设置完整关系
        //1.准备出若干个对象
        Admin a1 = new Admin("admin","hello");
        Admin a2 = new Admin("mldn","hello");
        Admin a3 = new Admin("ayou","hello");
        Role r1 = new Role(1,"系统管理员");
        Role r2 = new Role(2,"信息管理员");
        Group g1 =  new Group(10,"信息管理组");
        Group g2 =  new Group(11,"用户管理组");
        Group g3 =  new Group(12,"数据管理组");
        Group g4 =  new Group(13,"接口管理组");
        Group g5 =  new Group(14,"备份管理组");
        Action ac1 =  new Action(10010,"新闻发布","-");
        Action ac2 =  new Action(10011,"新闻列表","-");
        Action ac3 =  new Action(10012,"新闻审核","-");
        Action ac4 =  new Action(10013,"增加用户","-");
        Action ac5=  new Action(10014,"用户列表","-");
        Action ac6 =  new Action(10015,"登陆日志","-");
        Action ac7 =  new Action(10016,"雇员数据","-");
        Action ac8 =  new Action(10017,"部门数据","-");
        Action ac9 =  new Action(10018,"公司数据","-");
        Action ac10 =  new Action(10019,"服务传输","-");
        Action ac11 =  new Action(100110,"短信平台","-");
        Action ac12 =  new Action(100111,"全部备份","-");
        Action ac13 =  new Action(100112,"局部备份","-");
        //2.要设置这些对象之间的基本关系
        //设置管理员与角色的关系
        a1.setRole(r1);
        a2.setRole(r2);
        a3.setRole(r2);
        r1.setAdmins(new Admin[]{a1});
        r2.setAdmins(new Admin[]{a1,a2});
        //设置角色与管理员组
        r1.setGroups(new Group[]{g1,g2,g3,g4,g5});
        r2.setGroups(new Group[]{g1,g2});
        g1.setRoles(new Role[]{r1,r2});
        g2.setRoles(new Role[]{r1,r2});
        g3.setRoles(new Role[]{r1});
        g4.setRoles(new Role[]{r1});
        g5.setRoles(new Role[]{r1});
        //设置权限组与管理员组
        g1.setAction(new Action[]{ac1,ac2,ac3});
        g2.setAction(new Action[]{ac4,ac5,ac6});
        g3.setAction(new Action[]{ac7,ac8,ac9});
        g4.setAction(new Action[]{ac10,ac11});
        g5.setAction(new Action[]{ac12,ac13});
        ac1.setGroup(g1);
        ac2.setGroup(g1);
        ac3.setGroup(g1);
        ac4.setGroup(g2);
        ac5.setGroup(g2);
        ac6.setGroup(g2);
        ac7.setGroup(g3);
        ac8.setGroup(g3);
        ac9.setGroup(g3);
        ac10.setGroup(g4);
        ac11.setGroup(g4);
        ac12.setGroup(g5);
        ac13.setGroup(g5);
        //第二步：去除数据内容
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(a1.getInfo());
        System.out.println("\t |- " + a1.getRole().getInfo());
        for (int i = 0; i < a1.getRole().getGroups().length; i++) {
            System.out.println("\t\t | - " + a1.getRole().getGroups()[i].getInfo());
            for (int x = 0; x < a1.getRole().getGroups()[i].getAction().length; x++) {
                System.out.println("\t\t\t | - " + a1.getRole().getGroups()[i].getAction()[x].getInfo());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(g2.getInfo());
        for (int i = 0; i <g2.getRoles().length; i++) {
            System.out.println("\t |- "+g2.getRoles()[i].getInfo());
            for (int y = 0; y < g2.getRoles()[i].getAdmins().length; y++) {
                System.out.println("\t\t |- " + g2.getRoles()[i].getAdmins()[y].getInfo());
            }
        }

    }
}
