package swingRepository.javaapplication4;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FeedListener extends MouseAdapter {
    boolean hungry = false;
    long startTime;
    long endTime; 
    int limit;
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(!hungry){
            System.out.println("You overfeeded your pet. Game is over");
            System.exit(0);
        }
        endTime = System.currentTimeMillis() - startTime; 
        if(endTime<100){
             System.out.println("Mega fast");
        } else
        if(endTime<300){
             System.out.println("Super fast");
        } else
        if(endTime<700){
             System.out.println("Just fast");
        } else
        if(endTime<900){
             System.out.println("Faster man, I will die next time");
        }
        System.out.println("Fed in " + endTime);
        hungry = false;
    } 
    public FeedListener(){
        startGame();
    }
    public void startGame(){
        Thread t = new Thread(()->{
                try { 
                    hungry = false;
                    Random rand = new Random(); 
                    try {
                        Thread.sleep(rand.nextInt(5000));
                    } catch (InterruptedException ex) {
                    } 
                    startTime = System.currentTimeMillis();
                    hungry = true;
                    System.out.println("I am hungry ("+startTime+")");
                    Thread.sleep(1000);
                    if(hungry){
                        System.out.println("I starved to death. Good bye.");
                        System.exit(0);
                    }
                } catch (InterruptedException ex) { } 
                startGame();
            } 
        );
        t.start();
    }
}