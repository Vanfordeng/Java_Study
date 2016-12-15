package Data_Structure;

import java.util.Arrays;

/**
 * Created by Doctor on 2016/11/3.
 * 二叉树：
 * @树是一种比链表更为复杂的概念应用，本质也属于动态对象数组，但是与链表不同在于，树的最大特征可以针对于数据进行排序
 * 树的操作原理：选择第一个数据作为根节点，而后比根节点小的放在根节点的左子树（左节点），而比根节点大的数据放在右子树（右节点）
 * 取得的时候按照中序遍历的方式取出（左-中-右）
 * Todo 在任何数据结构里面Node类的核心功能是保存真实数据以及配置节点关系.private City data;  private Node next;
 */
 class Tree{     //定义二叉树类
    private Node root;   //定义根节点
    private int count;    //统计元素个数
    private Object[] retData;   //定义要返回的数组,使用Object可读性更高，也更实用，可以接收任意类型。而改为Comparable也无非是Object的子类而已
    private int foot;

    public Node getRoot() {
        return root;
    }

    //添加元素
    public void add(Object obj){  //进行数据的追加 或者直接定义为：    public void add(Comparable obj) 但是Object类型来接收数据可读性更强
        Comparable com = (Comparable) obj;   //必须变为Comparable才可以实现Node保存,才能进行比较和排序，这里不是只将Object类型转换为Comparable接口类型,而是向下转型为Comparable的子类型
        Node newNode = new Node(com);  //创建新的节点

        if (this.root == null){   //现在不存在根节点
            this.root = newNode;    //保存根节点
        }else {
            this.root.addNode(newNode); //交给Node类处理
        }
       this.count ++;
    }

    //获取各个元素
    public Object[] toArray(){
        if (this.root == null){
            return null;
        }
        this.foot = 0;
        this.retData = new Object[this.count];
        this.root.toArrayNode();
        return this.retData;
    }

    //获取元素个数
    public int getCount(){
        return this.count;
    }

    @SuppressWarnings("rawtypes")
    public class Node{
        private Comparable data;  //排序的依据就是Comparable
        private Node right;     //保存左节点
        private Node left;       //保存右节点

        public Node(Comparable data){
            this.data = data;
        }

        public Comparable getData() {
            return data;
        }

        //在Node中添加元素
        public void addNode(Node newNode){  //实现根节点不为空的时候,Node的添加功能
            if (this.data.compareTo(newNode.data)> 0){   //Todo:全篇重点就在compareTo方法，有了这个方法才能去比较Node的大小从而决定位置
                if (this.left == null){
                    this.left = newNode;
                }else {
                 this.left.addNode(newNode);
                }
            }else {
                if (this.right == null){
                    this.right = newNode;
                }else {
                    this.right.addNode(newNode);
                }
            }
        }

        /*
            tree.add( new Book("C#开发",11.11));
            tree.add( new Book("APS开发",13.11));
            tree.add( new Book("Python开发",12.11));
            tree.add( new Book("Android开发",10.11));
         * 1. C#添加进入,会作为root保存。  Todo:结论：所以二叉树的根节点不不固定的(第一个添加的数据会作为根节点)。动态的分配的。
         * 2.APS添加进入,比较大小,大于C#，存入right
         */
        public void toArrayNode(){

            if (this.left!=null){  //表示有左节点
                this.left.toArrayNode();
            }

            Tree.this.retData[Tree.this.foot++] = this.data;   //Todo 此处之所以必须放在中间：

            if (this.right !=null){  //表示有右节点
                this.right.toArrayNode();  //右节点输出
            }
        }
    }
}

class Book implements Comparable<Book>{
    private String title;
    private double price;
    public Book(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书的名称：" + this.title + "\t书的价格：" + this.price + "\n";
    }

    @Override
    public int compareTo(Book o) {
        if (this.price < o.price){
            return 1;
        }else if (this.price > o.price){
            return -1;
        }else {
            return 0;
        }
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        Tree tree =  new Tree();
        Book b_java = new Book("Java",1.1);
        Book b_C = new Book("C   ",2.2);
        Book b_Python = new Book("Python",5.5);
        Book b_SQL = new Book("SQL",6.6);
        Book b_Ruby = new Book("Ruby",3.3);
        Book b_Oracle = new Book("Oracle",4.4);
        tree.add(b_java);
        tree.add(b_C);
        tree.add(b_Python);
        tree.add(b_SQL);
        tree.add(b_Ruby);
        tree.add(b_Oracle);
        System.out.println(tree.getCount());
        Object[] objects = tree.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(tree.getRoot().getData());
    }
}
