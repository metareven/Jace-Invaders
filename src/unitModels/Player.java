package unitModels;

import java.awt.Image;

import main.JaceInvaders;

import controllers.PlayerController;
import unitViews.Unit;

public class Player implements Ship{
	
	public Unit sprite;
	public PlayerController controller;
	private int xPos;
	private int yPos;
	private int speed;
	private int lives;
	private int speedThreshold = 5;
	
	public Player(){
		this.sprite = new unitViews.Player();
		this.xPos = (JaceInvaders.Width - sprite.getWidth()) / 2;
		this.yPos = JaceInvaders.Height - sprite.getHeight() - 50;
		this.lives = 3;
		this.speed = 0;
		
	}
	
	/**
	 * Causes the player to fire a bullet upwards
	 */
	public void fire() {
		//create a bullet and fire it
		new BulletModel(xPos , yPos);
		
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
		speed = -speedThreshold;
		
	}
	
	/**
	 * Moves the player "speed" pixles to the right
	 */
	public void moveRight() {
		speed = speedThreshold;
		
	}
	
	/**
	 * Returns the player's position on the x-axis
	 */
	public int getXpos() {
		return xPos;
	}

	/**
	 * Returns the player's position on the y axis
	 */
	public int getYpos() {
		return yPos;
	}

	public Image getSprite() {
		return this.sprite.getSprite();
	}

	public void setXpos(int x) {
		this.xPos = x;
		
	}

	public void setYpos(int y) {
		this.yPos = y;
		
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void stop(){
		speed = 0;
	}
	
	public void update(){
		xPos = Math.max(0, xPos + speed);
	}
	
	
}
