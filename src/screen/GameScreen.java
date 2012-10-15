package screen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.PlayerController;

import main.JaceInvaders;

import unitModels.BulletModel;
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
		gamePanel.setBackground(Color.black);
		this.addKeyListener(new PlayerController(JaceInvaders.getPlayer()));
		updater.start();
	}



	class GamePanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//update the positions and draw each object
			for (Ship s : game.getShips()) {
				g.drawImage(s.getSprite(), s.getXpos(),s.getYpos(), this);
				s.update();
			}
			for (BulletModel b : BulletModel.getBullets()){
				g.drawImage(b.getSprite(),b.getXpos(),b.getYpos(),this);
				b.update();
			}
		}
	}
}
