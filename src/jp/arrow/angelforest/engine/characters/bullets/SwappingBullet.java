package jp.arrow.angelforest.engine.characters.bullets;

import android.util.Log;
import jp.arrow.angelforest.engine.param.bulletparam.BulletParameters;
import jp.arrow.angelforest.engine.param.bulletparam.SwappingBulletParameters;

public class SwappingBullet extends StraightBullets {
	private BulletParameters secondParam;
	private int interval;
	
	public SwappingBullet(SwappingBulletParameters param) {
		super(param);
		this.interval = param.getInterval();
		secondParam = param.getParam2();
	}

	@Override
	public void drawAfter(float x, float y, float w, float h, float angle) {
		if(charParam.getCurrentTime()%interval == 0) {
			secondParam.setPrev_x(charParam.getPrev_x());
			secondParam.setPrev_y(charParam.getPrev_y());
			secondParam.getBasicParameters().setX(charParam.getBasicParameters().getX());
			secondParam.getBasicParameters().setY(charParam.getBasicParameters().getY());
			charParam = secondParam;
//			float newangle = getAngle() + secondParam.getBulletId()*charParam.getBasicParameters().getAngle_rate();
			dirAngle = -charParam.getBasicParameters().getOriginal_angle();
			Log.e(null, "dirAngle: " + dirAngle);
		}
	}
}
