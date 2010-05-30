package jp.arrow.angelforest.engine.abstructclass;

import jp.arrow.angelforest.engine.param.CharacterParameters;

public interface IntrCharacter {
	public static final int STATUS_ALIVE = 0;  //normal
	public static final int STATUS_DYING = 1;  //dead animating
	public static final int STATUS_DEAD = 2;  //dead
	
	public void drawBefore(float x, float y, float w, float h, float angle);
	public void drawAfter(float x, float y, float w, float h, float angle);
	public void drawMiddle(float x, float y, float w, float h, float angle);
	public void draw(float x, float y, float w, float h, float angle);
	
	public void delete();
	public boolean isDeleted();
	
	public void resetParameter(CharacterParameters charparam);
	public CharacterParameters getParameter();
}
