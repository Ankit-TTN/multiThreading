package Assignment;

class SyncMethod {
    private int count = 0;
    public void increment(){ count++; }
    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10000; i++) {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count = " + count);
    }
}
class SyncBlock {
    private int count = 0;

    private  Object lock = new Object();
    public void increment(){
        synchronized (lock) {
            count++;
        }
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count = " + count);
    }
}

public class Ques3 {
    public static void main(String[] args) {
        SyncMethod obj = new SyncMethod();
        obj.doWork();
        SyncBlock obj2 = new SyncBlock();
        obj2.doWork();
    }

}
