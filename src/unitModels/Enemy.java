package unitModels;

import java.awt.Image;

public class Enemy implements Ship {
	
	private int xPos;
	private int yPos;
	private int speed;

	public int getXpos() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public int getYpos() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	public void fire() {
		// TODO Auto-generated method stub
		
	}

	public void takeDamage() {
		// TODO Auto-generated method stub
		
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	public void setYpos(int y) {
		// TODO Auto-generated method stub
		
	}


	public void setXpos(int x) {
		// TODO Auto-generated method stub
		
	}
	
	public int getSpeed(){
		return 0;
	}
	
	public void stop(){
		speed = 0;
	}
	
	public void update(){
		xPos = Math.max(0, xPos + speed);
	}

}
