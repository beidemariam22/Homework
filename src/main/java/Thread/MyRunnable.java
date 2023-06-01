package Thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MyRunnable implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(MyRunnable.class);

    public MyRunnable(){

    }
    @Override
    public void run(){
        try{
            for(int i=0;i<=5;i++){
                LOGGER.info(i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
