package Gamedev.main;
import java.awt.*;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Graphics2D;

import javax.swing.JPanel;

import Gamedev.entity.Player;

public class GamePanel extends JPanel implements Runnable {
    
    final int charSize = 16; //16x16 pixel
    final int scale = 3;

    public final int tileSize = charSize * scale;
    final int maxScereenRow = 12;
    final int maxScreeenColumn = 16;
    final int screenHeight = tileSize * maxScereenRow;//576 pixel
    final int screenWidth = tileSize * maxScreeenColumn;//768 pixel

    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; 
    Player player = new Player (this,keyH);

    //player coordinates and speed
    int playerX = 200;
    int playerY = 200;
    int playerSpeed = 5;

    public GamePanel(){
        
        this.setPreferredSize(new Dimension (screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double interval = 1000000000/FPS;
        double nextDraw = System.nanoTime() + interval;
        //long timer = 0;
        //int drawCount = 0;
        
        while (gameThread != null) {
            
            //long currentTime = System.nanoTime();
            //System.out.println("Anjay jalan");
            update();

            repaint();
            
            
            try {
                double remainingTime = nextDraw - System.nanoTime();
                remainingTime = remainingTime/1000000;
                //timer += remainingTime/interval;
                if (remainingTime<0){
                    remainingTime = 0;  
                   
                }
                
                
                Thread.sleep((long) remainingTime);
                nextDraw += interval;
               //if (timer >=1000000000){
                //drawCount ++;
                // System.out.println("FPS :" + drawCount);
               //}
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        
        
    }
    public void update () {
       player.update();
    }
    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        //g2.fillOval(400,200,tileSize,tileSize);
        //Graphics2D g3 = (Graphics2D) g;
       // g3.setColor(Color.RED);
        //g3.fillRect(300,400, 200, tileSize);
        g2.dispose();
        
    }

   
    

    
    
}
