package com.study_java8;

/**
 * Created by Doctor on 2016/10/9.
 * 一对多
 * 要求：
 * 可以通过一个类型找到它说对应的全部子类型
 * 可以通过一个类型找到它所对应的全部商品，以及每个商品对应的子类型
 * 可以通过一个子类型找到所有对应的全部商品
 */
class Item{  //父栏目
    private int iid;
    private String name;
    private String note;
    private SubItem[] subItems;
    private Product[] products;

    public Item(int iid,String name,String note){
        this.iid = iid;
        this.name = name;
        this.note = note;
    }
    public void  setSubItems(SubItem[] subItems){
        this.subItems = subItems;
    }
    public SubItem[] getSubItems(){
        return  this.subItems;
    }
    public void  setProducts(Product[] products){
        this.products = products;
    }
    public Product[] getProducts(){
        return  this.products;
    }
    public String getInfo(){
        return "栏目编号：" + this.iid + "\t栏目名称：" + this.name + "\t栏目描述：" + this.note;
    }
}
class SubItem{ //子栏目
    private int sid;
    private String name;
    private String note;
    private Item item;
    private Product[] products;
    public SubItem(int sid,String name,String note){
        this.sid = sid;
        this.name = name;
        this.note = note;
    }
    public void setItem(Item item){
        this.item = item;
    }
    public Item getItem(){
        return this.item;
    }
    public void  setProducts(Product[] products){
        this.products = products;
    }
    public Product[] getProducts(){
        return  this.products;
    }
    public String getInfo(){
        return "子栏目编号：" + this.sid + "\t子栏目名称：" + this.name + "\t子栏目描述：" + this.note;
    }
}
class Product{  //商品
    private int pid;
    private String name;
    private double price;
    private Item item;
    private SubItem subItem;
    public Product(int pid,String name,double price){
        this.pid = pid;
        this.name = name;
        this.price = price;
    }
    public void setItem(Item item){
        this.item = item;
    }
    public Item getItem(){
        return  this.item;
    }
    public void setSubItem(SubItem subItem){
        this.subItem = subItem;
    }
    public SubItem getSubItem(){
        return  this.subItem;
    }
    public String getInfo(){
        return  "商品编号：" + this.pid + "\t商品名称：" + this.name +  "\t商品价格：" + this.price;
    }
}
public class Java_Basic_Simple_Java_Class3 {
    public static void main(String[] args){
        //第一步：设置数据关系
        //1.准备出单独的类对象
        Item item =  new Item(1,"厨房用具","-");
        SubItem suba =  new SubItem(1001,"厨具","-");
        SubItem subb =  new SubItem(1002,"刀具","-");
        SubItem subc =  new SubItem(1003,"餐具","-");
        Product proa =  new Product(90001,"蒸锅",50);
        Product prob =  new Product(90001,"炒锅",50);
        Product proc =  new Product(90002,"菜刀",100);
        Product prod =  new Product(90003,"水果刀",6);
        Product proe=  new Product(90004,"青花瓷",500);
        Product prof =  new Product(90005,"水晶筷子",800);
        //2.设置对象间的引用关系
        suba.setItem(item);
        subb.setItem(item);
        subc.setItem(item);
        item.setSubItems(new SubItem[]{suba,subb,subc});
        proa.setSubItem(suba);
        prob.setSubItem(suba);
        proa.setItem(item);
        prob.setItem(item);
        proc.setSubItem(subb);
        prod.setSubItem(subb);
        proc.setItem(item);
        prod.setItem(item);
        proe.setSubItem(subc);
        prof.setSubItem(subc);
        proe.setItem(item);
        prof.setItem(item);
        suba.setProducts(new Product[]{proa,prob});
        subb.setProducts(new Product[]{proc,prod});
        subc.setProducts(new Product[]{prod,prof});
        item.setProducts(new Product[]{proa,prob,proc,prod,proe,prof});
        //第二步：取出数据
        // * 可以通过一个类型找到它说对应的全部子类型
        System.out.println(item.getInfo());
        for (int i = 0; i < item.getSubItems().length; i++) {
            System.out.println("\t | -" + item.getSubItems()[i].getInfo());
        }
        // * 可以通过一个类型找到它所对应的全部商品，以及每个商品对应的子类型
        System.out.println("-------------------------------------------------------------");
        System.out.println(item.getInfo());
        for (int i = 0; i < item.getProducts().length; i++) {
            System.out.println("\t | -" + item.getProducts()[i].getInfo());
            System.out.println("\t\t | -" + item.getProducts()[i].getSubItem().getInfo());
        }
        // * 可以通过一个子类型找到所有对应的全部商品
        System.out.println("-------------------------------------------------------------");
        System.out.println(subb.getInfo());
        for (int i = 0; i < subb.getProducts().length ; i++) {
            System.out.println("\t |- " + subb.getProducts()[i].getInfo());
        }
    }
}
