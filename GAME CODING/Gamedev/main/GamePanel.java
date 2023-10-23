package Gamedev.main;
import java.awt.*;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Graphics2D;

import javax.swing.JPanel;

import Gamedev.entity.Player;
import Gamedev.tiles.TileManager;

public class GamePanel extends JPanel implements Runnable {
    
    //screen
    final int charSize = 16; //16x16 pixel
    final int scale = 3;

    public final int tileSize = charSize * scale;
    public final int maxScreenRow = 12;
    public final int maxScreenColumn = 16;
    public final int screenHeight = tileSize * maxScreenRow;//576 pixel
    public final int screenWidth = tileSize * maxScreenColumn;//768 pixel

    //world
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //Frame per Second
    int FPS = 60;

    //System
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);   
    Sound sound = new Sound(); 
    public CollisionChecker collChecker = new CollisionChecker(this);
    Thread gameThread;

    //Entity, tile
    public Player player = new Player (this,keyH);
    public Object tile;

    //Game State (Pause, TitleScreen,etc.)
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel(){
        
        this.setPreferredSize(new Dimension (screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    public void inGame(){
        playMusic(0);
        gameState = playState;
    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double interval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        //long timer = 0;
        //int drawCount = 0;
        
        while (gameThread != null) {
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000) {
                System.out.println("FPS :" + drawCount);
                drawCount = 0;
                timer = 0;
            }
            
            
            
            //try {
                //double remainingTime = nextDraw - System.nanoTime();
                //remainingTime = remainingTime/1000000;
                //timer += remainingTime/interval;
                //if (remainingTime<0){
                    //remainingTime = 0;  
                   
                //}
                
                
                //Thread.sleep((long) remainingTime);
                //nextDraw += interval;
               //if (timer >=1000000000){
                //drawCount ++;
                // System.out.println("FPS :" + drawCount);
               //}
                
            //} catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            //}
        } 

    }
    public void update () {
        //player.update();
        if (gameState == playState){
            player.update();
        }
        if (gameState == pauseState){
           
        }
    }
    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        //g2.fillOval(400,200,tileSize,tileSize);
        //Graphics2D g3 = (Graphics2D) g;
       // g3.setColor(Color.RED);
        //g3.fillRect(300,400, 200, tileSize);
        g2.dispose();
        
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
   
    

    
    
}
