package jp.arrow.angelforest.engine.param;

import java.util.ArrayList;

public class BulletParameters extends CharacterParameters {
	public static final int TYPE_STRAIGHT = 0;
	
	private int type;
	
	public BulletParameters(
			ArrayList<Integer> nomotiontextureIds,
			ArrayList<Integer> downmotiontextureIds,
			ArrayList<Integer> upmotiontextureIds,
			ArrayList<Integer> leftmotiontextureIds,
			ArrayList<Integer> rightmotiontextureIds, 
			int hp, 
			int power,
			int interval, 
			float speed, 
			float angle,
			int type) {
		super(nomotiontextureIds, downmotiontextureIds, upmotiontextureIds,
				leftmotiontextureIds, rightmotiontextureIds, hp, power, interval,
				speed, angle);
		
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
