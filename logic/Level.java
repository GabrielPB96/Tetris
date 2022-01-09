package logic;
import java.util.ArrayList;


/**
 * Write a description of class Level here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level {
    public static ArrayList<Level> niveles;
    static{
        niveles   = new ArrayList<Level>();
        Level n1  = new Level(1,  3000,  600, 4);
        Level n2  = new Level(2,  5000,  550, 4);
        Level n3  = new Level(3,  7000,  500, 4);
        Level n4  = new Level(4,  9000,  450, 3);
        Level n5  = new Level(5,  11000, 400, 3);
        Level n6  = new Level(6,  13000, 350, 3);
        Level n7  = new Level(7,  15000, 300, 3);
        Level n8  = new Level(8,  17000, 250, 2);
        Level n9  = new Level(9,  19000, 200, 2);
        Level n10 = new Level(10, 21000, 150, 2);
        niveles.add(n1);
        niveles.add(n2);
        niveles.add(n3);
        niveles.add(n4);
        niveles.add(n5);
        niveles.add(n6);
        niveles.add(n7);
        niveles.add(n8);
        niveles.add(n9);
        niveles.add(n10);
    }
    
    private int level;
    private int score;
    private long delay;
    private int timeInitTope;
    
    private Level(int level, int score, long delay, int timeInitTope){
        this.level = level;
        this.score = score;
        this.delay = delay;
        this.timeInitTope = timeInitTope;
    }
    
    public int timeInitTope() {
        return timeInitTope;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getScore() {
        return score;
    }
    
    public long getDelay() {
        return delay;
    }
    
    public static Level getInstance(int index) {
        return niveles.get(index);
    }
}
