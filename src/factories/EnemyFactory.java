package factories;

import unitModels.Enemy;

/**
 * A factory that generates a number of enemies and positions them according to the standards
 * of space invaders
 * @author Metareven
 *
 */
public class EnemyFactory {

	private int counter;
	private int maxEnemies;
	private int xDistance = 10;
	private int yDistance = 5;
	private int enemiesPerLine = 11;
	
	/**
	 * Creates a new EnemyFactory
	 * @param number : The number of enemies that are to be generated. The suggested number is 5 * 11 which will
	 * generate 5 rows of 11 aliens
	 */
	public EnemyFactory(int number){
		counter = 0;
		maxEnemies = number;
	}
	
	/**
	 * Used to check whether or not there are more enemies for the factory to generate 
	 * @return whether or not there are any more enemies to create
	 */
	public boolean hasNext(){
		return counter < maxEnemies;
	}
	
	/**
	 * Creates a new enemy if the factory has not yet created the specified number of enemies.
	 * Otherwise, throws an exception 
	 * @throws Exception 
	 * @return The next  enemy in line
	 */
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
