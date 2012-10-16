package unitModels;

import java.awt.Rectangle;

public abstract class SpaceObject {
	
	/**
	 * fetches the position of the object on the x axis
	 * @return the x coordinate of the object
	 */
	public abstract int getXpos();
	
	/**
	 * fetches the position of the object on the y axis
	 * @return the y coordinate of the object
	 */
	public abstract int getYpos();
	
	/**
	 * Method that handles taking damage.
	 */
	public abstract void takeDamage();
	
	/**
	 * sets the x position of the object
	 * @param x the new x coordinate of the object
	 */
	public abstract void setXpos(int x);
	
	/**
	 * sets the y position of the object
	 * @param y the new y coordinate of the object
	 */
	public abstract void setYpos(int y);
	
	/**
	 * updates the objects coordinates and state
	 */
	public abstract void update();
	
	/**
	 * 
	 * @return the width of the object
	 */
	public abstract int getWidth();
	
	/**
	 * 
	 * @return the height of the object
	 */
	public abstract int getHeight();
	
	/**
	 * method that is to be called when colliding with an object
	 * @param x the object you have collided with
	 */
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
