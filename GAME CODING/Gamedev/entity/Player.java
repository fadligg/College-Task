package Gamedev.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Gamedev.main.GamePanel;
import Gamedev.main.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    
    public Player (GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(12, 16, 32, 30);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues (){
        worldX = gp.tileSize * 25 ;
        worldY = gp.tileSize * 24;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage (){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_up_(1).1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_up_(2).1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_down_(1).1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_down_(2).1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_right_(1).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_right_(2).png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_left_(1).png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Player/Walk Sprites/boy_left_(2).png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update (){
        if(keyH.Upressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)  {

        if(keyH.Upressed == true){
            direction = "up";        
        }
        else if(keyH.downPressed == true){
            direction = "down";              
        }
        else if(keyH.rightPressed == true){
            direction = "right";             
        }
        else if(keyH.leftPressed == true){
            direction = "left";   
        }

        //check tile collision
        collisionOn = false;
        gp.collChecker.checkTile(this);

        if (collisionOn == false){
            switch (direction){
                case "up":
                worldY -= speed;
                    break;
                case "down":
                worldY += speed;
                    break;
                case "right":
                worldX += speed; 
                    break;
                case "left":
                worldX -= speed;
                    break;
                
            }
        }

        spriteCounter++;
        if(spriteCounter > 13) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }else if (spriteNum == 2){
                spriteNum = 1;                
            }
            spriteCounter = 0;
        }
        }
        if(keyH.Upressed == false && keyH.downPressed == false 
            && keyH.rightPressed == false && keyH.leftPressed == false){
                direction = "down";
                spriteCounter ++;
                if(spriteCounter > 13) {
                 if(spriteNum == 1) {
                spriteNum = 2;
                 }else if (spriteNum == 2){
                spriteNum = 1;                
                 }
                spriteCounter = 0;
                }
        }

    }
    public void draw (Graphics2D g2){
       //g2.setColor(Color.white);
       //g2.fillOval(x, y, gp.tileSize, gp.tileSize);
       BufferedImage image = null;

       switch (direction) {
        case "up":
            if(spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }           
            break;
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }
            break;
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
