package unitViews;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy implements Unit{

	private BufferedImage sprite;
	
	public Enemy(){
		
		try {
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/alien1.png").getPath()));
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
