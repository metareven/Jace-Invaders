package unitViews;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements Unit {
	
	private BufferedImage sprite;
	
	
	public Player(){
		
		try {
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/player.png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}

	public int getHeight() {
	return sprite.getHeight();
	}

	public int getWidth() {
		return sprite.getWidth();
	}
	
}
