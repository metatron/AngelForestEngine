package jp.arrow.angelforest.engine.animations;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class UpMotionAnimation extends AbstractAnimation {

	public UpMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getUpmotiontextureIds(), characterParameters.getInterval(), characterParameters.getTimer());
	}

}
