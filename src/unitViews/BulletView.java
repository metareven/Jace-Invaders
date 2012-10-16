package unitViews;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BulletView implements Unit{

	private Image sprite;
	private int height;
	private int width;
	
	/**
	 * creates the view of a generic bullet
	 * @param name the name of the type of unit firing a bullet. Is either player or alien
	 */
	public BulletView(String name){
			
			//this.sprite = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/"+name+"missile.png"));
			try {
				this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/"+name+"missile.png").getPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Image getSprite() {
		return sprite;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
