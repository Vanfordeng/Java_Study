package Reflection;

/**
 * Created by Doctor on 2016/11/9.
 * 测试工厂模式
 */
interface Fruit{
    public void eat();
}

class Apple implements  Fruit{
    @Override
    public void eat() {
        System.out.println("*********吃苹果***************");
    }
}
class Orange implements  Fruit{
    @Override
    public void eat() {
        System.out.println("*********吃橘子***************");
    }
}
class Factory{
    public static Fruit getInstance(String className){
//        if ("Apple".equals(className)){
//            return new Apple();
//        }else if ("Orange".equals(className)){
//            return new Orange();
//        }
//        return null;
        //------------------------------------------------------------------------------------------
        //利用反射修改工厂类,增加子类后。不用重复修改工厂类
        try {
            Class<?> cls_fruit = Class.forName(className);  //将类名称作为参数传递className得到Class<?>对象,再用Class<?>对象实例化
            Fruit fruit = (Fruit) cls_fruit.newInstance();
//            Fruit f = (Fruit) Class.forName(className).newInstance();
            return  fruit;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class TestFactory {
    public static void main(String[] args) {
        Fruit fruit = Factory.getInstance("Reflection.Apple");
        fruit.eat();
    }
}
