package logic;
import visual.JLabelChronometer;


/**
 * Write a description of class Cronometer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chronometer {
    private int minutes;
    private int seconds;
    private int milliseconds;
    private int hours;
    
    private Hilo hilo;
    private JLabelChronometer label;
    
    private boolean running;
    
    public Chronometer() {
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
        hours = 0;
        this.label = null;
        running = false;
    }
    
    public void setLabel(JLabelChronometer  label) {
        this.label = label;
    }
    
    public void start() {
        init();
    }
    
    private void init() {
        hilo = new Hilo(){
            public void run() {
                while(!hilo.end) {
                    if(!hilo.suspend) {
                        milliseconds++;
                        controlTime();
                    }
                    actualizarLabel();
                    try{
                        synchronized(hilo) {
                            while(hilo.suspend) {
                                hilo.wait();
                            }
                        }
                        Thread.sleep(1);
                    }catch(Exception e) {}
                }        
            }
        };
        hilo.start();
    }
    
    private void controlTime() {
        if(milliseconds == 1000){
            milliseconds = 0;
            seconds++;
        }
        if(seconds == 60) {
            minutes++;
            seconds = 0;
        }
        if(minutes == 60) {
            minutes = 0;
            hours++;
        }        
    }
    
    private void actualizarLabel() {
        if(label != null) {
            label.setInfo();
            label.run();
        }
    }
    
    public void pause() {
        running = false;
        hilo.newSuspend();
    }
    
    public void resume() {
        running = true;
        hilo.newResume();
    }
    
    public void stop() {
        hilo.newStop();
        running = false;
        minutes = seconds = milliseconds = 0;
    }
    
    public void restart() {
        minutes = seconds = milliseconds = 0;
    }
    
    public int getMinutes() {return minutes;}
    
    public int getSeconds() {return seconds;}
    
    public int getMilliseconds() {return milliseconds;}
    
    public int getHours() {return hours;}
    
    public boolean running(){
        return running;
    }
}
