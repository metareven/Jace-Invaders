package unitModels;

import java.awt.Color;
import java.awt.Graphics;



public class Shield extends SpaceObject {

	private int xPos;
	private int yPos;
	private int size = 5;
	private boolean[][] remaining;
	
	
	public Shield(int xPos,int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
		remaining = new boolean[10][10];
		
		for(int x=0;x < remaining.length; x++){
			for(int y=0;y < remaining[x].length;y++){
				remaining[x][y] = true;
			}
		}
	}
	
	public void drawShield(Graphics g){
		
		for(int x=0;x < remaining.length; x++){
			for(int y=0;y < remaining[x].length;y++){
				if(remaining[x][y]){
					Color previousColor = g.getColor();
					g.setColor(Color.green);
					g.fillRect(xPos + x*size,yPos + y*size, size, size);
					g.setColor(previousColor);
				}
			}
		}
	}

	public int getXpos() {
		return xPos;
	}

	public int getYpos() {
		return yPos;
	}

	public void takeDamage() {
		// TODO Auto-generated method stub
		
	}

	public void setXpos(int x) {
		xPos = x;
	}

	public void setYpos(int y) {
		yPos = y;
	}

	public void update() {
		
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void collisionReaction(SpaceObject x) {
		// TODO Auto-generated method stub
		
	}
	

}
