package task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static AtomicBoolean switcher = new AtomicBoolean(true);
    private static boolean work = true;

    public static void main(String[] args) {
        Thread changer = new Thread(() -> {
            while (work) {
                switcher.set(!switcher.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                System.out.println(switcher);
            }
        });

        Thread counter = new Thread(() -> {
            int count = 100;
            while (count > 0) {
                if (switcher.get() == true) {
                    System.out.println(count--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
            }
            work = false;
        });

        changer.start();
        counter.start();
    }
}
