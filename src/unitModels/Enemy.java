package unitModels;

import java.awt.Image;

import main.JaceInvaders;

import unitViews.Unit;

public class Enemy implements Ship {
	
	private int xPos;
	private int yPos;
	private static int speed = 2;
	private static int displacement = 0;
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
		// TODO Auto-generated method stub
		
	}

	public void takeDamage() {
		// TODO Auto-generated method stub
		
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
		
		
		if(xPos < 0 || xPos + sprite.getWidth() > JaceInvaders.Width){
			speed = speed * -1;
			displacement++;
			
		}
	}

	public boolean collision(SpaceObject a, SpaceObject b) {
		// TODO Auto-generated method stub
		return false;
	}


}
