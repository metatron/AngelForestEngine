package jp.arrow.angelforest.engine.characters;

import java.util.ArrayList;
import jp.arrow.angelforest.engine.abstructclass.AbstractCharacter;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.param.bulletparam.BulletParameters;

public class LiveCharacter extends AbstractCharacter {
	protected ArrayList<BulletParameters> originalBulletParameters;
	protected int bulletLastId = 0;
	
	public LiveCharacter(CharacterParameters charParam) {
		super(charParam);
		originalBulletParameters = new ArrayList<BulletParameters>();
	}
	
	public ArrayList<BulletParameters> createOriginalBulletParameters() {
		originalBulletParameters = new ArrayList<BulletParameters>();
		
		return originalBulletParameters;
	}

	public ArrayList<BulletParameters> getOriginalBulletParametersList() {
		return originalBulletParameters;
	}
}
