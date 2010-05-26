package jp.arrow.angelforest.engine.characters.bullets;

import android.util.Log;
import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class StraightBullets extends AbstractBullet {

	public StraightBullets(CharacterParameters param) {
		super(param);
	}

	@Override
	protected void movement(int x, int y, float w, float h, float angle) {
		setAngle(angle);
		
		int d_y = (int)(getY()+param.getSpeed()*Math.sin(Math.toRadians(angle)));
		int d_x = (int)(getX()+param.getSpeed()*Math.cos(Math.toRadians(angle)));
		Log.e(null, "d_x: " + d_x + ", d_y: " + d_y + "||  inc_x: " + param.getSpeed()*Math.cos(angle) + ", inc_y: " + param.getSpeed()*Math.sin(angle));
		setX(d_x);
		setY(d_y);
	}

}
