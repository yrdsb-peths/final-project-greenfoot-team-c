import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Robot robot = new Robot();

        
        addObject(robot, 300, 200);
    }
}
