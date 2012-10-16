package unitViews;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * the view of a player
 * @author Metareven
 *
 */
public class Player implements Unit {
	
	private Image sprite;
	
	/**
	 * creates the view of a player and loads its image
	 */
	public Player(){
		
		try {
			//this.sprite = Toolkit.getDefaultToolkit().getImage("../images/player.png");
			//this.sprite = new ImageIcon(this.getClass().getResource("../images/player.png")).getImage();
			//this.sprite = Toolkit.getDefaultToolkit().getImage("../images/player.png");
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/player.png").getPath()));
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
