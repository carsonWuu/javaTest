package test.concurrent;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class HashtableNotModifyDemo {
    public static Hashtable hashtable = new Hashtable();
    static {
        for (int i = 0; i < 5; i++) {
            hashtable.put("String" + (i + 1), i + 1);
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Iterator iterator = hashtable.keySet().iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
//                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                hashtable.put("z", "zValue");
            }
        });

        threadA.start();
        threadB.start();
    }
}