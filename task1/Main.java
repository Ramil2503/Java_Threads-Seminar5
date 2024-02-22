package task1;
public class Main {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA) {
                    System.out.println("Locked object A. Waiting Object B");
                    synchronized (objectB) {
                        System.out.println("Object B is locked");
                    }
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            synchronized (objectB) {
                System.out.println("Locked object B. Waiting Object A");
                synchronized (objectA) {
                    System.out.println("Object A is locked");
                }
            }
        });
        firstThread.start();
        secondThread.start();
    }
}
