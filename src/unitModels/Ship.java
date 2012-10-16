package unitModels;


import unitViews.Unit;

public interface Ship extends SpaceObject {
	
	
	public Unit getView();
	
	public void fire();
	
	public void moveLeft();
	
	public void moveRight();
	
	public int getSpeed();
	
	public void stop();

}
