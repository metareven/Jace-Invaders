package unitViews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BulletView implements Unit{

	private BufferedImage sprite;
	private int height;
	private int width;
	
	public BulletView(){
		try {
			this.sprite  = ImageIO.read(new File(this.getClass().getResource("../images/playermissile.png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

}
