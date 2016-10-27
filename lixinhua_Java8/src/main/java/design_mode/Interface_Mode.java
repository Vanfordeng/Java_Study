package design_mode;

/**
 * Created by Doctor on 2016/10/21.
 * 接口：用于不同层之间：解耦和的关键
 * 宠物商店:接口用于定义宠物的标准来了解宠物商店和宠物子类实例：Dog/Cat
 * 简单的扩充：
 * 一个停车场可以停多辆车
 * 一个电脑可以插入多个USB设备
 * 一个公园可以拥有多个数目
 * 一个动物园可有多种动物
 * 。。。。。。。。。
 */
class Link{ //链表类，外部能够看见的 只有这一个类
    private Node root;
    private int count = 0; //保存元素的个数
    private int foot = 0; //在Link类里面增加一个foot属性,表示每一个Node元素的编号（也即是没增加一个next,foot自增加1）
    private Object[] retArray; //增加一个返回的数组属性内容,之所以将其定义为属性,是因为内部类和外部类都可以访问

    //------------添加数据:public void add(String data)(数据不一定就是String类型)------------------------------------
    public void add(Object data){
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
    public boolean contains(Object data){
        if (data ==  null || this.root == null){
            return false;
        }
        return this.root.containsNode(data);
    }
    public Object get(int index){
        if (index >= this.count){  //超过了查询范围
            return null;  //没有数据
        }
        this.foot  = 0 ;//表示从前往后查找
        return this.root.getNode(index);
    }
    //------------修改指定索引内容：public boolean set(int index,数据类型 变量)------------------------------------
    public boolean set(int index,Object data){
        if (index >= this.count){
            return false;  //结束方法调用
        }
        this.foot = 0; //重新设置foot属性的内容，作为索引出现
        return this.root.setNode(index,data);
    }
    //------------删除指定数据：public void remove(数据类型 变量)---------------------------------------------------
    public void remove(Object data){
        //this本身存储的是引用对象的地址,在栈内存中this也有自己的地址。只是Java中无法去获取this本身的地址，
        if (this/*此处如果不显示加上this,也会有个默认隐藏的this引用*/.contains(data)){
            //root是Node类的对象,此处直接访问了内部类的私有属性：data和next
            if (data.equals(this.root.data)){
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
    public Object[] toArray(){
        if (this.root == null){
            return null;
        }
        this.foot = 0;  //需要脚标控制
        this.retArray = new Object[this.count]; //根据保存内容开辟数组
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
        private Object data;
        private Node next;

        public Node(Object data){
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
        public boolean containsNode(Object data){
            if (this.data.equals(data)/*只需要满足root节点包含的数据与data相同就可以返回true,后续节点不用再查询*/){
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
        public Object getNode(int index){
            //Link1.this.foot++ == index
            if (Link.this.foot++ == index){  //Link1.this.foot++ == index
                return this.data;

            }else {
                return this.next/*主要是通过next来迭代访问后续node*/.getNode(index);
            }
        }
        //------------修改指定索引内容------------------------------------
        public boolean setNode(int index,Object data){
            if (Link.this.foot++ == index){
                this.data = data;
                return true;
            }else {
                this.next.setNode(index,data);
            }
            return false;
        }
        //------------删除指定数据------------------------------------

        public void removeNode(Node previous,Object data){
            if (data.equals(this.data)){  //当前节点为要删除的节点
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
            Link.this.retArray[Link.this.foot++] = this.data;
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
interface Pet{ //定义一个宠物的标准
    public String getName(); //获取宠物名
    public int getAge(); //获取宠物年级
}
class PetShop{ //一个宠物商店要保持多个宠物信息
    private Link pets = new Link();  //一对多
    public void add(Pet pet){ //上架
        this.pets.add(pet); //将pet保存到链表
    }
    public void delete(Pet pet){ //下架
        this.pets.remove(pet); //remove方法需要实现equals方法
    }
    //模糊查询一定是返回多个内容，不知道多少个内容使用Link
    public Link search(String keyWord){
        Link result =  new Link();
        Object[] objs = this.pets.toArray();
        for (int i = 0; i < objs.length ; i++) {
            //因为pets Link里面的所有元素都是pet向上Object转型。所有可以直接向下转型
            Pet p = (Pet)objs[i];
            if (p.getName().contains(keyWord)){
                result.add(p);
            }
        }
        return  result;
    }
}
class Cat implements Pet{   //如果不实现接口，无法保存为宠物信息。宠物中都使用的Pet接口
    private  String name;
    private int age;

    public Cat(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public boolean equals(Object obj){
        if (this ==  obj){
            return true;
        }
        if (obj == null){
            return  false;
        }
        //防止出现属性相同，但是类型不是Cat类型的对象使用于被比较出现ClassCastException异常
        if (!(obj instanceof  Cat)){
            return false;
        }
        Cat c = (Cat) obj;

        if (this.name.equals(c.name) && this.age == c.age){
            return true;
        }
        return false;
    }

    public String toString(){
        return "猫的名字：" + this.name + "\t 猫的年龄：" + this.age;
    }

}
class Dog implements Pet{
    private String name;
    private int age;

    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
    public boolean equals(Object obj){
        if (this == obj){return true;}
        if (obj == null){return  false;}
        if (!(obj instanceof Dog)){return false;}
        Dog d = (Dog)obj;
        if (this.name.equals(d.name) && this.age == d.age){return true;}
        return false;
    }

    public String toString(){
        return "狗的名字：" + this.getName() + "\t狗的年龄：" + this.age;
    }
}
public class Interface_Mode {
    public static void main(String[] args){
        Cat c1 = new Cat("小花",2);
        Cat c2 = new Cat("小四",5);
        Cat c3 = new Cat("小七",7);
        Dog d1 = new Dog("小狗1",9);
        Dog d2 = new Dog("小狗2",10);
        Dog d3 = new Dog("小狗3",11);

        PetShop ps = new PetShop();
        ps.add(c1);
        ps.add(c2);
        ps.add(c3);
        ps.add(d1);
        ps.add(d2);

        Object[] objs = ps.search("小").toArray();

        for (int i = 0; i <objs.length; i++) {
            //如下不需要再见objs向下转型为Pet,因为toString方法为Object的方法并且已经在Cat和Dog从覆写。使用的时候会自动使用子类的toString
            System.out.println(objs[i]);
        }

        ps.delete(c3);
        ps.delete(c2);

        System.out.println("------------------------------");
        Object[] objs1 = ps.search("小").toArray();

        for (int i = 0; i <objs1.length; i++) {
            System.out.println(objs1[i]);
        }

    }
}
