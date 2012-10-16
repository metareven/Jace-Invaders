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
	
	public int level = 1;
	
	private ArrayList<Ship> ships;
	
	private GameScreen gameScreen;
	
	public static JaceInvaders game;
	
	public static Player player;
	
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
	
	/**
	 * Starts a new level
	 * @param i : The number of the new level. The higher the number the faster the enemies move
	 */
	public void newLevel(int i){
		
		level = i;
		unitModels.Enemy.getDeadShips().addAll(JaceInvaders.game.getShips().subList(1, JaceInvaders.game.getShips().size()));
		unitModels.Enemy.displacement = 0;
		ships = new ArrayList<Ship>();
		ships.add(player);
		EnemyFactory factory = new EnemyFactory(11 * 5);
		while(factory.hasNext()){
			ships.add(factory.getNext());
		}
		unitModels.Enemy.speed = i;
	}
	

	
	public ArrayList<Ship> getShips(){
		return ships;
	}
	
	public static Ship getPlayer(){
		return player;
	}
}
