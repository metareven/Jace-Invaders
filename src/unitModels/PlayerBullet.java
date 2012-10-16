package unitModels;

import unitViews.BulletView;

/**
 * bullets used by the player
 * @author Metareven
 *
 */
public class PlayerBullet extends BulletModel{

	/**
	 * creates and fires a bullet owned by the player
	 * @param owner the player owning the bullet
	 */
	public PlayerBullet(Ship owner) {
		super(owner);
		speed = -5;
		sprite = new BulletView("player");
	}

}
