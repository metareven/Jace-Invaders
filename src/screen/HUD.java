package screen;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.JaceInvaders;

public class HUD {
	
	private BufferedImage sprite;
	private int spacing = 10;
	
	public HUD() {
		try {
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/player.png").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawHUD(Graphics g){
		for(int i = 0; i < JaceInvaders.player.getLives(); i++)
		g.drawImage(sprite,i * (sprite.getWidth() + spacing) , 0, null);
	}

}
