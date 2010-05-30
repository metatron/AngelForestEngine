package jp.arrow.angelforest.engine.param;

import jp.arrow.angelforest.engine.utils.Timer;

public class CharacterParameters {
	private TextureParameters textureParameters;
	private BasicParameters basicParameters;
	
	private float prev_x;
	private float prev_y;
	
	private Timer timer;
	
	public CharacterParameters(
			TextureParameters textureParameters,
			BasicParameters basicParameters
			) {
		this.textureParameters = textureParameters;
		this.basicParameters = basicParameters;
		
		timer = new Timer();
	}

	//---------------------- Timer related methods ------------------------//
	
	public Timer getTimer() {
		return timer;
	}
	
	public void tickTimer() {
		timer.tick();
	}
	
	public void resetTimer() {
		timer.reset();
	}
	
	public Long getCurrentTime() {
		return timer.getCurrent(); 
	}
	
	//-------------------------- Setters and Getters ------------------------//

	public float getPrev_x() {
		return prev_x;
	}

	public void setPrev_x(float prevX) {
		prev_x = prevX;
	}

	public float getPrev_y() {
		return prev_y;
	}

	public void setPrev_y(float prevY) {
		prev_y = prevY;
	}

	public TextureParameters getTextureParameters() {
		return textureParameters;
	}
	
	public BasicParameters getBasicParameters() {
		return basicParameters;
	}
}
