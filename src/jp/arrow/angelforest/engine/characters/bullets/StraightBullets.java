package jp.arrow.angelforest.engine.characters.bullets;

import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class StraightBullets extends AbstractBullet {

	public StraightBullets(CharacterParameters param) {
		super(param);
	}

	@Override
	protected void movement(int x, int y, float w, float h, float angle) {
		setAngle(angle);
		
		setY((int)(getY()-param.getSpeed()));
		setX((int)(getY()-param.getSpeed()));
	}

}
