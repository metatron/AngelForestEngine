package jp.arrow.angelforest.engine.animations;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class NoMotionAnimation extends AbstractAnimation {
	public NoMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getNomotiontextureIds(), characterParameters.getInterval(), characterParameters.getTimer());
	}
}
