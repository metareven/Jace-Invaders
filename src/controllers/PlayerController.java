package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import unitModels.*;

/**
 * A KeyListener that listens to input from the keyboard that is used to control the player
 * in JaceInvaders
 * @author Metareven
 *
 */


public class PlayerController implements KeyListener {
	
	//the player object that this controller controls
	private Player player;
	
	
	public PlayerController(Player player){
		this.player = player;
	}
	
	public void keyPressed(KeyEvent arg0) {
		
		//the controller should not do anything when the player is dead
		if(player.getLives() <= 0){
			return;
		}
		String key = ("" + arg0.getKeyChar()).toLowerCase();
		
		if (key.equals("a")){
			//move to the left
			player.moveLeft();
		}
		if (key.equals("d")){
			//move to the right
			player.moveRight();
		}
		if (key.equals(" ")){
			//shoot
			player.fire();
		}
		
		
		
		
	}

	public void keyReleased(KeyEvent arg0) {
		String key = "" + ("" + arg0.getKeyChar()).toLowerCase();
		if (key.equals("a")){
			//move to the left
			player.stop();
		}
		if (key.equals("d")){
			//move to the right
			player.stop();
		}
		
	}

	public void keyTyped(KeyEvent arg0) {
		//do nothing
	}

}
