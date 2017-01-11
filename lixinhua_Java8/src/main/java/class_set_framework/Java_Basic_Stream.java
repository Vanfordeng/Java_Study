package class_set_framework;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Doctor on 2016/12/14.
 * Stream 进行数据处理的讲解：
 * 1.离不开Lambda表达式
 * 2.方法引用，四个函数式接口
 * 3.如何使用Stream数据流进行集合的辅助操作，MapReduce的使用过程。
 */
public class Java_Basic_Stream {
    public static void main(String[] args) {
        /**@在JDK1.8开始发现整个类集里面说提供的接口都出现了大量的default或者是static方法，以Collection的父接口Iterable接口来里面定义的一个方法来观察：
         * default void forEach(Consumer<? super T> action)
         *     //Consumer<String> consumer = new MyDemo() :: print;   //参考Java_NewFeather8_Builtin_function_interface。其中Consumer<String> consumer;的实例化对象为：new MyDemo::print.所以forEach()方法接收的数据类型为：
         *     //Consumer<? super T> action,action的实例化可以设置为：System.out::println（此处正好是消费型Consumer，是一个消费型的操作，的方法的引用）
         *     consumer.accept("Hello World!");
         */
        //Todo 利用forEach()方法输出
        List<String> list = new ArrayList<String>();
        list.add("AA");
        list.add("BB");
        list.add("Ca");
        list.add("DD");
        list.add("DD");
        list.add("Da");
        list.add("DC");
        list.add("AADA");
        //System.out.println(String str);  //消费型接口模式：接收一个参数,无返回值
//        list.forEach(System.out :: println);  //System.out::println（此处正好是消费型Consumer，是一个消费型的操作，的方法的引用）
        //这个输出A B C D，效果相当于Iterator实例化输出后,循环取得每个对象内容输出的形式。
        //但是多数情况下还是使用Iterator,而不会采用 以上的方式完成,因为forEach()只能够实现输出，但是很多时候我们在进行集合数据输出的同时
        //还需要对集合数据做一些其它的处理。也就是说Iterator输出使我们主要使用的方式。
        /**@除了使用Iterator迭代取出数据并且处理之外,在JDK1.8里面又提供了一个专门可以进行数据处理的类：Stream
         * 这个类的对象可以利用Collection接口提供的方法操作：
         * default Stream<E> stream()。  //default和static方法的作用是为了增强接口的功能
         * java.util.stream  //是一个工具类
         * Since:JDK 1.8
         */
        ////取得Stream能干什么呢？
        System.out.println("--------Stream-------------");
        Stream<String> stream = list.stream();  //取得stream类的对象
//        System.out.println("Stream取得数据个数：" + stream.count());//取得数据个数，Stream和Collection没有直接联系。主要是讲Collection中的数据交给Stream类处理
        //Todo 既然取得Stream类的对象那么下面进行数据的加工处理。
        System.out.println("------取消掉重复数据（List中没有此方法）-----");
        //Stream类里面提供有一个消除重复的方法：public Stream<T> distinct()。
//        System.out.println("Stream取消重复数据:" + stream.distinct().count());
        list.forEach(System.out :: println);   //打印原始list，重复元素仍然存在。
        //收集器（最后使用收集器): public <R,A> R collect(Collector<? super T,A,R> collector)
            //Returns a Collector that accumulates the input elements into a new List.
            //|——：需要Collectors类提供的：public static <T> Collector<T,?,List<T>> toList()
        System.out.println("------取消掉重复数据,并存放到新List中（List中没有此方法）-----");
    //    List<String> newList = stream.distinct().collect(Collectors.toList()); //去除掉所有重复元素后形成新的集合数据,里面是不包含重复内容的集合
   //     newList.forEach(System.out::println);
        //既然Stream类时进行数据处理的,那么在数据处理之中就不可能不去思考数据的筛选问题(过滤)。Stream类里面支持有数据的过滤操作：
        //public Stream<T> filter(Predicate<? super T> predicate)
        System.out.println("------对集合中的数据进行筛选（List中没有此方法）-----");
//        List<String> newList = stream.distinct().filter((x)-> x.contains("A")).collect(Collectors.toList());  //(x)-> x.contains("a") lambda表达式
        //使用了数据的过滤操作,使用了断言型函数式接口，使用了String类中的contains()方法。
//        List<String> newList = stream.distinct().filter((x) -> x.contains("A")).collect(Collectors.toList());  //(x)-> x.contains("a") lambda表达式  对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象，这种接口被称为函数式接口。
//        newList.forEach(System.out::println);
        //整个现在的数据操作已经成功的实现了过滤应用，但是有一个缺点，这个时候的过滤是区分大小写的。那么在对数据过滤之前需要对数据进行一些额外的处理，例如：
        //统一转大写或者转小写。在Stream里面提供有专门的数据处理方法：Todo public <R> Stream<R> map(Function<? super T,? extends R> mapper)
        //Todo 数据处理后过滤(整个Stream里面就两个最为核心的方法：一个叫map，一个叫reduce.合称mapReduce)
        //Todo map的作用是针对数据逐行数据进行处理（将集合中的每条数据分别进行处理）
        System.out.println("------对集合中的数据进行处理后进行筛选（List中没有此方法）-----");
//        List<String> newList = stream.distinct().map((x)-> x.toLowerCase()).filter((x) -> x.contains("a")).collect(Collectors.toList());  //(x)-> x.contains("a") lambda表达式  对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象，这种接口被称为函数式接口。
//        newList.forEach(System.out::println);
        //一行代码解决了使用Iterator来遍历的复杂操作。但是付出的代价是：大量的使用了函数式编程和lambda表达式对于Java开发者并不习惯
        //Todo MapReduce是大数据的核心所在。
        //在Stream接口里面提供有进行集合数据分页的操作：
        //|——：设置跳过的数据行数：public Stream<T> skip(long n)
        //|——：设置取出的数据个数：public Stream<T> limit(long maxSize)
//        List<String> newList = stream.distinct().map((x)-> x.toLowerCase()).skip(2).limit(2).collect(Collectors.toList());  //(x)-> x.contains("a") lambda表达式  对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象，这种接口被称为函数式接口。
//        newList.forEach(System.out::println);
        //在Stream 接口里面还可以进行数据的全匹配和部分匹配：
        //|——：全匹配：boolean allMatch(Predicate<? super T> predicate)
        //|——：匹配任意一个：boolean anyMatch(Predicate<? super T> predicate)
        System.out.println("-------实现数据的匹配查询---------");
//        if (stream.anyMatch((x)->x.contains("AA"))){
//            System.out.println("数据存在！");
//        }
        //在实际之中有可能会出现多个匹配的条件，在断言型的函数式接口里面提供有如下方法：
        //或操作：default Predicate<T> or(Predicate<? super T> other)
        //与操作：default Predicate<T> and(Predicate<? super T> other)
        //Todo 设置多个断言型函数式接口条件
        Predicate<String> p1 = (x)->x.contains("AA");
        Predicate<String> p2 = (x)->x.contains("DA");
//        if (stream.anyMatch(p1.or(p2))){  //同时使用两个条件
//            System.out.println("数据存在！1");
//        }
        //Todo lambda表达式是一个表达式而且要依赖与泛型
        if (stream.anyMatch(p1.and(p2))){  //同时使用两个条件,and是指两个条件在一条集合数据中同时满足
            System.out.println("数据存在！2");
        }
        //利用这样的匹配条件,可以针对数据进行方便的数据 Todo 查询操作。(整个的这些操作都不足于表明Stream的优势)
        //如果要想更好的发挥出Stream的操作优势，必须结合MapReduce一起观察。（Todo Map的主要目的就是将集合中的每条数据分别进行处理）
        //|--:数据分析方法：public Optional<T> reduce(BinaryOperator<T> accumulator)
        //|——：reduce 就是做数据统计使用。
        //Todo 实现MapReduce
        //进行数据的保存和初步的处理
        List<ShopCar> all = new ArrayList<ShopCar>();
        all.add(new ShopCar("布娃娃",23.0,20));
        all.add(new ShopCar("音乐娃娃",43.0,10));
        all.add(new ShopCar("毛绒娃娃",60.0,5));
        all.add(new ShopCar("汽车玩具",40.0,4));

        //Todo public interface Stream<T> extends BaseStream<T,Stream<T>>  ,T代表Type，此处为：ShopCar,对应Map中的 T :Function<? super T, ? extends R> mapper
        Stream<ShopCar> stream_car = all.stream();
        //Todo public <R> Stream<R> map(Function<? super T, ? extends R> mapper) 接收一个Function型的函数式接口
        //Todo 其中函数式接口的T代表Type,接收的参数类型，R代表Result,返回的参数类型,次数的返回值是泛型<R>，所以map可以返回任意数据类型
        //stream_car.map((x)->x.getAmount()*x.getPrice()).forEach(System.out::println);   //Stream接口里面也有forEach()方法
        //此时已经针对于每一个数据进行了处理。但是这个时候的处理没有总价。于是要对处理后的数据进行统计操作,就是用reduce()完成
        //Todo 统计处理数据
        // Todo |--:数据分析方法：public Optional<T> reduce(BinaryOperator<T> accumulator)
        // Todo |--:reduce 接收一个BinaryOperator<T>：
                        //        @FunctionalInterface //功能型接口
                            //        public interface BinaryOperator<T>
                                //          extends BiFunction<T,T,T>
        // Todo |--:BinaryOperator<T> 继承自BiFunction<T,T,T>
                        //        @FunctionalInterface  //功能型接口
                            //        public interface BiFunction<T,U,R>
        //Todo |--:BiFunction<T,U,R> 的主要方法如下：public R apply(T t,U u)，接收俩个泛型参数，返回R

        double sum_ShopCar = stream_car.map((x)->x.getAmount()*x.getPrice()).reduce((sum,m) -> sum + m).get();
        System.out.println("花费总金额为：" + sum_ShopCar);
        //以上只是实现了一个最简单的MapReduce，但是所完成的统计功能是过于有限了，如果想要实现更为完善的统计操作,
        //我们需要使用Stream接口里面的如下方法：
        //Todo 按照Double处理： public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
              //DoubleStream 定义，继承自BaseSteam： public interface DoubleStream extends BaseStream<Double,DoubleStream>
              //BaseStream 定义,是Stream接口的父接口： public interface BaseStream<T,S extends BaseStream<T,S>> extends AutoCloseable
        //Todo 按照Int处理： public IntStream mapToInt(ToIntFunction<? super T> mapper)
        //Todo 按照Long处理： public LongStream mapToLong(ToLongFunction<? super T> mapper)
        //Stream是BaseStream的子接口,而DoubleStream也是BaseStream的子接口）。
        //Todo 实现数据的统计操作：
        System.out.println("------实现的数据的统计操作---------");
        //Todo mapToDobule()方法返回值为DoubleStream,里面包含有如下的一个方法：
        //public DoubleSummaryStatistics summaryStatistics()
        DoubleSummaryStatistics dss = all.stream().mapToDouble((sc)->sc.getAmount()*sc.getPrice()).summaryStatistics();
        System.out.println("平均花费："+dss.getAverage());
        System.out.println("商品个数："+dss.getCount());
        System.out.println("最高花费：" + dss.getMax());
        System.out.println("最低花费" + dss.getMin());
        System.out.println("总花费" + dss.getSum());
        //这种操作实在是太麻烦了,但是它的确是简化了代码的编写。这也就是lambda表达式最好的操作体现，用最少的代码实现最复杂的功能。

        //Todo 以上的操作忘了吧,就像它从来未出现过一样
        /**
         * @MapReduce:Map处理数据,Reduce分析数据
         */
    }
}

//本类设计的时候，设计出了商品的单价和数量,这样如果要想取得某一个商品的花费就必须使用数量乘以单价
class ShopCar{
    private String pname; //商品名称
    private double price; //商品名称
    private int amount; //商品名称

    public ShopCar(String pname,double price,int amount){
        this.pname = pname;
        this.price = price;
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
