package unitModels;

import java.awt.Image;
import java.util.ArrayList;

import unitViews.BulletView;
import unitViews.Unit;

public class BulletModel{

	private int speed = -5;
	private int xPos;
	private int yPos;
	private Unit sprite;
	private static ArrayList<BulletModel> bullets = new ArrayList<BulletModel>();
	
	public BulletModel(Ship owner){
		sprite = new BulletView();
		
		this.xPos = owner.getXpos();
		this.yPos = owner.getYpos();
		bullets.add(this);
	}
	
	/**
	 * Updates the position of the bullet
	 */
	public void update(){
		if (yPos + sprite.getHeight() < 0){
			bullets.remove(this);
		}
		yPos = yPos + speed;
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
}
