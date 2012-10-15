package screen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.JSpaceInvaders;

import unitModels.Ship;

public class GameScreen extends JFrame{

	private ArrayList<Ship> ships;
	private Thread painter;
	private final JSpaceInvaders game;
	private JPanel gamePanel;
	
	public GameScreen(final JSpaceInvaders game){
		this.game = game;
		this.gamePanel = new GamePanel();
		ships = new ArrayList<Ship>();
		add(gamePanel);
		painter = new Thread(new Runnable(){

			public void run() {
				for(;;){
					repaint();
					try {
						Thread.sleep(1000/game.getFPS());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		});
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		gamePanel.setBackground(Color.black);
		painter.start();
	}



	class GamePanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//paint all the objects
			for (Ship s : game.getShips()) {
				g.drawImage(s.getSprite(), s.getXpos(),s.getYpos(), this);
			}
		}
	}
}
