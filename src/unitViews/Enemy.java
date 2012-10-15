package unitViews;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Enemy implements Unit{

	private BufferedImage Sprite;
	
	public Enemy(){
		Sprite = new BufferedImage(28, 28, BufferedImage.TYPE_INT_RGB);
		
	}

	public BufferedImage getSprite() {
		return Sprite;
	}
}
