package unitModels;


import java.util.ArrayList;

import unitViews.Unit;

public abstract class Ship extends SpaceObject {
	
	private static ArrayList<Ship> deadShips = new ArrayList<Ship>();
	
	public static ArrayList<Ship> getDeadShips(){
		return deadShips;
	}
	
	public abstract Unit getView();
	
	public abstract void fire();
	
	public abstract void moveLeft();
	
	public abstract void moveRight();
	
	public abstract int getSpeed();
	
	public abstract void stop();
	
	
	

}
