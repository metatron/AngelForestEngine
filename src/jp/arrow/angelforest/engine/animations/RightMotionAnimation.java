package jp.arrow.angelforest.engine.animations;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class RightMotionAnimation extends AbstractAnimation {
	public RightMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getRightmotiontextureIds(), characterParameters.getInterval(), characterParameters.getTimer());
	}
}
