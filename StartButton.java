import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor {
    public StartButton() {
        setImage("StartButton.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ((MyWorld) getWorld()).startGame();
        }
    }
}

