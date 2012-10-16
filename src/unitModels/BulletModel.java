package unitModels;

import java.awt.Image;
import java.util.ArrayList;

import unitViews.BulletView;
import unitViews.Unit;

public abstract class BulletModel extends SpaceObject{

	protected int speed;
	private int xPos;
	private int yPos;
	protected Unit sprite;
	private static ArrayList<BulletModel> bullets = new ArrayList<BulletModel>();
	private static ArrayList<BulletModel> deadBullets = new ArrayList<BulletModel>();
	private Ship owner;
	
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
	
	public static ArrayList<BulletModel> getDeadBullets(){
		return deadBullets;
	}
	
	public Image getSprite(){
		return this.sprite.getSprite();
	}
	
	public int getXpos(){
		return xPos;
	}
	
	public int getYpos(){
		return yPos;
	}
	
	public static ArrayList<BulletModel> getBullets(){
		return bullets;
	}

	@Override
	public void takeDamage() {
		deadBullets.add(this);
		
	}

	@Override
	public void setXpos(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYpos(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		return sprite.getSprite().getWidth();
	}

	@Override
	public int getHeight() {
		return sprite.getSprite().getHeight();
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
