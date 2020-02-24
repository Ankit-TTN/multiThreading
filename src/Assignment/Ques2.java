package Assignment;

class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Hello Runnable " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Hello Thread " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Ques2 {
    public static void main(String[] args) {
        Runner obj = new Runner();
        Thread obj1 =  new Thread(new Runner1());
        obj.start();
        obj1.start();
    }

}
