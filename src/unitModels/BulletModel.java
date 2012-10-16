package unitModels;

import java.awt.Image;
import java.util.ArrayList;

import unitViews.BulletView;
import unitViews.Unit;

/**
 * Abstract class used as a base for creating bullets for the player and the aliens
 * @author Metareven
 *
 */
public abstract class BulletModel extends SpaceObject{

	//the speed of the bullet
	protected int speed;
	//the position of the bullet
	private int xPos;
	private int yPos;
	
	//the sprite representing the bullet on screen
	protected Unit sprite;
	
	//A list of all the bullets currently on screen
	private static ArrayList<BulletModel> bullets = new ArrayList<BulletModel>();
	
	//A list of bullets that are to be removed from screen on the next update
	private static ArrayList<BulletModel> deadBullets = new ArrayList<BulletModel>();
	
	//The ship owning this instance of a bullet. In other words, the one that fired the bullet
	private Ship owner;
	
	/**
	 * The constructor of a generic bullet. Also adds the created bullet instance to the list of
	 * all bullets on screen
	 * @param owner
	 */
	public BulletModel(Ship owner){
		this.owner = owner;
		this.xPos = owner.getXpos();
		this.yPos = owner.getYpos();
		bullets.add(this);
	}
	
	/**
	 * Updates the position of the bullet
	 */
	public void update(){
		if (yPos + sprite.getHeight() < 0){
			takeDamage();
		}
		yPos = yPos + speed;
	}
	
	/**
	 * Used to get the list of all bullets that are to be removed from
	 * screen on the next update
	 * @return an ArrayList containing all the bullets that are to be removed on the next update
	 */
	public static ArrayList<BulletModel> getDeadBullets(){
		return deadBullets;
	}
	
	/**
	 * Used to get the sprite representing a bullet
	 * @return This instance' sprite
	 */
	public Image getSprite(){
		return this.sprite.getSprite();
	}
	
	/**
	 * returns the position of this bullet on the x axis
	 */
	public int getXpos(){
		return xPos;
	}
	
	/**
	 * returns the position of this bullet on the y axis
	 */
	public int getYpos(){
		return yPos;
	}
	
	/**
	 * used to get the list of all the bullets that are currently on screen
	 * @return
	 */
	public static ArrayList<BulletModel> getBullets(){
		return bullets;
	}

	@Override
	public void takeDamage() {
		deadBullets.add(this);
		
	}

	@Override
	public void setXpos(int x) {
		this.xPos = x;
	}

	@Override
	public void setYpos(int y) {
		this.yPos = y;
		
	}

	@Override
	public int getWidth() {
		return sprite.getSprite().getWidth(null);
	}

	@Override
	public int getHeight() {
		return sprite.getSprite().getHeight(null);
	}

	@Override
	public void collisionReaction(SpaceObject x){
		takeDamage();
	}
	
	@Override
	public boolean collision(SpaceObject a) {
		if (a.getClass() != owner.getClass()){
			return super.collision(a);
		}
		return false;
	}
	
	
}
