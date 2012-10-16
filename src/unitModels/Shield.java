package unitModels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * Shields that break down on impact
 * @author Metareven
 *
 */
public class Shield extends SpaceObject {

	private int xPos;
	private int yPos;
	private int width = 10;
	private int height = 10;
	private int size = 5;
	private boolean[][] remaining;
	
	/**
	 * creates a shield
	 * @param xPos the position of the shield on the x axis
	 * @param yPos the position of the shield on the y axis
	 */
	public Shield(int xPos,int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
		remaining = new boolean[width][height];
		
		for(int x=0;x < remaining.length; x++){
			for(int y=0;y < remaining[x].length;y++){
				remaining[x][y] = true;
			}
		}
	}
	
	/**
	 * draws the shield 
	 * @param g the graphics the shield is to be displayed on
	 */
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
		
	}
	
	public void takeDamage(int x,int y){
		remaining[x][y] = false;
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
		return width * size;
	}

	@Override
	public int getHeight() {
		return height * size;
	}

	@Override
	public void collisionReaction(SpaceObject x) {
		Rectangle xRect = new Rectangle(x.getXpos(),x.getYpos(),x.getWidth(),x.getHeight());
		Rectangle tempRect = new Rectangle(size,size);
		for(int i = 0; i < remaining.length; i++){
			for(int j = 0; j < remaining[i].length; j++){
				if(remaining[i][j]){
					tempRect.x = xPos + i * size;
					tempRect.y = yPos + j * size;
					if(xRect.intersects(tempRect)){
						takeDamage(i,j);
						x.takeDamage();
					}
				}
			}
		}
	}
	

}
