/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import MyNecraft.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import world.Tile;

/**
 *
 * @author Marinalva
 */
public class Horario {
    private int dia=00, hora=6, minuto=00;
    private int horario=0;
    public boolean visualizar;

    public Horario() {
    }
    
    public String Hora(){
 String minutos="00";
         String horas="00";     
   if (horario/2==1){// aqui definimos 1 segundo na vida real = 1 min no jogo
     if (minuto==59){
       minuto=0;
       if(hora==23){
          hora=00; 
          dia++;
       }else{
           hora++;
       }
     }else{
         minuto++;
     }
       horario=0;
   }
   if (minuto<10){
       minutos="0"+minuto;
   }else{
      minutos= String.valueOf(minuto);
   }
   if (hora<10){
       horas="0"+hora;
   }else{
      horas= String.valueOf(hora);
   }
    return "Day "+dia +"    "+ "Hours "+ horas +":"+ minutos;
}
    public void tick (){
        horario++;
    }
    public void render(Graphics g){
        
              g.setColor(Color.BLACK);
        
            g.setFont(new Font("Ink Free",Font.BOLD,20));
            
            g.drawString(Hora(), Game.WIDTH-200,16);
            if (!this.visualizar){
               // for(int x=Game.WIDTH-200){
                   g.drawImage(Tile.TILE_AR, Game.WIDTH-200, 0,240,20, null);  
               // }
               
            }
            
       
    }
}
