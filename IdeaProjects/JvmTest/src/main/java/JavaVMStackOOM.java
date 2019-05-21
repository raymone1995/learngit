import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xss100M 无法出现异常
 * @author mohongyuan
 * @datetime 2019/3/20 9:34 PM
 */
public class JavaVMStackOOM {
//    static class OOMObject {
//    }
    private void dontStop() {
//        List<OOMObject> list = new ArrayList<OOMObject>();
//
//        for(int i = 10000; i > 0; i--){
//            list.add(new OOMObject());
//        }
        while(true) {
        }
    }
    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
            System.out.println(thread.getId());
        }
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
