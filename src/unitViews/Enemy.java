package unitViews;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * the view of an enemy
 * @author Metareven
 *
 */
public class Enemy implements Unit{

	private Image sprite;
	
	/**
	 * creates the view of an enemy and loads its sprite
	 */
	public Enemy(){
		
		try {
			//this.sprite = Toolkit.getDefaultToolkit().getImage("../images/alien1.png");
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/alien1.png").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Image getSprite() {
		return sprite;
	}

	public int getHeight() {
		return sprite.getHeight(null);
	}

	public int getWidth() {
		return sprite.getWidth(null);
	}
}
