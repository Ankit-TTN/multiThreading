package Assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Even implements Runnable{
    int number;

    Even(int number){
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 2; i < number; i+=2) {
            System.out.println("Even Thread" + i);
        }
    }
}

class Odd implements Runnable{
    int number;

    Odd(int number){
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 1; i < number; i+=2) {
            System.out.println("Odd Thread" + i);
        }
    }
}

public class Ques4 {

    public static void main(String[] args) {
        ExecutorService executor  = Executors.newFixedThreadPool(2);
        executor.submit(new Even(20));
        executor.submit(new Odd(20));

        executor.shutdown();
        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
