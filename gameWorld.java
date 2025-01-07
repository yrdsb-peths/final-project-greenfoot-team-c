import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWorld extends World
{

    /**
     * Constructor for objects of class FirstLevel.
     * 
     */
    public gameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //setBackground("Background.png");
        
        Robot robot = new Robot();        
        addObject(robot, 300, 200);
    }
}
