package screen;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.JaceInvaders;

/**
 * Class used to draw the number of the player's life. Can also be extended to draw a score by
 * drawing some additional text to some location in drawHUD()
 * @author Metareven
 *
 */
public class HUD {
	
	//the sprite used to indicate the number of remaining lives the player has
	private Image lifeSprite;
	
	//the spacing between the lifeSprites
	private int spacing = 10;
	
	/**
	 * The constructor of the HUD class. Calling this constructor returns a new HUD instance and loads the 
	 * sprite used to indicate the number of lives a player has left.
	 */
	public HUD() {
		try {
			//this.lifeSprite = Toolkit.getDefaultToolkit().getImage("../images/player.png");
			this.lifeSprite  = ImageIO.read(new File(this.getClass().getResource("../images/player.png").getPath()));
		} catch (Exception e) {
			System.err.println("kræsjet her HUD");
			e.printStackTrace();
		}
	}
	
	/**
	 * Draws the HUD
	 * @param g : The graphics the HUD is to be drawn on
	 */
	public void drawHUD(Graphics g){
		for(int i = 0; i < JaceInvaders.player.getLives(); i++)
		g.drawImage(lifeSprite,i * (lifeSprite.getWidth(null) + spacing) , JaceInvaders.player.getYpos() + spacing*3, null);
	}

}
