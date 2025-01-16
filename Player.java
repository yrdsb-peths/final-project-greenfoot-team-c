import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor {
    private int health = 50;
    private int attackCooldown = 0;
    private GreenfootImage[] runningImages;
    private GreenfootImage idleImage;
    private int animationIndex = 0;
    private int animationTimer = 0;
    private int attackAnimationTimer = 0; // 用于控制攻击动画帧率
    private int verticalSpeed = 0;
    private boolean isOnGround = false;
    private boolean isAttacking = false; // 判断是否正在攻击

    public Player() {
        // Initialize running animation
        runningImages = new GreenfootImage[3];
        for (int i = 0; i < 3; i++) {
            runningImages[i] = new GreenfootImage("跑步" + (i + 1) + ".png");
            runningImages[i].scale(runningImages[i].getWidth() * 2, runningImages[i].getHeight() * 2);
        }
        // Initialize idle image
        idleImage = new GreenfootImage("小人.png");
        idleImage.scale(idleImage.getWidth() * 2, idleImage.getHeight() * 2);
        setImage(idleImage); // Initial image is idle
    }

    public void act() {
        handleMovement();
        handleAttack();
        applyGravity();
        animateRunning();
    }

    private void handleMovement() {
        boolean moving = false; // To check if the player is moving

        // Check for movement keys
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 2, getY());
            moving = true;
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 2, getY());
            moving = true;
        }
        if (Greenfoot.isKeyDown("space") && isOnGround) {
            verticalSpeed = -12; // Jump speed
            isOnGround = false; // After jumping, not on the ground
        }

        // If not moving, show idle image
        if (!moving) {
            animationTimer = 0; // Reset animation timer
            setImage(idleImage); // Switch to idle image
        }
    }

    private void applyGravity() {
        if (!isOnGround) {
            verticalSpeed += 1; // Gravity effect
        } else {
            verticalSpeed = 0;
        }

        // Update position
        setLocation(getX(), getY() + verticalSpeed);

        // Check if touching the ground
        if (getY() >= getWorld().getHeight() - 50) { // 50 is the ground height
            setLocation(getX(), getWorld().getHeight() - 50);
            isOnGround = true;
        }
    }

    private void animateRunning() {
        // Only play running animation if moving
        if (animationTimer == 0 && (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d"))) {
            animationIndex = (animationIndex + 1) % runningImages.length;
            setImage(runningImages[animationIndex]);
        }
        animationTimer = (animationTimer + 1) % 12; // Change frame every 0.2 seconds
    }

    private void handleAttack() {
        if (Greenfoot.isKeyDown("j") && attackCooldown == 0) {
            isAttacking = true; // Start attack animation
            attackAnimationTimer = 0; // Reset attack animation timer
            attackCooldown = 60; // Attack cooldown time
        }

        if (isAttacking) {
            // 控制每0.1秒一帧
            if (attackAnimationTimer % 0.5 == 0) { // 6 frames = 0.1 seconds
                String attackAnimation = Greenfoot.getRandomNumber(2) == 0 
                    ? "攻击1.png" 
                    : "攻击7.png";
                GreenfootImage attackImage = new GreenfootImage(attackAnimation);
                attackImage.scale(attackImage.getWidth() * 2, attackImage.getHeight() * 2);
                setImage(attackImage);
            }

            attackAnimationTimer++; // Increment attack animation timer

            // 检查攻击是否触碰到怪物
            Monster1 monster = (Monster1) getOneIntersectingObject(Monster1.class);
            if (monster != null) {
                monster.takeDamage(5); // 怪物掉血
            }

            // After a certain time, end attack animation and return to idle
            if (attackAnimationTimer > 30) { // 30 frames (0.5 seconds) of attack animation
                isAttacking = false;
                setImage(idleImage); // Reset to idle image after attack
            }
        }

        if (attackCooldown > 0) {
            attackCooldown--;
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            ((MyWorld) getWorld()).gameOver(false);
        }
    }


    public int getHealth() {
        return health;
    }
}
