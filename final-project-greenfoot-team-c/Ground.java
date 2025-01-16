import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ground extends Actor {
    public Ground() {
        setImage(new GreenfootImage(800, 50)); // 800x50 ground size
        getImage().setColor(Color.BLACK);
        getImage().fill(); // Fill the ground with black color
    }
}
