package unitModels;

import java.awt.Rectangle;

public abstract class SpaceObject {
	
	public abstract int getXpos();
	
	public abstract int getYpos();
	
	public abstract void takeDamage();
	
	public abstract void setXpos(int x);
	
	public abstract void setYpos(int y);
	
	public abstract void update();
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
	public abstract void collisionReaction(SpaceObject x);
	

	/**
	 * 
	 * @param a The object you are checking if you are colliding with
	 * @return a boolean representing whether or not you have collided with a
	 */
	public boolean collision(SpaceObject a){
		Rectangle rect1 = new Rectangle(getXpos(),getYpos(),getWidth(),getHeight());
		Rectangle rect2 = new Rectangle(a.getXpos(),a.getYpos(),a.getWidth(),a.getWidth());
		//System.out.println(getClass().toString() + rect1.x + " " + rect1.y + " " + rect1.width + " " + rect1.height);
		//System.out.println(a.getClass().toString() + rect2.x + " " + rect2.y + " " + rect2.width + " " + rect2.height);
		return rect1.intersects(rect2);
	}


}
