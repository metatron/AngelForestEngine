package jp.arrow.angelforest.engine.characters;

import java.util.ArrayList;
import jp.arrow.angelforest.engine.abstructclass.AbstractCharacter;
import jp.arrow.angelforest.engine.param.BulletParameters;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class LiveCharacter extends AbstractCharacter {
	protected ArrayList<BulletParameters> originalBulletParameters;
	
	public LiveCharacter(CharacterParameters param) {
		super(param);
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
