import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author mohongyuan
 * @datetime 2019/3/20 11:13 PM
 */
public class RuntimeConstantPoolOOM {
//    public static void main(String[] args) { //运行时常量池导致的内存溢出异常——无法实现
//        List<String> list = new ArrayList<String>();
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }
//    }
    public static void main(String[] args) { //String.intern()返回引用的测试
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("RuntimeCons").append("tantPoolOOM").toString();
        System.out.println(str2.intern() == str2);
    }
}
