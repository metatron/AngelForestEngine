package jp.arrow.angelforest.engine.abstructclass;

import android.util.Log;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public abstract class AbstractBullet extends AbstractCharacter {

	public AbstractBullet(CharacterParameters param) {
		super(param);
	}
	
	@Override
	public void drawMiddle(float x, float y, float w, float h, float angle) {
		super.drawMiddle(x, y, w, h, angle);
		//bullet generating
//		if(param.getCurrentTime()%param.getInterval() == 0) {
			movement(x, y, w, h, angle);
//		}
	}
	
	/**
	 * Actual bullet movement, wich will be defined at children's class.
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param angle
	 */
	protected abstract void movement(float x, float y, float w, float h, float angle);
}
