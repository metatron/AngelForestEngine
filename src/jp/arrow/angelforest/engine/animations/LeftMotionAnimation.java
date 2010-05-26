package jp.arrow.angelforest.engine.animations;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class LeftMotionAnimation extends AbstractAnimation {
	public LeftMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getLeftmotiontextureIds(), characterParameters.getInterval(), characterParameters.getTimer());
	}
}
