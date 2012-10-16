package unitModels;

import unitViews.BulletView;

public class PlayerBullet extends BulletModel{

	public PlayerBullet(Ship owner) {
		super(owner);
		speed = -5;
		sprite = new BulletView("player");
	}

}
