package main;

import java.util.ArrayList;

import screen.GameScreen;
import unitModels.Player;
import unitModels.Ship;
import unitViews.Enemy;



public class JSpaceInvaders {
	
	
	
	private int FPS;
	
	private int Width;
	
	private int Height;
	
	private ArrayList<Ship> ships;
	
	private GameScreen gameScreen;
	
	private static JSpaceInvaders game;
	
	public static void main(String[] args) {
		
		game = new JSpaceInvaders();
		game.start();
	}
	
	public JSpaceInvaders() {
		ships = new ArrayList<Ship>();
		ships.add(new Player());
		this.FPS = 30;
		this.Width = 500;
		this.Height = 500;
	}
	
	/**
	 * Starts the game
	 */
	public void start(){
		gameScreen = new GameScreen(this);
	}
	
	public int getFPS(){
		return FPS;
	}
	
	
	public int getHeight(){
		return Height;
	}
	
	public int getWidth(){
		return Width;
	}
	
	public ArrayList<Ship> getShips(){
		return ships;
	}
}
