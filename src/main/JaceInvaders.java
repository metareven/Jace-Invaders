package main;

import java.util.ArrayList;

import factories.EnemyFactory;

import screen.GameScreen;
import unitModels.Player;
import unitModels.Ship;
import unitViews.Enemy;


/**
 * Class that contains the main method for starting Jace Invaders.
 * Also contains static variables containing information about the physical size of the game
 * and the player.
 * @author Metareven
 *
 */
public class JaceInvaders {
	
	
	//The FPS the game tries to run on. Not being able to run this fast causes "slow-down" instead of "jerking"
	public static int FPS = 30;
	
	//the width of the frame containing the game
	public static int Width = 500;
	
	//The height of the frame containing the game
	public static int Height = 500;
	
	//The current level
	public int level = 1;
	
	//the ships used in the game
	private ArrayList<Ship> ships;
	
	//the screen that handles updating all of the unit models, managing hit detection and drawing object
	private GameScreen gameScreen;
	
	//The current instance of JaceInvaders
	public static JaceInvaders game;
	
	//The playable character
	public static Player player;
	
	/**
	 * Main method for Jace Invaders. Creates a new instance of JaceInvaders and runs it.
	 * @param args Not used
	 */
	public static void main(String[] args) {
		
		game = new JaceInvaders();
		game.start();
	}
	
	/**
	 * The constructor of JaceInvaders. The constructor generates a new player and an arraylist containing
	 * the player and enemies in the game.
	 */
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
	 * Starts a new level. Removes and resets the speed multiplier of all enemies.
	 * @param i : The number of the new level. The higher the number the faster the enemies move
	 */
	public void newLevel(int i){
		
		level = i;
		unitModels.Enemy.getDeadShips().addAll(JaceInvaders.game.getShips().subList(1, JaceInvaders.game.getShips().size()));
		unitModels.Enemy.displacement = 0;
		ships = new ArrayList<Ship>();
		if(player.getLives() > 0){
			ships.add(player);
		}
		EnemyFactory factory = new EnemyFactory(11 * 5);
		while(factory.hasNext()){
			ships.add(factory.getNext());
		}
		unitModels.Enemy.speed = i;
		unitModels.Enemy.speedMultiplier = 1;
	}
	

	/**
	 * Used to get a list of all of the ships in the game.
	 * @return A list of all the ships in the game. This means the aliens and the player
	 */
	public ArrayList<Ship> getShips(){
		return ships;
	}
	
	/**
	 * Gets the player controlled unit
	 * @return The player
	 */
	public static Player getPlayer(){
		return player;
	}
}
