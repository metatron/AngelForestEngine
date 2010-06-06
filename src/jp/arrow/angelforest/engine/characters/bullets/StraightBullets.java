package jp.arrow.angelforest.engine.characters.bullets;

import android.util.Log;
import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.param.BasicParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class StraightBullets extends AbstractBullet {

	public StraightBullets(CharacterParameters param) {
		super(param);
	}

	@Override
	protected void movement(float x, float y, float w, float h, float angle) {
		final BasicParameters basicParam = param.getBasicParameters();
		
		//angle
		if((basicParam.getMax_angle() >= 0 && angle <= basicParam.getMax_angle()) || //when rate is +
			(basicParam.getMax_angle() < 0 && angle > basicParam.getMax_angle())) { //when rate is -
			basicParam.setAngle_accelerate(basicParam.getAngle_accelerate()+basicParam.getOriginal_angle_accelerate());
			angle += basicParam.getAngle_rate() + basicParam.getAngle_accelerate();
		}
		setAngle(angle);
		
		//speed
		if(basicParam.getSpeed() < basicParam.getMax_speed()) {
			setSpeed(getSpeed()+basicParam.getSpeed_accelerate());
		}
		
		//x and y
		int d_y = (int)(getY()+basicParam.getSpeed()*Math.sin(Math.toRadians(angle)));
		int d_x = (int)(getX()+basicParam.getSpeed()*Math.cos(Math.toRadians(angle)));
		setX(d_x);
		setY(d_y);
	}

	/**
	 * for time effect
	 */
	@Override
	public void drawAfter(float x, float y, float w, float h, float angle) {
		Log.e(null, "bullet drawafter: " + param.getTimer().getCurrent());
		
	}
	
	
}
