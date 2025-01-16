import greenfoot.*;  

public class Monster1 extends Actor {
    private int health = 5;
    private Player target;

    public Monster1(Player player) {
        this.target = player;
        setImage("怪物1.1.png");
    }

    public void act() {
        if (target != null) {
            turnTowards(target.getX(), target.getY());
            move(1); // 怪物朝玩家移动
        }

        // 检测是否碰到玩家
        if (isTouching(Player.class)) {
            Player player = (Player) getOneIntersectingObject(Player.class);
            if (player != null) {
                player.takeDamage(1); // 玩家掉血
            }
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            getWorld().removeObject(this); // 怪物死亡
        }
    }
}
