
package MyNecraft;

import java.awt.Color;
import java.awt.Graphics;
import world.Camera;
import world.FloorTile;
import world.Tile;
import world.WallTile;
import world.World;
import static world.World.WIDTH;
import static world.World.tiles;

public class Inventario {
    public boolean colocarItem= false;
    public boolean pressionado;
    public int pontox, pontoy;
   
    public int selected=0;
    public static int tamanho=50;   
    public static String[] items = {"grama", "terra", "areia","pedra","neve", "ar","",""};
    public int posicaoInicial = (Game.WIDTH * Game.SCALE)/2 - (items.length*tamanho)/2;
    public void tick(){
        if(pressionado=true){
             pressionado=false;
             if(pontox>=posicaoInicial && pontox<posicaoInicial + (tamanho * items.length)){
                 if (pontoy>= Game.HEIGHT*Game.SCALE-tamanho-1 && pontoy<(Game.HEIGHT*Game.SCALE-tamanho-1) + tamanho){
                      selected= (int)(pontox-posicaoInicial)/tamanho;
                 }
                
                 
             }
             if (colocarItem){
                 colocarItem=false;
                 pontox= (int)pontox/3 + Camera.x;
                 pontoy= (int)pontoy/3 + Camera.y;
                 
                 int tilex = pontox/16;
                 int tiley = pontoy/16;
                 if (World.tiles[tilex+tiley*World.WIDTH].solido== false){
                     // aqui adicionamos 
                   if(items[selected] == "grama"){
                  
                       World.tiles[tilex+tiley*World.WIDTH] =  new WallTile(tilex*16,tiley*16,Tile.TILE_GRAMA);
                   }else if (items[selected] == "terra"){
                        World.tiles[tilex+tiley*World.WIDTH] =  new WallTile(tilex*16,tiley*16,Tile.TILE_TERRA);
                   }else if (items[selected] == "areia"){
                        World.tiles[tilex+tiley*World.WIDTH] =  new WallTile(tilex*16,tiley*16,Tile.TILE_AREIA);
                   }else if (items[selected] == "ar"){
                        World.tiles[tilex+tiley*World.WIDTH] =  new FloorTile(tilex*16,tiley*16,Tile.TILE_AR);
                   }else if (items[selected] == "pedra"){
                        World.tiles[tilex+tiley*World.WIDTH] =  new WallTile(tilex*16,tiley*16,Tile.TILE_PEDRA);
                   }else if (items[selected] == "neve"){
                        World.tiles[tilex+tiley*World.WIDTH] =  new WallTile(tilex*16,tiley*16,Tile.TILE_NEVE);
                   }
                   if(World.isFree(Game.player.getX(), Game.player.getY())==false){// onde esta o personagem
                        World.tiles[tilex+tiley*World.WIDTH] =  new FloorTile(tilex*16,tiley*16,Tile.TILE_AR);
                   }
                 }
             }
        }
       
        
    }
    public void render(Graphics g){
        for(int i=0; i<items.length; i++){
            g.setColor(Color.GRAY);
            g.fillRect(posicaoInicial+(i*tamanho)+1, Game.HEIGHT*Game.SCALE-tamanho-1, tamanho, tamanho);
            g.setColor(Color.black);
            g.drawRect(posicaoInicial+(i*tamanho)+1, Game.HEIGHT*Game.SCALE-tamanho-1, tamanho, tamanho);
            if (items[i]== "grama"){
                g.drawImage(Tile.TILE_GRAMA,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
            }
            if (items[i]== "terra"){
                g.drawImage(Tile.TILE_TERRA,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
            }
            if (items[i]== "areia"){
                g.drawImage(Tile.TILE_AREIA,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
            }
            if (items[i]== "ar"){
                g.drawImage(Tile.TILE_AR,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
            }
           if (items[i] == "pedra"){
                       g.drawImage(Tile.TILE_PEDRA,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
                   }
           if (items[i] == "neve"){
                        g.drawImage(Tile.TILE_NEVE,(posicaoInicial+(i*tamanho))+10, (Game.HEIGHT*Game.SCALE-tamanho+10), 32, 32, null);
                   }
            if(selected == i){
                g.setColor(Color.red);
                g.drawRect(posicaoInicial+(i*tamanho), Game.HEIGHT*Game.SCALE-tamanho-1, tamanho, tamanho);
            }
        }
    }
}
