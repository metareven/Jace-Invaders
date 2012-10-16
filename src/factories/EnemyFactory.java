package factories;

import unitModels.Enemy;

public class EnemyFactory {

	private int counter;
	private int maxEnemies;
	private int xDistance = 10;
	private int yDistance = 5;
	private int enemiesPerLine = 11;
	
	public EnemyFactory(int number){
		counter = 0;
		maxEnemies = number;
	}
	
	public boolean hasNext(){
		return counter < maxEnemies;
	}
	
	public Enemy getNext(){
		if (counter > maxEnemies){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.err.println("Could not create more enemies from "+this.toString());
				e.printStackTrace();
			}
		}
		Enemy newEnemy = new Enemy();
		newEnemy.setXpos((counter%enemiesPerLine) * (newEnemy.getView().getWidth() + xDistance));
		newEnemy.setYpos((counter/enemiesPerLine) * (newEnemy.getView().getHeight() + yDistance));
		counter++;
		return newEnemy;
	}
}
