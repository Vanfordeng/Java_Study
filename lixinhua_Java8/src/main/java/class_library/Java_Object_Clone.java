package class_library;

/**
 * Created by Doctor on 2016/11/2.
 * 对象Clone:指的就是对象的复制操作,在Object类里面提供有一个专门的克隆方法clone()
 * protected Object clone() throws CloneNotSupportedException
 * 之所以定义为protected权限,因为不是所有的类的对象都需要克隆，如果Object类里面定义为public感觉不是很好
 * 此方法抛出一个异常：“CloneNotSupportedException”  //if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also throw this exception to indicate that an instance cannot be cloned.
 * Cloneable的定义：Interface Cloneable 中并没有看见方法，此为//Todo 标识接口，表示一种操作能力。没有任何方法定义，只是一个空接口的声明
 *
 */
class Book implements Cloneable{ //此类的对象可以被克隆
    private String title;
    private double price;
    public Book(String title,double price){
        this.title =  title;
        this.price =  price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + "\t价格：" + this.price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  //调用父类的克隆方法
    }
}
public class Java_Object_Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new Book("Java",10.2);
       // book.clone();  //在Book类重写clone()方法之前，此处不能调用clone（）方法，因为clone()为protect访问权限,只能被同包或者不同包的子类访问。但是现在的位置是Java_Object_Clone类
        Book book1 = (Book) book.clone();  //clone为了兼顾所有的类型，返回值为Object类，所以需要向下转型为Book
        book.setTitle("C#");  //通过设置可以发现,clone的目的是产生一个一模一样的新的对象
        System.out.println(book);
        System.out.println(book1);

        //注释掉toString方法的执行结果：
//        class_library.Book@135fbaa4
//        class_library.Book@45ee12a7
        //覆盖toString方法的执行结果：
//        书名：C#	价格：10.2
//        书名：Java	价格：10.2

    }
}
