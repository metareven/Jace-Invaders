package unitModels;

import unitViews.BulletView;

public class EnemyBullet extends BulletModel {

	private Ship owner;
	
	public EnemyBullet(Ship owner) {
		super(owner);
		speed = 5;
		sprite = new BulletView("alien");
	}
	

}
