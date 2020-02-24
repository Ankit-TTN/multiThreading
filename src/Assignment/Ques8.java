package Assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Connection{
    private static Connection instance = null;
    private static int totalConnection = 0;

    Semaphore sem = new Semaphore(2);

    private Connection(){ }

    public void connect() throws InterruptedException {
        sem.acquire();
        synchronized (this){
            totalConnection++;
            System.out.println("Total Connection : "+totalConnection);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            totalConnection--;
        }
        sem.release();
    }

    public static Connection getInstance(){
        if(instance==null){
            instance = new Connection();
        }
        return instance;
    }

}

public class Ques8 {
    public static void main(String[] args) {
        Connection c = Connection.getInstance();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executor.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        c.connect();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }
}
