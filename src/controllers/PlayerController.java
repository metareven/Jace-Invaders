package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import unitModels.*;

public class PlayerController implements KeyListener {
	
	private Ship player;
	
	public void keyPressed(KeyEvent arg0) {
		String key = ("" + arg0.getKeyChar()).toLowerCase();
		
		
		System.out.println("pressed key: " + key);
		
		if (key == "a"){
			//move to the left
			player.moveLeft();
		}
		if (key == "d"){
			//move to the right
			player.moveRight();
		}
		if (key == " "){
			//shoot
			player.fire();
		}
		
		
		
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
