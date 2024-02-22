package task3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);

        Thread t1 = new Thread(new Runner("Olivia", cdl));
        Thread t2 = new Thread(new Runner("Ethan", cdl));
        Thread t3 = new Thread(new Runner("Maya", cdl));

        t1.start();
        t2.start();
        t3.start();

        while (cdl.getCount() != 1) {
            Thread.sleep(100);
        }
        System.out.println("To the start!");
        Thread.sleep(500);
        System.out.println("Attention!");
        Thread.sleep(500);
        System.out.println("Start!");
        Thread.sleep(500);

        cdl.countDown();
    }
}
