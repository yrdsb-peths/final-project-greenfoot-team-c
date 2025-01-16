import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MagicBall extends Actor {
    private Player target;

    public MagicBall(Player player) {
        this.target = player;
        setImage("魔法球.png");
    }

    public void act() {
        if (target != null) {
            turnTowards(target.getX(), target.getY());
            move(4);
            if (isTouching(Player.class)) {
                target.takeDamage(10);
                getWorld().removeObject(this);
            }
        }
    }
}

