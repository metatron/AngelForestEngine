package jp.arrow.angelforest.engine.param;

import java.util.ArrayList;

public class BulletParameters extends CharacterParameters {
	public static final int TYPE_STRAIGHT = 0;
	
	private int type;
	
	public BulletParameters(
			TextureParameters textureParameters,
			BasicParameters basicParameters,
			int type) {
		super(textureParameters, basicParameters);
		
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
