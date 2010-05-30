package jp.arrow.angelforest.engine.characters.bullets;

import android.util.Log;
import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class StraightBullets extends AbstractBullet {

	public StraightBullets(CharacterParameters param) {
		super(param);
	}

	@Override
	protected void movement(float x, float y, float w, float h, float angle) {
		setAngle(angle);
		
		int d_y = (int)(getY()+param.getBasicParameters().getSpeed()*Math.sin(Math.toRadians(angle)));
		int d_x = (int)(getX()+param.getBasicParameters().getSpeed()*Math.cos(Math.toRadians(angle)));
		setX(d_x);
		setY(d_y);
	}

}
