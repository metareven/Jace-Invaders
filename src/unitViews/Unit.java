package unitViews;

import java.awt.Image;
import java.awt.image.BufferedImage;
/**
 * generic view of a unit in JaceInvaders
 * @author Metareven
 *
 */
public interface Unit {
	
	/**
	 * 
	 * @return the sprite of this view, that is an image
	 */
	public Image getSprite();
	
	/**
	 * 
	 * @return the height of this view
	 */
	public int getHeight();
	
	/**
	 * 
	 * @return the width of this view
	 */
	public int getWidth();
	
	
}
