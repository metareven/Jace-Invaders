package unitModels;

import java.awt.Image;
import java.util.ArrayList;

import main.JaceInvaders;

import unitViews.Unit;

/**
 * Class used to represent the aliens attacking the player
 * @author Metareven
 *
 */
public class Enemy extends Ship {
	
	// the position of the alien on the x axis
	private int xPos;
	
	//the position of the alien on the y axis
	private int yPos;
	
	//the speed at which the alien moves
	public static int speed = 1;
	
	//the multiplier that boosts the speed at which the aliens moves
	public static double speedMultiplier = 1;
	
	//used to move the aliens downward after hitting a wall
	public static int displacement = 0;
	
	// The speed the alien is sat to if moveLeft is called 
	private int speedThreshold = 2;
	
	//the view of this alien
	private Unit sprite;
	
	//indicates whether or not this alien is dead
	private boolean isDead;
	
	//The chance of any given alien to fire at any given update
	private static double chanceToFire = 0.001;

	public Enemy(){
		this.sprite = new unitViews.Enemy();
		this.xPos = 0;
		this.yPos = 0;
		isDead = false;
	}
	/**
	 * gets the position of the enemy on the x axis
	 */
	public int getXpos() {
		return xPos;
	}
	
	/**
	 * gets the position of the enemy on the y axis
	 */
	public int getYpos() {
		return yPos + (sprite.getHeight() * displacement);
	}

	/**
	 * gets the view of this enemy
	 */
	public Unit getView() {
		return this.sprite;
	}

	/**
	 * Causes this enemy to fire towards the player
	 */
	public void fire() {
		new EnemyBullet(this);
	}

	/**
	 * method that handles the enemy taking damage. should be called after getting hit by a bullet
	 */
	public void takeDamage() {
		if(!isDead){
			isDead = true;
			getDeadShips().add(this);
			speedMultiplier += 0.06;
		}
		
		
	}

	/**
	 * causes the enemy to move to the left
	 */
	public void moveLeft() {
		speed = -speedThreshold;
		
	}

	/**
	 * causes the enemy to move to the right
	 */
	public void moveRight() {
		speed = speedThreshold;
		
	}

	public void setYpos(int y) {
		yPos = y;
	}


	public void setXpos(int x) {
		this.xPos = x;
		
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void stop(){
		speed = 0;
	}
	
	public void update(){
		xPos = xPos + speed * (int)Math.floor(speedMultiplier);
		if (Math.random() > 1-chanceToFire){
			
			fire();
		}
		
		if(xPos < 0 || xPos + sprite.getWidth() > JaceInvaders.Width){
			speed = speed * -1;
			displacement++;
			
		}
		
		if(getYpos() + getHeight() >= JaceInvaders.game.player.getYpos() ){
			JaceInvaders.game.newLevel(JaceInvaders.game.level);
			JaceInvaders.game.player.takeDamage();
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
