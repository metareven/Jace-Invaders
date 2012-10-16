package screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.PlayerController;

import main.JaceInvaders;

import unitModels.BulletModel;
import unitModels.Enemy;
import unitModels.Shield;
import unitModels.Ship;

/**
 * The frame that contains the game. Creating an instance of GameScreen causes the game to
 * start according to the paramaters set in the JaceInvaders instance
 * @author Metareven
 *
 */
public class GameScreen extends JFrame{

	//list of all the ships that are to be drawn/updated
	private ArrayList<Ship> ships;

	//thread used to update the image independently of handling input from the user
	private Thread updater;

	//The instance of JaceInvaders that this GameScreen uses for information about the startup of the game
	private final JaceInvaders game;

	//Panel containing the content of the GameScreen
	private JPanel gamePanel;

	/**
	 * Constructor of the GameScreen class. Creates a new GamePanel and a thread that updates the screen and
	 * units on screen independently of reading the input from the keyboard
	 * @param game The JaceInvaders instance that is used to get information on how to create the gameScreen.
	 */
	public GameScreen(final JaceInvaders game){
		this.game = game;
		this.gamePanel = new GamePanel();
		ships = new ArrayList<Ship>();
		add(gamePanel);
		updater = new Thread(new Runnable(){

			public void run() {
				for(;;){
					repaint();
					try {
						Thread.sleep(1000/game.FPS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		});
		setSize(JaceInvaders.Width,JaceInvaders.Height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		gamePanel.setBackground(Color.black);
		this.addKeyListener(new PlayerController(JaceInvaders.getPlayer()));
		updater.start();
	}


	/**
	 * GamePanel containing the content of the GameScreen. This class updates all of the game's models
	 * and paints them, causing the game to "slow down" instead of "jerking" if short on resources.
	 * @author Metareven
	 *
	 */
	class GamePanel extends JPanel{
		HUD hud = new HUD();

		ArrayList<Shield> shields = new ArrayList<Shield>();

		public GamePanel() {
			for (int i = 0; i < 3; i++) {
				shields.add(new Shield(100 + i*100, 300));
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//update the positions and draw each object

			calculateCollisions();
			removeDeadUnits();

			//draws all the ships on the screen and updates their position
			for (Ship s : game.getShips()) {
				g.drawImage(s.getView().getSprite(), s.getXpos(),s.getYpos(), this);
				s.update();
			}
			//draws all the bullets on screen and updates their position
			for (BulletModel b : BulletModel.getBullets()){
				g.drawImage(b.getSprite(),b.getXpos(),b.getYpos(),this);
				b.update();
			}

			
			//draws all of the shields that are on screen
			for (Shield s : shields) {
				s.drawShield(g);
			}
			
			//draws the hud
			hud.drawHUD(g);

			//checks whether or not the next level should be generated
			isLevelDone();
			
			//checks whether or not the game should end
			checkGameOver(g);

		}

		/**
		 * Calculates Collisions and updates the units accordingly. This means for example killing
		 * enemies that have been hit with bullets and removing bullets that have hit and object.
		 */
		public void calculateCollisions(){
			for( BulletModel b : BulletModel.getBullets()){
				for (Ship s : game.getShips()){
					if (b.collision(s)){
						b.collisionReaction(s);
						s.collisionReaction(b);
					}
				}
				for (Shield s : shields) {
					if(b.collision(s)){
						s.collisionReaction(b);
					}
				}
			}

		}
		
		/**
		 * Checks whether the next level should be generated or not and then starts it.
		 */
		public void isLevelDone(){
			if( game.getShips().size() <= 1){
				startNewLevel();
			}
		}

		/**
		 * Generates the next level. This is equivalent to incrementing the level by one
		 * and calling the new level function in JaceInvaders
		 */
		public void startNewLevel(){
			System.out.println("starting new level");
			JaceInvaders.game.newLevel(JaceInvaders.game.level +1);
		}
		
		/**
		 * Removes dead units and shots that have gone past the screen or hit something.
		 */
		public void removeDeadUnits(){
			game.getShips().removeAll(Enemy.getDeadShips());
			Enemy.getDeadShips().clear();
			BulletModel.getBullets().removeAll(BulletModel.getDeadBullets());
			BulletModel.getDeadBullets().clear();
		}

		/**
		 * Checks whether or not the game is over and draws a game over message.
		 * @param g The graphics instance that is used to draw the game over message
		 */
		public void checkGameOver(Graphics g){
			if (JaceInvaders.game.player.getLives() <= 0){
				Font font = new Font("Serif", Font.PLAIN, 72);
				g.setFont(font);
				g.setColor(Color.red);
				g.drawString("GAME OVER", 0, 100);
			}
		}


	}
}
