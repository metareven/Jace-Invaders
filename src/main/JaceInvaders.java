package main;

import java.util.ArrayList;

import factories.EnemyFactory;

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
	
	private static Ship player;
	
	public static void main(String[] args) {
		
		game = new JaceInvaders();
		game.start();
	}
	
	public JaceInvaders() {
		player = new Player();
		ships = new ArrayList<Ship>();
		ships.add(player);
		EnemyFactory factory = new EnemyFactory(11 * 5);
		while(factory.hasNext()){
			ships.add(factory.getNext());
		}
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
	
	public static Ship getPlayer(){
		return player;
	}
}
