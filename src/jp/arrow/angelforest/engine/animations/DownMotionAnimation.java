package jp.arrow.angelforest.engine.animations;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;

public class DownMotionAnimation extends AbstractAnimation {

	public DownMotionAnimation(CharacterParameters characterParameters) {
		super(characterParameters.getDownmotiontextureIds(), characterParameters.getInterval(), characterParameters.getTimer());
	}

}
