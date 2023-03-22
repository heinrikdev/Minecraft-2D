package graficos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import *Recursos;
import javax.imageio.ImageIO;

public class Spritesheet {

	private BufferedImage spritesheet;
	
	public Spritesheet(String path)
	{
		
            try {
                spritesheet = ImageIO.read(getClass().getResource("/graficos"+ path));
            } catch (IOException ex) {
                Logger.getLogger(Spritesheet.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	public BufferedImage getSprite(int x,int y,int width,int height){
		return spritesheet.getSubimage(x, y, width, height);
	}
}
