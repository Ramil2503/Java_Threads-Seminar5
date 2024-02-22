package task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private String name;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();
            running();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goToStart() throws InterruptedException {
        System.out.println(name + " going to start line");
        Thread.sleep(1000 + new Random().nextInt(100, 2000));
        System.out.println(name + " is on the start line");
        cdl.countDown();
    }

    private void running() throws InterruptedException {
        System.out.println(name + " started the race!");
        Thread.sleep(1000 + new Random().nextInt(2000));
        System.out.println(name + " finished!");
    }
}
