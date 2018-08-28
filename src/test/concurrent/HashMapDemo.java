package test.concurrent;
import java.util.HashMap;

public class HashMapDemo {
    public static HashMap hashMap = new HashMap();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    hashMap.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
                    System.out.println("ThreadA" + (i + 1));
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    hashMap.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
                    System.out.println("ThreadB" + (i + 1));
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}