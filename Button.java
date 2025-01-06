import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private Runnable action;
    private String text;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    

    public Button(Runnable action, String text) {
        this.action = action;
        this.text = text;
        // GreenfootImage image = new GreenfootImage(text, 24, Color.BLACK, Color.WHITE);
        // setImage(image);
    }
    
    public Button() {
        GreenfootImage image = getImage();

        image.scale(30, 30);
    }
    
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
            
    }
}
