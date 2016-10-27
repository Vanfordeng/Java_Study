package design_mode;

/**
 * Created by Doctor on 2016/10/24.
 * 多例设计模式：比如男，女.  一周有7天等到。一个类只需要几个实例
 */
class Sex{
    private String gender;

    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex("女");

    private Sex(String gender){
        this.gender = gender;
    } //构造函数私有化
    public static Sex getInstance(int ch){
        //在JDK1.7之前，switch只能够利用int或char进行判断,但是正因为如果纯粹是int或char.对匹配项的意义表述不是特别明确
        //所以在JDK1.7之后支持String作为switch参数进行判断
        switch (ch){
            case 1:
                return MALE;
//            break;  有了return 就不需要 break了
            case 2:
                return FEMALE;
            default:
                return null;
        }
    }

    public String toString(){
        return "性别: " + this.gender;
    }
}

//用于解决在JDK1.7之前无法直观有意义的表述switch判断条件的时候,这种纯做属性的接口很少出现
//而且代码阅读不如自己使用String直观。这也是加上String判断的一种优势
interface Choose{
    int MAN = 1;
    int WOMAN =2;
}

public class Multiton_Mode {
    public static void main(String[] args){
        Sex sMan = Sex.getInstance(Choose.MAN);
        Sex sWoman = Sex.getInstance(Choose.WOMAN);
        System.out.println(sMan);
        System.out.println(sWoman);
    }
}
