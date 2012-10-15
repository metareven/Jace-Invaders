package factories;

import unitModels.Enemy;

public class EnemyFactory {

	private int counter;
	
	public EnemyFactory(int number){
		counter = number;
	}
	
	public boolean hasNext(){
		return counter > 0;
	}
	
	public Enemy getNext(){
		if (counter <= 0){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.err.println("Could not create more enemies from "+this.toString());
				e.printStackTrace();
			}
		}
		return new Enemy();
	}
}
