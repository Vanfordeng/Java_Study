package com.study_java8;

/**
 * Created by Doctor on 2016/10/10.
 * 可用链表：指的是可以使用链表实现增加，删除，修改，查询操作
 * 在开发具体的可用链表操作之前，首先必须明确一个道理：Node类负责所有节点数据的保存以及节点关系的匹配，所以Node类不可能单独去使用
 * 而上一节的实现里面Node是可以单独使用的，外部可以绕过Link类直接操作Node类。这样明显没有意义
 */
//class Book6{
//    private String title;
//    private double price;
//    public Book6(String title,double price){
//        this.title = title;
//        this.price = price;
//    }
//    public String getInfo(){
//        return  "图书名称：" + this.title + "\t图书价格：" + this.price;
//    }
//    //由于链表中要保存的对象需要是实现contains()、remove()等功能，所以在类中要提供有对象比较方法的支持
//    public boolean compare(Book6 book){
//        if (this ==  book){
//            return true;
//        }
//        if (book == null){
//            return false;
//        }
//        if (this.price ==book.price && this.title.equals(book.title)){
//            return  true;
//        }
//        return false;
//    }
//}

class Province1{
    private int pid;
    private String name;
//    private City[] cities;
    //将City1[]数组用链表Link1替换：链表最好的使用就是横向替代掉对象数组，链表没有长度限制
    private Link1 cities = new Link1();

    public Province1(int pid,String name){
        this.pid = pid;
        this.name = name;
    }
    //new Link1 直接初始化,就不需要使用setCities了
//    public void setCities(Link1 cities){
//        this.cities =  cities;
//    }
    public Link1 getCities(){
        return this.cities;
    }
    //省份中的compare方法可以省略，链表中存储的是City1类型
    public boolean compare(Province1 province){
        if (this == province){
            return true;
        }
        if (province == null){
            return false;
        }
        if (this.pid == province.pid && this.name.equals(province.name)){
            return true;
        }
        return false;
    }
    public String getInfo(){
        return "省份编号：" + this.pid + "\t省份名称：" + this.name;
    }
}
class City1{
    private int cid;
    private String name;
    private Province1 province;

    public City1(int cid,String name){
        this.cid = cid;
        this.name = name;
    }
    public void setProvince(Province1 province){
        this.province = province;
    }
    public Province1 getProvince(){
        return this.province;
    }
    public boolean compare(City1 city){
        if (this ==  city){
            return true;
        }
        if (city == null){
            return false;
        }
        //TODO this.province ==  city.getProvnce 这个肯定是不等的,因为两个不同的city.province的地址肯定不同
        //city.getProvince 等下钓鱼 city.province
        //this.province.compare(city.province)以防止不同省份出现同名城市的情况（显示中cid可能不同）
        //此代码中要求城市必须设置省份,不然执行到this.province.compare会出现nullPointerException
        if (this.cid ==  city.cid && city.name.equals(this.name) && this.province.compare(city.province)){
            return true;
        }
        return false;
    }
    public String getInfo(){
        return "城市编号：" + this.cid + "\t 城市名称：" + this.name;
    }
}
//链表就是一个对象数组,对象数组在进行数据表映射的时候一定会用到
class Link1{ //链表类，外部能够看见的 只有这一个类
    private Node root;
    private int count = 0; //保存元素的个数
    private int foot = 0; //在Link类里面增加一个foot属性,表示每一个Node元素的编号（也即是没增加一个next,foot自增加1）
    private City1[] retArray; //增加一个返回的数组属性内容,之所以将其定义为属性,是因为内部类和外部类都可以访问

    //------------添加数据:public void add(String data)(数据不一定就是String类型)------------------------------------
    public void add(City1 data){
        //对传入的数据进行Node封装
        Node newNode = new Node(data);
        if (data ==  null){
            return;
        }
        if (this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count ++; //每一次保存完成后数量加1
    }
    //------------取得链表中的元素个数:public int size()------------------------------------
    /*
     * 增加一个count属性
     * 在add()方法里面增加数据的统计操作；
     */
    public int size(){
        return this.count;
    }
    //------------判断是否为空链表: public boolean isEmpty()------------------------------------
    /*
     * 有两种方式判断：1.判断root有对象（是否为null） 2.判断保存是数量（count）
     */
    public boolean isEmpty(){
        if (this.count == 0 && this.root == null){
            return true;
        }
        return false;
    }
    //------------数据查询：public boolean contains(数据类型 变量)------------------------------------
    public boolean contains(City1 data){
        //现在没有要查询的数据，根节点也不保存数据
        if (data ==  null || this.root == null){
            return false;
        }
        return this.root.containsNode(data);
    }
    //------------根据索引取得数据：public 数据类型 get(int index)------------------------------------
    /*
     *通过以上的代码测试可以发现,链表里面保存了多个String类的对象,在程序里面只有数组可以保存多个对象，现在使用的链表
     * 和数组相比较的话,优势就是没有长度限制（劣势就是复杂),所以链表严格意义上来讲就是一个动态对象数组，那么既然链表属于动态对象数组
     * ，那么也应该具备向数组那样可以根据索引取得元素的功能
     * 由于是动态对象数组,所以数组中的每一个元素的索引都应该是动态生成的。
     */
    public City1 get(int index){
        if (index >= this.count){  //超过了查询范围
            return null;  //没有数据
        }
        this.foot  = 0 ;//表示从前往后查找  ：foot为全局变量，会在set或者get之后改变值，所有每次使用的时候需要重新赋初值为0
        return this.root.getNode(index);
    }
    //------------修改指定索引内容：public boolean set(int index,数据类型 变量)------------------------------------
    public boolean set(int index,City1 data){
        if (index >= this.count){
            return false;  //结束方法调用
        }
        this.foot = 0; //重新设置foot属性的内容，作为索引出现
        return this.root.setNode(index,data);
    }
    //------------删除指定数据：public void remove(数据类型 变量)---------------------------------------------------
    //情况一：要删除的数是根节点，则root应该变为“根节点的next"
    //情况二：要删除的不是根节点，则当前节点上一节点的next = 当前节点的next,即：空出当前节点
     /*
      * Eg:link1.remove("Nihao");
      */
    public void remove(City1 data){
        //this本身存储的是引用对象的地址,在栈内存中this也有自己的地址。只是Java中无法去获取this本身的地址，
        if (this/*此处如果不显示加上this,也会有个默认隐藏的this引用*/.contains(data)){
            //root是Node类的对象,此处直接访问了内部类的私有属性：data和next
            if (data.compare(this.root.data)){
                this.root = this.root.next; //改变this.root的引用来修改root的内容
            }else {
                this.root.next.removeNode(this.root,data);
            }
        }else {
            return;
        }
        this.count--;
    }
    //------------将链表变为对象数组：public 数据类型[] toArray()---------------------------------------------------
    //将链表以对象数组的形式返回：任何情况下,不管是什么样的类,都不可能在类中使用输出语句，只要是想输出数据一定将数据返回到
    //调用出进行输出，而由于链表属于动态对象数组，所以此处最好的做法是剑链表以对象数组的形式返回。
    public City1[] toArray(){
        if (this.root == null){
            return null;
        }
        this.foot = 0;  //需要脚标控制
        this.retArray = new City1[this.count]; //根据保存内容开辟数组
        this.root.toArrayNode();  //交给Node类处理
        return this.retArray;
    }

    public void print(){
        if (this.root != null){
            this.root.printNode();
        }
    }
    //之所以定义在内部，主要是让其为Link类服务。为了只能让Link1类所使用。加上private修饰
    private class Node{  //定义的一个节点
        private City1 data;
        private Node next;

        public Node(City1 data){
            this.data = data;
        }
        //------------添加数据-------------------------------
        public void addNode(Node newNode){
            if (this.next == null){
                this.next = newNode;
            }else {
                this.next.addNode(newNode);
            }
        }
        //------------查询数据-------------------------------
        public boolean containsNode(City1 data){
            if (this.data.compare(data)/*只需要满足root节点包含的数据与data相同就可以返回true,后续节点不用再查询*/){
                return true;
            }else {
                if (this.next != null){
                    return this.next.containsNode(data);
                }else {
                    return false;
                }
            }
        }
        //------------根据索引取得数据----------------------------------------------------------------------------------------------------------------------------------------------
             //System.out.println("链表根据索引查询数据：" + link1.get(2));
                /*
                 * 第一次调用getNode函数的是：Link1.root等效于【this.root.getNode(2)】;
                 * 1.foot =0 ,                                       /此时的this为：Link1.root/
                 * index =2; 执行getNode(2),不满足条件：if(0==2),执行return this.next.getNode(2),等待this.next.next.getNode(2)执行完毕再return  this.next.next.getNode(2)
                 * 2.foot =1,                                       /此时的this为：Link1.root.next/
                 * index =2,执行getNode(2),不满足条件：if(1==2),执行return this.next.getNode(2)等待this.next.next.next.getNode(2)执行完毕再return this.next.next.next.getNode(2)
                 * 3.foot=2                                       /此时的this为：Link1.root.next.next/
                 * ,index=2,执行getNode(2),满足条件：if(2==2),执行return this.data 返回data
                 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------
                 * 总结：如下代码涉及到的知识有
                 * 1.函数迭代
                 * 2.this引用传递
                 * 3.next（Node对象引用）的传递
                 * 4.Link1.this.foot，内部类访问外部类属性的方式
                 * 5.通过this的引用传递,用foot++来对应this的next变动达到索引的目的
                 *  -----------------------------------------------------------------------------------------------------------------------------------------------------------------
                 */
        public City1 getNode(int index){
            //Link1.this.foot++ == index
            if (Link1.this.foot++ == index){  //Link1.this.foot++ == index
                return this.data;

            }else {
                return this.next/*主要是通过next来迭代访问后续node*/.getNode(index);
            }
        }
        //------------修改指定索引内容------------------------------------
        public boolean setNode(int index,City1 data){
            if (Link1.this.foot++ == index){
                this.data = data;
                return true;
            }else {
                this.next.setNode(index,data);
            }
            return false;
        }
        //------------删除指定数据------------------------------------
        //如下方法的调用关系如下：
        //第一次调用(Link)，previous =  Link.root、this = Link.root.next
        //第二次调用(Node)，previous = Link.root.next、this = link1.root.next.next
        //第三次调用(Node)，previous = link1.root.next.next、this = link1.root.next.next.next

        public void removeNode(Node previous,City1 data){
            if (data.compare(this.data)){  //当前节点为要删除的节点
                previous.next = this.next;  //将上一个节点的下一个节点设置为当前节点的下一个节点,空出当前节点
            }else {
                //应该先后继续查询
                this.next.removeNode(this,data);
            }
        }
        //------------将链表变为对象数组---------------------------------------------------
        //链表数据变为对象数组去除是最为重要的功能
        public void toArrayNode(){
            //访问了Link1中的foot和retArray属性
            Link1.this.retArray[Link1.this.foot++] = this.data;
            if (this.next != null){ //有后续元素
                this.next.toArrayNode();
            }
        }
        public void printNode(){
            System.out.println(this.data);
            if (this.next !=  null){
                this.next.printNode();
            }
        }
    }
}


public class Java_Basic_LinkedList1 {
    public static void main(String[] args){
        // 11111111- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//        link1.add("Hello");
//        link1.add("Wrold");
//        link1.add("Nihao");
//        link1.add("MLDN");
//        link1.add(null);
//        link1.print();
//        System.out.println("链表的的数据个数 ：" + link1.size());
//        System.out.println("链表是否为空 ：" + link1.isEmpty());
//        System.out.println("链表是否包含某个数据：" + link1.contains("World"));
//        System.out.println("链表根据索引查询数据：" + link1.get(2));
//        System.out.println("链表根据索引设置数据：" + link1.set(2,"1111111111"));
//        link1.print();
//        System.out.println("链表根据索引查询数据：" + link1.get(2));
//        link1.remove("MLDN"); //TODO 只能删除第一个匹配项目可以通过如下代码删除所有的
//        while (link1.contains("Hello")){
//            link1.remove("Hello");
//        }
//        System.out.println("链表根据索引查询数据：" + link1.get(2));
//        System.out.println("链表的的数据个数 ：" + link1.size());
//        link1.print();
//        System.out.println("--------------------------");
//        String[] ret = link1.toArray();
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
        //22222222222------------------------------保存自定义类对象，以下链表的使用方式符合日常用户使用平时习惯-----------------------------------
        //------------------------------保存自定义类对象，以下链表的使用方式符合日常用户使用平时习惯-----------------------------------
        //------------------------------保存自定义类对象，以下链表的使用方式符合日常用户使用平时习惯-----------------------------------
//        System.out.println("--------------------------");
//        Link1 link1 = new Link1();
//        link1.add(new Book6("Java开发",89.9));
//        link1.add(new Book6("JSP开发",77.8));
//        link1.add(new Book6("Python开发",66.7));
//        System.out.println(link1.size());
//        System.out.println(link1.contains(new Book6("Java开发",89.9)));
//        link1.remove(new Book6("Python开发",66.7));
//        Book6[] ret = link1.toArray();
//        for (int i = 0; i <ret.length ; i++) {
//            System.out.println(ret[i].getInfo());
//        }
//        System.out.println(link1.size());
        System.out.println("--------------------------");
        //第一步：设置关系数据
        //1.先准备好各自独立的对象
        Province1 pro =  new Province1(1,"河北省");
        City1 c1 =  new City1(1001,"唐山");
        City1 c2 =  new City1(1002,"秦皇岛");
        City1 c3 =  new City1(1003,"石家庄");
        //2.设置关系
        c1.setProvince(pro);  //TODO 居然没有NullPointerException
//        c2.setProvince(pro);
        //pro 用了一个Link1保存数据和用City1[]数据保存数据的区别如下：
        pro.getCities().add(c1);
        pro.getCities().add(c2);
        pro.getCities().add(c3);
        //第二步：取出关系：new Province(1,"河北省")
        System.out.println(pro.getInfo());
        City1[] cities =  pro.getCities().toArray();
        for (int i = 0; i <cities.length ; i++) {
            System.out.println("\t | - " + cities[i].getInfo());
        }
        System.out.println("\t | - " + pro.getCities().size());
        System.out.println("\t | - " + pro.getCities().contains(c3));
        pro.getCities().remove(c2);
        System.out.println("\t | - " + pro.getCities().size());
        System.out.println("\t | - " + pro.getCities().contains(c3));
        //链表最好的使用就是横向替代掉对象数组，链表没有长度限制,但是如果内容太多会占用很多内存使程序变慢
        //方法解决的是代码的重复问题,但是以上问题不属于代码的重复，属于数据类型的不统一，所以这个时候我们在之前所学习到的知识就不足与来解决此类问题。
        Province1[] str = new Province1[]{new Province1(1,"河北省")};
    }
}
