package jp.arrow.angelforest.engine.abstructclass;

public interface IntrAnimation {
	public final static int ANIME_NOT_STARTED = 0;
	public final static int ANIME_STARTED = 1;
	public final static int ANIME_FINISHED = 2;

	public static final int MOTION_NOMOTION = 0;
	public static final int MOTION_RIGHT = 1;
	public static final int MOTION_LEFT = 2;
	public static final int MOTION_UP = 3;
	public static final int MOTION_DOWN = 4;
	public static final int MOTION_EXPLODE = 5;
	
	public int getAnimationStatus();
	public void animateBefore(int x, int y, float w, float h, float angle);
	public void animate(int x, int y, float w, float h, float angle);
	public void animateAfter(int x, int y, float w, float h, float angle);
	public void delete();
}
