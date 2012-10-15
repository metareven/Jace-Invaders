package unitModels;

import java.awt.Image;

public interface Ship {
	
	public int getXpos();
	
	public int getYpos();
	
	public Image getSprite();
	
	public void fire();
	
	public void takeDamage();
	
	public void moveLeft();
	
	public void moveRight();
	
	public void setXpos(int x);
	
	public void setYpos(int y);
	
	public int getSpeed();
	
	public void update();
	
	public void stop();

}
