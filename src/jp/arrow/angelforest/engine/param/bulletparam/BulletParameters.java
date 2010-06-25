package jp.arrow.angelforest.engine.param.bulletparam;

import jp.arrow.angelforest.engine.param.BasicParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.param.TextureParameters;

public class BulletParameters extends CharacterParameters {
	public static final int TYPE_STRAIGHT = 0;
	public static final int TYPE_SWAP = 1;
	
	private int type;
	private int bulletId;
	
	public BulletParameters(
			int bulletId,
			TextureParameters textureParameters,
			BasicParameters basicParameters,
			int type) {
		super(textureParameters, basicParameters);
		
		this.type = type;
		this.bulletId = bulletId;
	}
	
	public int getType() {
		return type;
	}

	public int getBulletId() {
		return bulletId;
	}

}
