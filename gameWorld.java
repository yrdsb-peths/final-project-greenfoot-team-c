import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class FirstLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWorld extends World
{
    private int time;
    private Label timeLabel;
    private long lastTime;
    
    /**
     * Constructor for objects of class FirstLevel.
     * 
     */
    public gameWorld()
    {    
        super(1000, 600, 1);
        GreenfootImage bg = new GreenfootImage("Background.png");
        //GreenfootImage bg = new GreenfootImage("pixel.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        time = 60;
        
        timeLabel = new Label("Time: 60", 24);
        addObject(timeLabel, 80, 20);
        
        Robot robot = new Robot();        
        addObject(robot, 300, 200);
        
        lastTime = System.currentTimeMillis();
    }
    
    public void act() {
        long currentTime = System.currentTimeMillis();
        
        if(currentTime - lastTime >= 1000) {
            decrementTime(); 
            lastTime = currentTime;
        }
    }        
    
    public void decrementTime() {
        time--;
        timeLabel.setText("Time: " + time);
        if (time <= 0) {
            endGame();
        }
    }
    
    private void endGame() {
        //backgroundMusic.stop();
        //showText("Game Over!", getWidth() / 2, getHeight() / 2);
        
        GreenfootImage gameOverText = new GreenfootImage("Game Over!", 48, Color.RED, new Color(0, 0, 0, 0));
    
        getBackground().drawImage(gameOverText, getWidth() / 2 - gameOverText.getWidth() / 2, getHeight() / 2 - gameOverText.getHeight() / 2);
        
        Greenfoot.stop();
    }
    
}
