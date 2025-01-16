import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthDisplay extends Actor {
    public HealthDisplay() {
        updateHealth(50);
    }

    public void updateHealth(int health) {
        setImage(new GreenfootImage("Health: " + health, 20, Color.WHITE, Color.BLACK));
    }
}
