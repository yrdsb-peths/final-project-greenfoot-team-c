import greenfoot.*;  

public class MyWorld extends World {
    private Player player;
    private int timer = 100; // 倒计时
    private int frameTimer = 0;
    private boolean gameOver = false;
    private boolean bossActive = false;
    private StartButton startButton;
    private boolean start = false;
    public MyWorld() {
        super(800, 600, 1);
        GreenfootImage background = new GreenfootImage("StartBackground.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);
        prepareStart();
    }

    private void prepareStart() {
        startButton = new StartButton();
        addObject(startButton, getWidth() / 2, getHeight() / 2);
        showText("You will never win this game, press a d to move and j to attack ", 400, 230);
        showText("Now it's time to press start button!",400, 250);
    }

    public void startGame() {
        removeObject(startButton); // 移除开始按钮
        showText("", 400, 230);
        showText("",400, 250);
        GreenfootImage background = new GreenfootImage("Background.png");
        background.scale(getWidth(), getHeight());
        setBackground(background);

        player = new Player();
        addObject(player, 100, getHeight() - 100);
        addObject(new TimerDisplay(), 70, 20); // 倒计时显示
        start= true;
    }

    public void act() {
        if (startButton != null && Greenfoot.mouseClicked(startButton)) {
            startGame();
        }
        if (!gameOver) {
            spawnMonsters(); // 每帧调用生成怪物的方法
            if (timer > 0) {
                updateTimer();
            }
        }

    }

    private void spawnMonsters() {
        // 3% 概率生成怪物
        if (Greenfoot.getRandomNumber(100) < 3) {
            // 创建 Monster1 实例
            Monster1 monster = new Monster1(player);
            // 将怪物添加到右侧随机高度的位置
            addObject(monster, getWidth(), Greenfoot.getRandomNumber(getHeight() - 100) + 50);
        }
    }


    private void updateTimer() {
        if(start = true){
            frameTimer++;
            if (frameTimer == 60) { // 每秒更新一次
                timer--;
                frameTimer = 0;
            
                showText("Time: " + timer, 70, 20); // 更新显示
            }
        }
    }
    
    public void gameOver(boolean win) {
        gameOver = true; // 停止游戏逻辑
        removeObjects(getObjects(Actor.class)); // 清除所有 Actor

        if (win) {
            setBackground("WinBackground.png");
            showText("Congratulations, You Won!", getWidth() / 2, getHeight() / 2);
        } else {
            setBackground("LoseBackground.png");
            showText("Game Over. You Died.", getWidth() / 2, getHeight() / 2);
        }

        Greenfoot.stop(); // 停止游戏
    }
}