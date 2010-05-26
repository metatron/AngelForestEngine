package jp.arrow.angelforest.engine.utils;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.characters.bullets.StraightBullets;
import jp.arrow.angelforest.engine.param.BulletParameters;

public class BulletFactory {
	public static ArrayList<AbstractBullet> create(ArrayList<BulletParameters> bulletParams) {
		ArrayList<AbstractBullet> genedBullets = new ArrayList<AbstractBullet>();
		for(BulletParameters bulletParam: bulletParams) {
			switch(bulletParam.getType()) {
			case BulletParameters.TYPE_STRAIGHT:
				genedBullets.add(new StraightBullets(bulletParam));
				break;
			default:
				genedBullets.add(new StraightBullets(bulletParam));
				break;
			}
		}
		
		return genedBullets;
	}

}
