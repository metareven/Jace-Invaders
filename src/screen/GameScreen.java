package screen;

import java.awt.Color;
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

public class GameScreen extends JFrame{

	private ArrayList<Ship> ships;
	private Thread updater;
	private final JaceInvaders game;
	private JPanel gamePanel;
	
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



	class GamePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//update the positions and draw each object
			
			for (Ship s : game.getShips()){
				for( BulletModel b : BulletModel.getBullets()){
					if (b.collision(s)){
						b.collisionReaction(s);
						s.collisionReaction(b);
					}
				}
			}
			
			game.getShips().removeAll(Enemy.getDeadShips());
			Enemy.getDeadShips().clear();
			BulletModel.getBullets().removeAll(BulletModel.getDeadBullets());
			BulletModel.getDeadBullets().clear();
			
			for (Ship s : game.getShips()) {
				g.drawImage(s.getView().getSprite(), s.getXpos(),s.getYpos(), this);
				s.update();
			}
			for (BulletModel b : BulletModel.getBullets()){
				g.drawImage(b.getSprite(),b.getXpos(),b.getYpos(),this);
				b.update();
			}
			
			System.out.println(game.getShips().size());
			if( game.getShips().size() <= 2){
				System.out.println("starting new level");
				JaceInvaders.game.newLevel(2);
			}
			
			
		}
	}
}
