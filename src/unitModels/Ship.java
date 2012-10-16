package unitModels;


import java.util.ArrayList;

import unitViews.Unit;

public abstract class Ship extends SpaceObject {
	
	private static ArrayList<Ship> deadShips = new ArrayList<Ship>();
	
	public static ArrayList<Ship> getDeadShips(){
		return deadShips;
	}
	
	/**
	 * 
	 * @return a view of the object
	 */
	public abstract Unit getView();
	
	/**
	 * causes the object to fire against its enemies
	 */
	public abstract void fire();
	
	/**
	 * causes the object to move to the left
	 */
	public abstract void moveLeft();
	
	/**
	 * causes the object to move to the right
	 */
	public abstract void moveRight();
	
	/**
	 * 
	 * @return the current speed of the object
	 */
	public abstract int getSpeed();
	
	/**
	 * causes the object to stop, that is setting its speed to 0
	 */
	public abstract void stop();
	
	
	

}
