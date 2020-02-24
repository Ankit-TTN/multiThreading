package Assignment;

import java.util.Scanner;
class Volatile extends Thread{
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running){
            System.out.println("Hello");
            try{
                Thread.sleep((100));
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void shutDown(){
        running = false;
    }
}
public class Ques1 {
    public static void main(String[] args) {
        Volatile obj = new Volatile();
        obj.start();
        System.out.println("Press Enter To Stop");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        obj.shutDown();
    }
}
