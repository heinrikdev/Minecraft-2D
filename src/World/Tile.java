package world;

import MyNecraft.Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Tile {
        public static BufferedImage TILE_PEDRA = Game.spritesheet.getSprite(32,0,16,16);
	public static BufferedImage TILE_BADROCK = Game.spritesheet.getSprite(32,16,16,16);
	public static BufferedImage TILE_GRAMA = Game.spritesheet.getSprite(0,0,16,16);
	public static BufferedImage TILE_TERRA = Game.spritesheet.getSprite(16,0,16,16);
        public static BufferedImage TILE_AREIA = Game.spritesheet.getSprite(48,0,16,16);
        public static BufferedImage TILE_AR = Game.spritesheet.getSprite(0, 16, 16, 16);
        public static BufferedImage TILE_DIAMANTE = Game.spritesheet.getSprite(48, 16, 16, 16);
        public static BufferedImage TILE_OURO = Game.spritesheet.getSprite(64, 16, 16, 16);
        public static BufferedImage TILE_NEVE = Game.spritesheet.getSprite(64, 0, 16, 16);
        public static BufferedImage TILE_FERRO = Game.spritesheet.getSprite(80, 16, 16, 16);
	private BufferedImage sprite;
	private int x,y;
	
        public boolean solido = false;
	public Tile(int x,int y,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g){
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}

}
