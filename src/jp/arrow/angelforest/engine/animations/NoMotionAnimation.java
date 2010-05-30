package jp.arrow.angelforest.engine.animations;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class NoMotionAnimation extends AbstractAnimation {
	public NoMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getTextureParameters().getNomotiontextureIds(), characterParameters.getBasicParameters().getInterval(), characterParameters.getTimer());
	}
}
