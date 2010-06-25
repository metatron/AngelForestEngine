package jp.arrow.angelforest.engine.characters.bullets;

import android.util.Log;
import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.param.BasicParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.param.bulletparam.BulletParameters;

public class StraightBullets extends AbstractBullet {

	public StraightBullets(BulletParameters param) {
		super(param);
		float newangle = getAngle() + param.getBulletId()*charParam.getBasicParameters().getAngle_rate();
		setAngle(newangle);
		
		//for the facing direction angle
		dirAngle = newangle-charParam.getBasicParameters().getOriginal_angle();
//		Log.e(null, "angle: " + newangle + ", dirAngle: " + dirAngle);
//		Log.e(null, "angle: " + newangle + ", bulletid: " + ((BulletParameters)charParam).getBulletId());
	}
	
	@Override
	protected void movement(float x, float y, float w, float h, float angle) {
		final BasicParameters basicParam = charParam.getBasicParameters();
		
		//angle
		if((basicParam.getMax_angle() >= 0 && angle <= basicParam.getMax_angle()) || //when rate is +
			(basicParam.getMax_angle() < 0 && angle > basicParam.getMax_angle())) { //when rate is -
//			basicParam.setAngle_accelerate(basicParam.getAngle_accelerate()+basicParam.getOriginal_angle_accelerate());
			angle += basicParam.getAngle_accelerate();
		}
		setAngle(angle);
		
		//speed
		if(basicParam.getSpeed() < basicParam.getMax_speed()) {
			setSpeed(getSpeed()+basicParam.getSpeed_accelerate());
		}
		
		//x and y
		float d_y = getY()+basicParam.getSpeed()*(float)Math.sin(Math.toRadians(getAngle()));
		float d_x = getX()+basicParam.getSpeed()*(float)Math.cos(Math.toRadians(getAngle()));
		setX(d_x);
		setY(d_y);
	}
}
