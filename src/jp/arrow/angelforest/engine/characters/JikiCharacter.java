package jp.arrow.angelforest.engine.characters;

import java.util.ArrayList;

import android.util.Log;
import jp.arrow.angelforest.engine.param.BulletParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.main.R;

public class JikiCharacter extends LiveCharacter {
	private ArrayList<Integer> nomotion;
	
	public JikiCharacter(CharacterParameters param) {
		super(param);
		
		//init bullets
		nomotion = new ArrayList<Integer>();
		nomotion.add(R.drawable.enemy_normal_shot_01);
		
		//first bullet creation
//		createOriginalBulletParameters();
	}
	
	int angle=90;
	@Override
	public ArrayList<BulletParameters> createOriginalBulletParameters() {
		//TODO create bulletParam. this is temporary
		BulletParameters bulletParam = new BulletParameters(
								nomotion, //nomotion
								null, //down
								null, //up
								null, //left
								null, //right
								10, //hp
								10, //power
								5, //interval
								25f, //speed
								angle, //angle
								BulletParameters.TYPE_STRAIGHT //type
								);
		bulletParam.setX(getX());
		bulletParam.setY(getY());
		
		ArrayList<BulletParameters> genedBullets = new ArrayList<BulletParameters>();
		if(param.getCurrentTime()%bulletParam.getInterval() == 0) {
//			angle--;
			//add parameters to array and return it
			genedBullets.add(bulletParam);
		}
		
		return genedBullets;
	}
}
