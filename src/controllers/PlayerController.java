package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import unitModels.*;

public class PlayerController implements KeyListener {
	
	private Ship player;
	
	public PlayerController(Ship player){
		this.player = player;
	}
	
	public void keyPressed(KeyEvent arg0) {
		String key = ("" + arg0.getKeyChar()).toLowerCase();
		System.out.println(key);
		
		System.out.println("pressed key: " + key);
		System.out.println("a".length());
		System.out.println(key.length());
		
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
		// TODO Auto-generated method stub
		
	}

}
