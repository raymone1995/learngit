/**
 * VM Args: -Xss128k
 * @author mohongyuan
 * @date 2019/3/20 9:11 PM
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        int temp = 1111;
        String str = "hello";
        double d = 11.01;
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
