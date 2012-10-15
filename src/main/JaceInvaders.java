package main;

import java.util.ArrayList;

import screen.GameScreen;
import unitModels.Player;
import unitModels.Ship;
import unitViews.Enemy;



public class JaceInvaders {
	
	
	
	public static int FPS = 30;
	
	public static int Width = 500;
	
	public static int Height = 500;
	
	private ArrayList<Ship> ships;
	
	private GameScreen gameScreen;
	
	private static JaceInvaders game;
	
	public static void main(String[] args) {
		
		game = new JaceInvaders();
		game.start();
	}
	
	public JaceInvaders() {
		ships = new ArrayList<Ship>();
		ships.add(new Player());
	}
	
	/**
	 * Starts the game
	 */
	public void start(){
		gameScreen = new GameScreen(this);
	}
	

	
	public ArrayList<Ship> getShips(){
		return ships;
	}
}
