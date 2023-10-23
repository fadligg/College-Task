package Gamedev.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    Graphics2D g2;
    GamePanel gp;
    public UI (GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        Font arial_40 = new Font("Arial", Font.PLAIN, 40);
        //Font arial_80B = new Font("Arial", Font.BOLD, 80);
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.playState){

        }
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
    }
    public void drawPauseScreen(){
        String text = "GAME IS PAUSED";
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }
}
