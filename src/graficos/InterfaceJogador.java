
package graficos;

import MyNecraft.Game;
import MyNecraft.Inventario;
import World.Horario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class InterfaceJogador {
    public static boolean getCursor;
    public static int selecionadoX, selecionadoY;

    public InterfaceJogador() {

    }
  
 public void render(Graphics g){
     int barraVida= Game.player.vida;
     g.setColor(Color.red);
   g.fillRect((Game.WIDTH * Game.SCALE)/2 - (Inventario.items.length* Inventario.tamanho)/2, (Game.HEIGHT*Game.SCALE) - (Inventario.tamanho+30), 100, 20);
   g.setColor(Color.green);
   g.fillRect((Game.WIDTH * Game.SCALE)/2 - (Inventario.items.length* Inventario.tamanho)/2, (Game.HEIGHT*Game.SCALE) - (Inventario.tamanho+30), barraVida, 20 );  
   g.setColor(Color.white);
   g.setFont(new Font("Ink Free",Font.BOLD,20));
   g.drawString("100/"+String.valueOf(barraVida), (Game.WIDTH * Game.SCALE)/2 - (Inventario.items.length* Inventario.tamanho)/2 +15, (Game.HEIGHT*Game.SCALE) - (Inventario.tamanho+15));
   g.setColor(Color.GRAY);
   if(getCursor){
      
       g.drawRect(this.selecionadoX,this.selecionadoY, 48, 48);
   }
   

 }
}
