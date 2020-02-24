package Assignment;

import java.util.Random;
import java.util.concurrent.*;

public class Ques7 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future =  executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                Random rand = new Random();
                System.out.println("Process Started");
                Thread.sleep(1000);
                System.out.println("Process Ends");
                return rand.nextInt(100);
            }
        });

        executor.shutdown();

        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Count :" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
