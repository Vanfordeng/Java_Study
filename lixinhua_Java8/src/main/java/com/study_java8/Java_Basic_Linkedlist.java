package com.study_java8;

/**
 * Created by Doctor on 2016/10/10.
 * 链表是一种最为简单的数据结构,它的主要目的是依靠引用关系来实现多个数据的保存
 */
//每一个链表实际上就是由多个节点所组成的
class Node{ //定义一个节点,用来做封装和设置数据之间的关系
    private String data; //要保存的数据
    private  Node next;  //要保存的下一个节点

    //每一个Node类对象都必须保存于相应的数据
    public Node(String data){  //必须有数据才有Node(人为规定)
        this.data =  data;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return  this.next;
    }
    //实现节点的添加
    //第一次调用：(Link):this = Link.root
    //第二次调用：(Node):this = Link.root.next
    //第三次调用：(Node):this = Link.root.next.next
    public void addNode(Node newNode){
        if (this.next == null){ //当前节点的下一个为null
            this.next = newNode; //保存新节点
        }else{ //当前节点下一个不为null
            //当前节点的下一个节点继续保存
            this.next.addNode(newNode);
        }
    }
    //第一次调用：(Link):this = Link.root
    //第二次调用：(Node):this = Link.root.next
    public void printNode(){ //输出数据
        System.out.println(this.data);
        if (this.next != null){ //现在还有下一个节点
            this.next.printNode(); //递归输出下一个节点的内容
        }
    }
    public String getData(){
        return  this.data;
    }
}
//是需要进行Node类对象的关系处理，让用户只关注于数据
class Link{ //负责数据的设置和输出
    //创建链表只关心root,后续的数据可以根据root获取到
    private Node root ; //根节点  根节点也是一个Node
    public void add(String data){ //增加数据
        //  Link link =  new Link();   创建链表的时候,root为null
        // 为了可以设置数据的先后关系，所以将我们的data包装在一个Node类对象里,只有Node才能设置数据之间的关系匹配(赋值除了使用方法去用“=”设置，还可以使用引用传递）
        Node newNode =  new Node(data);
        //保存当前数据的时候，现在还没有根节点
        if (this.root == null){
            //将新节点设置为root节点，这个代码只执行一次,root是会在开始的时候为null。并且一个链表只能有一个根节点
            this.root = newNode;  //使用引用传递改变root的指向（root本来的引用指向为null）
        }else {  //根节点已经存在了，后续必须递归的去判断root后面的节点是否为null
           // while (root.getNext()!=null){ //可以持续判断后续节点是否为空，但是并不能获取到当前为null的节点的位置也就无法设置
                //随后后面增加的元素应该交由节点来决定
             //   this.root.setNext(newNode);
            //}
            //this.root.setNext(newNode); //此段代码会重复判断root节点不为null的下一个节点设置为newNode
            //从root节点之后找到合适的位置
            this.root.addNode(newNode);
        }
    }
    public void print(){ //输出数据
        if (this.root !=null){  //现在存在根节点（root节点）
            this.root.printNode();  //交给Node类输出
        }
    }
}
public class Java_Basic_LinkedList {
    public static void main(String[] args){
        //第一步：准备出所有的数据
        Node root =  new  Node("火车头");
        Node n1 =  new  Node("车厢A");
        Node n2 =  new  Node("车厢B");
        Node n3 =  new  Node("车厢C");
        Node n4 =  new  Node("车厢D");
        //设置引用关系
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        //第二步：取出所有数据
        Node currentNode =  root; //当前从根节点开始读取
        while (currentNode != null){  //当前节点存在有数据
            System.out.println(currentNode.getData());
            currentNode =  currentNode.getNext();  //引用传递
        }

//        print(root);

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        //Link相当于火车,Node类相当于车厢
        Link link =  new Link();  //由这个类负责存放和取出数据
        link.add("Hello");  //向链表中存放数据
        link.add("World");
        link.add("MLDN");
        link.add("WWW");
        link.add("WWW1");
        link.add("WWW2");
        link.add("WWW3");
        link.print(); //展示数据
    }
    public static void print(Node current){
        if (current == null){
            return;
        }
        System.out.println(current.getData());
        print(current.getNext());   //递归调用
    }
}
