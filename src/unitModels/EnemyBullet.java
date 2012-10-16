package unitModels;

import unitViews.BulletView;

/**
 * Bullets used by the aliens
 * @author Metareven
 *
 */
public class EnemyBullet extends BulletModel {

	private Ship owner;
	
	/**
	 * creates and fires a bullet
	 * @param owner the one firing the bullet
	 */
	public EnemyBullet(Ship owner) {
		super(owner);
		speed = 5;
		sprite = new BulletView("alien");
	}
	

}
