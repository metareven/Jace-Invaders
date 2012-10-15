package unitViews;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Enemy implements Unit{

	private BufferedImage sprite;
	
	public Enemy(){
		sprite = new BufferedImage(28, 28, BufferedImage.TYPE_INT_RGB);
		
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
