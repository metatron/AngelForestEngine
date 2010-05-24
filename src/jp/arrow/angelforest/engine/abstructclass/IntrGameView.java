package jp.arrow.angelforest.engine.abstructclass;

import android.view.MotionEvent;

public interface IntrGameView {
	public void init();
	
	/**
	 * do draw
	 */
	public void draw();
	
	/**
	 * key event
	 * @param event
	 */
	public boolean keyPressedEvent(MotionEvent event);
	public boolean onTouchEvent(MotionEvent event);

	public boolean isDeleted();
	public void delete();
}
