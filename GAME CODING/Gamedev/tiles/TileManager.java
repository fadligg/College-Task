package Gamedev.tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Gamedev.main.GamePanel;

public class TileManager {
    
    GamePanel gp;
    public Tile [] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        
        this.gp = gp;
        
        tile = new Tile[35];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage ();
        loadMap("/Assets/Map/worldmap.txt");
    }
    public void getTileImage () {

        try {

            tile[0] = new Tile ();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/earth.png"));

            tile[1] = new Tile ();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/floor01.png"));
        
            tile[2] = new Tile ();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/grass00.png"));
            
            tile[3] = new Tile ();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/grass01.png"));
        
            tile[4] = new Tile ();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/hut.png"));
            tile[4].collision = true;

            tile[5] = new Tile ();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road00.png"));
            
            tile[6] = new Tile ();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road01.png"));
            
            tile[7] = new Tile ();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road02.png"));
        
            tile[8] = new Tile ();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road03.png"));

            tile[9] = new Tile ();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road04.png"));

            tile[10] = new Tile ();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road05.png"));

            tile[11] = new Tile ();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road06.png"));

            tile[12] = new Tile ();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road07.png"));

            tile[13] = new Tile ();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road08.png"));

            tile[14] = new Tile ();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road09.png"));

            tile[15] = new Tile ();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road10.png"));

            tile[16] = new Tile ();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road11.png"));
           
            tile[17] = new Tile ();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/road12.png"));
           
            tile[18] = new Tile ();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/table01.png"));
            
            tile[19] = new Tile ();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/tree.png"));
            tile[19].collision = true;

            tile[20] = new Tile ();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/wall.png"));
            tile[20].collision = true;

            tile[21] = new Tile ();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water00.png"));
            tile[21].collision = true;
            
            tile[22] = new Tile ();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water01.png"));
            tile[22].collision = true;

            tile[23] = new Tile ();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water02.png"));
            tile[23].collision = true;

            tile[24] = new Tile ();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water03.png"));
            tile[24].collision = true;

            tile[25] = new Tile ();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water04.png"));
            tile[25].collision = true;

            tile[26] = new Tile ();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water05.png"));
            tile[26].collision = true;

            tile[27] = new Tile ();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water06.png"));
            tile[27].collision = true;

            tile[28] = new Tile ();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water07.png"));
            tile[28].collision = true;

            tile[29] = new Tile ();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water08.png"));
            tile[29].collision = true;

            tile[30] = new Tile ();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water09.png"));
            tile[30].collision = true;

            tile[31] = new Tile ();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water10.png"));
            tile[31].collision = true;

            tile[32] = new Tile ();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water11.png"));
            tile[32].collision = true;

            tile[33] = new Tile ();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water12.png"));
            tile[33].collision = true;

            tile[34] = new Tile ();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/Used/water13.png"));
            tile[34].collision = true;
        }catch (IOException e) {
            e.printStackTrace();
        }     
    }
    
    public void loadMap(String filepath){
        try {
        InputStream mapLoader = getClass().getResourceAsStream(filepath);
        BufferedReader mapReader = new BufferedReader(new InputStreamReader(mapLoader));

        int col = 0;
        int row = 0;

        while(col < gp.maxWorldCol && row < gp.maxWorldRow){

            String line = mapReader.readLine();

            while (col < gp.maxWorldCol){
                
                String number [] = line.split(" ");

                int num = Integer.parseInt(number [col]);
                mapTileNum [col][row] = num;
                col++;
            }
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
        mapReader.close();
        }catch (Exception e){

        }

    }
    public void draw(Graphics2D g2){
        
        int worldCol = 0;
        int worldRow = 0;
        //int x = 0;
        //int y = 0;
        
        //camera mechanism
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){ 
            
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                 worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                 worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                 worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                    
                 g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            worldCol ++;
            
            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }

    }
}
