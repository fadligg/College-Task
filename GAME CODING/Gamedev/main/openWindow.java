package Gamedev.main;
import javax.swing.JFrame;

public class openWindow {
    public static void main(String[] args){

        JFrame window = new JFrame(); //to create a window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Jack In The Woods");

        GamePanel gamePanel = new GamePanel();//linked to GamePanel.java
        window.add(gamePanel);//to add panel to the window

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
        gamePanel.playMusic(0);
        gamePanel.inGame();
    }

} 

