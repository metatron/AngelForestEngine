package jp.arrow.angelforest.engine.param;

public class SwappingBulletParameters extends BulletParameters {
	private BulletParameters param2;
	private int interval;
	
	public SwappingBulletParameters(BulletParameters param1, int interval, BulletParameters param2) {
		super(param1.getTextureParameters(), param1.getBasicParameters(), TYPE_SWAP);
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
