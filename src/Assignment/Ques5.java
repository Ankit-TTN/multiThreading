package Assignment;

import java.util.Scanner;

class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer Thread Running");
            wait();
            System.out.println("Resumed Producer");
        }
    }

    public void consume() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for Return Key");
            in.nextLine();
            System.out.println("Return Key Pressed");
            notify();
            Thread.sleep(5000);
        }
    }
}

public class Ques5 {
    public static void main(String[] args){
        Processor proc = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
    }
}
