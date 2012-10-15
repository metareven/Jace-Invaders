package unitModels;

import java.awt.Image;

import controllers.PlayerController;
import unitViews.Unit;

public class Player implements Ship{
	
	public Unit sprite;
	public PlayerController controller;
	private int xPos;
	private int yPos;
	private int speed;
	private int lives;
	
	public Player(){
		System.out.println("creating a player");
		this.xPos = 1;
		this.yPos = 2;
		this.lives = 3;
		this.speed = 4;
		this.sprite = new unitViews.Player();
		
	}
	
	/**
	 * Causes the player to fire a bullet upwards
	 */
	public void fire() {
		//create a bullet and fire it 
		
	}
	
	/**
	 * Kills the player, reducing his life-count by one
	 */
	public void takeDamage() {
		//take damage
		lives = lives -1;
		
	}

	/**
	 * Moves the player "speed" pixles to the left
	 */
	public void moveLeft() {
		  xPos =  Math.max(0, xPos - speed);
		
	}
	
	/**
	 * Moves the player "speed" pixles to the right
	 */
	public void moveRight() {
		xPos = Math.max(1000, xPos + speed);
		
	}
	
	/**
	 * Returns the player's position on the x-axis
	 */
	public int getXpos() {
		// TODO Auto-generated method stub
		return xPos;
	}

	/**
	 * Returns the player's position on the y axis
	 */
	public int getYpos() {
		return yPos;
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return this.sprite.getSprite();
	}

	public void setXpos(int x) {
		// TODO Auto-generated method stub
		
	}

	public void setYpos(int y) {
		// TODO Auto-generated method stub
		
	}
	
	
}
