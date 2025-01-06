import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);

        
        addObject(new Button(this::start, "Start the game"), 300, 310);
    }
    
    public void start() {
        Greenfoot.setWorld(new gameWorld());
        
    }
}
