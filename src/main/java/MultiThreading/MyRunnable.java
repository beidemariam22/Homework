package MultiThreading;

public class MyRunnable implements Runnable{
    public MyRunnable(){

    }
    @Override
    public void run(){
        try{
            for(int i=0;i<=10;i++){
                System.out.println(i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
