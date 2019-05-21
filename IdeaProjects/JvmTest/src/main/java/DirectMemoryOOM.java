import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M(这个参数不起作用)
 * @author mohongyuan
 * @datetime 2019/3/21 2:07 AM
 */
public class DirectMemoryOOM {
    private static final int _10MB = 1024 * 1024 * 10;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        int count = 1;
        while (true) {
            unsafe.allocateMemory(_10MB);
//            System.out.println(count++);
        }
    }
}
