package world;

import Entidades.Entity;
import MyNecraft.Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class World {

	public static Tile[] tiles;
	public static int WIDTH,HEIGHT;
	public static final int TILE_SIZE = 16;
	
	
	public World(){
            String Bioma[]={"grama", "areia", "neve",""};
		WIDTH = 200; // largura
		HEIGHT = 80; // profundidade
                int divisaoMapa= WIDTH/(Bioma.length-1);
		tiles = new Tile[WIDTH*HEIGHT];
		for(int xx = 0; xx < WIDTH; xx++) {
                    int alturaInicial= Entity.rand.nextInt(12-8)+8;
                    
			for(int yy = 0; yy < HEIGHT; yy++) {
				if(yy == HEIGHT - 2 || yy == HEIGHT - 1 || yy == HEIGHT) {
                                    
                                    
					tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_BADROCK);
                                        tiles[xx+yy*WIDTH].solido= true; // colocar bloco solido aq
                                        
				}else {
                                    
                                      int indexBioma= xx/divisaoMapa;
                                    if(yy> alturaInicial && yy<20){
                                      
                                       
                                         if (Bioma[indexBioma]=="grama"){
                                            tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_GRAMA);
                                        }else if (Bioma[indexBioma]=="areia"){
                                        tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_AREIA);
                                        }else if (Bioma[indexBioma]=="neve"){
                                          tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_NEVE);  
                                        }
                                      
                                    }else if (yy== alturaInicial){
                                        if (Bioma[indexBioma]=="areia"){
                                            tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_AREIA);
                                        }else if(Bioma[indexBioma]=="grama"){
                                        tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_GRAMA);
                                        }else if (Bioma[indexBioma]=="neve"){
                                          tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_NEVE);  
                                        }
                                        }else if (yy< alturaInicial){
					tiles[xx+yy*WIDTH] = new FloorTile(xx*16,yy*16,Tile.TILE_AR);
				}else{
                                             
                                             if (yy<70){
                                                 if(yy<30){
                                                     tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_PEDRA);
                                                 }else{
                                                     if(yy<60){
                                                         int chanceFerro=Entity.rand.nextInt(100);
                                                         if(chanceFerro>90){
                                               tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_FERRO); 
                                            }else{
                                                tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_PEDRA); 
                                            }  
                                                     }else{
                                                    int chanceOuro=Entity.rand.nextInt(100); 
                                                    if(chanceOuro>95){
                                               tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_OURO); 
                                            }else{
                                                tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_PEDRA); 
                                            }  
                                                 }
                                                 }
                                                 
                                              
                                             }else{
                                                 int chanceDiamante=Entity.rand.nextInt(100);
                                                 if(chanceDiamante>98){
                                               tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_DIAMANTE); 
                                            }else{
                                                tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_PEDRA); 
                                            }   
                                             }
                                         
                                           
                                        }
                               
                                if (yy == 0 || xx==0 || xx>=WIDTH-9){
                                    tiles[xx+yy*WIDTH] = new WallTile(xx*16,yy*16,Tile.TILE_AR);
                                        tiles[xx+yy*WIDTH].solido= true;
                                }
                                
			}
		}
	}
                }
	
	public static boolean isFree(int xnext,int ynext){
		
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
	}
	
	public static void restartGame(){
		//TODO: Aplicar m�todo para reiniciar o jogo corretamente.
		return;
	}
	
	public void render(Graphics g){
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
	
}
