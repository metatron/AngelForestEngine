package jp.arrow.angelforest.engine.param.bulletparam;

public class SwappingBulletParameters extends BulletParameters {
	private BulletParameters param2;
	private int interval;
	
	public SwappingBulletParameters(int bulletId, BulletParameters param1, int interval, BulletParameters param2) {
		super(bulletId, param1.getTextureParameters(), param1.getBasicParameters(), TYPE_SWAP);
		this.param2 = param2;
		this.interval = interval;
	}

	public BulletParameters getParam2() {
		return param2;
	}

	public int getInterval() {
		return interval;
	}

}
