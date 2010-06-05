package jp.arrow.angelforest.engine.characters;

import java.util.ArrayList;

import android.util.Log;
import jp.arrow.angelforest.engine.param.BasicParameters;
import jp.arrow.angelforest.engine.param.BulletParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.param.TextureParameters;
import jp.arrow.angelforest.main.R;

public class JikiCharacter extends LiveCharacter {
	private TextureParameters textureParameters;
	
	public JikiCharacter(CharacterParameters param) {
		super(param);
		
		//init bullets
		ArrayList<Integer> nomotions = new ArrayList<Integer>();
		nomotions.add(R.drawable.enemy_normal_shot_01);
		textureParameters = new TextureParameters(nomotions, null, null, null, null);
	}
	
	@Override
	public ArrayList<BulletParameters> createOriginalBulletParameters() {
		//TODO create bulletParam. this is temporary
		BasicParameters basicParameters = new BasicParameters(
				getX(), //float x 
				getY(), //float y 
				5, 	//float speed
				5, 		//float hitR 
				10,		//int dmg
				10,		//int hp
				-90,	//float angle
				20,		//int interval
				0,		//float angleRate
				0,		//float angleAccelerate
				0,		//max angle
				0.3f,		//float speedAccelerate
				50		//float max speed
				);

		BulletParameters bulletParam = new BulletParameters(
								textureParameters, //right
								basicParameters,
								BulletParameters.TYPE_STRAIGHT //type
								);
		bulletParam.getBasicParameters().setX(getX());
		bulletParam.getBasicParameters().setY(getY());
		
		ArrayList<BulletParameters> genedBullets = new ArrayList<BulletParameters>();
		if(param.getCurrentTime()%bulletParam.getBasicParameters().getInterval() == 0) {
			//add parameters to array and return it
			genedBullets.add(bulletParam);
		}
		
		//bullet 2
		//TODO create bulletParam. this is temporary
//		BasicParameters basicParameters2 = new BasicParameters(
//				getX(), //float x 
//				getY(), //float y 
//				5, 	//float speed
//				5, 		//float hitR 
//				10,		//int dmg
//				10,		//int hp
//				-90,	//float angle
//				20,		//int interval
//				3,		//float angleRate
//				0,		//float angleAccelerate
//				360,		//max angle
//				0,		//float speedAccelerate
//				0		//float max speed
//				);
//
//		BulletParameters bulletParam2 = new BulletParameters(
//								textureParameters, //right
//								basicParameters2,
//								BulletParameters.TYPE_STRAIGHT //type
//								);
//		bulletParam2.getBasicParameters().setX(getX());
//		bulletParam2.getBasicParameters().setY(getY());
//		
//		if(param.getCurrentTime()%bulletParam2.getBasicParameters().getInterval() == 0) {
//			//add parameters to array and return it
//			genedBullets.add(bulletParam2);
//		}
		
		return genedBullets;
	}
}
