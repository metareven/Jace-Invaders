package unitModels;

import java.awt.Image;
import java.util.ArrayList;

import main.JaceInvaders;

import unitViews.Unit;

public class Enemy extends Ship {
	
	private int xPos;
	private int yPos;
	public static int speed = 1;
	public static int displacement = 0;
	private int speedThreshold = 2;
	private Unit sprite;

	public Enemy(){
		this.sprite = new unitViews.Enemy();
		this.xPos = 0;
		this.yPos = 0;
	}
	
	public int getXpos() {
		return xPos;
	}
	

	public int getYpos() {
		return yPos + (sprite.getHeight() * displacement);
	}

	public Unit getView() {
		return this.sprite;
	}

	public void fire() {
		new EnemyBullet(this);
	}

	public void takeDamage() {
		getDeadShips().add(this);
	}

	public void moveLeft() {
		speed = -speedThreshold;
		
	}

	public void moveRight() {
		speed = speedThreshold;
		
	}

	public void setYpos(int y) {
		yPos = y;
	}


	public void setXpos(int x) {
		this.xPos = x;
		System.out.println(xPos);
		
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void stop(){
		speed = 0;
	}
	
	public void update(){
		xPos = xPos + speed;
		
		if (Math.random() > 0.999){
			
			fire();
		}
		
		if(xPos < 0 || xPos + sprite.getWidth() > JaceInvaders.Width){
			speed = speed * -1;
			displacement++;
			
		}
		
		if(getYpos() + getHeight() * 2 > JaceInvaders.Height){
			JaceInvaders.game.newLevel(JaceInvaders.game.level);
		}
	}

	public boolean collision(SpaceObject a, SpaceObject b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getWidth() {
		return sprite.getWidth();
	}

	@Override
	public int getHeight() {
		return sprite.getHeight();
	}

	@Override
	public void collisionReaction(SpaceObject x) {
		takeDamage();
	}


}
