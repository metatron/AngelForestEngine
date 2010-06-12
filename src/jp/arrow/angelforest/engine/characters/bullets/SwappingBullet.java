package jp.arrow.angelforest.engine.characters.bullets;

import jp.arrow.angelforest.engine.param.BulletParameters;
import jp.arrow.angelforest.engine.param.SwappingBulletParameters;

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
		if(param.getCurrentTime()%interval == 0) {
			secondParam.setPrev_x(param.getPrev_x());
			secondParam.setPrev_y(param.getPrev_y());
			secondParam.getBasicParameters().setX(param.getBasicParameters().getX());
			secondParam.getBasicParameters().setY(param.getBasicParameters().getY());
			param = secondParam;
		}
	}
}
