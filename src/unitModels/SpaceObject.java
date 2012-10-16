package unitModels;

public interface SpaceObject {
	
	public int getXpos();
	
	public int getYpos();
	
	public void takeDamage();
	
	public void setXpos(int x);
	
	public void setYpos(int y);
	
	public void update();
	
	public boolean collision(SpaceObject a, SpaceObject b);


}
