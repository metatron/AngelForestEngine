package jp.arrow.angelforest.engine.abstructclass;

import java.util.ArrayList;

import android.util.Log;

import jp.arrow.angelforest.engine.core.TexturePolygon;
import jp.arrow.angelforest.engine.param.SystemParameters;
import jp.arrow.angelforest.engine.utils.Timer;

public abstract class AbstractAnimation implements IntrAnimation {
	private int animationStatus = ANIME_NOT_STARTED;
	//this is for public class to know whether this animation increased a frame or not.
	
	//tick
	private int animateInterval = 0;
	protected Timer timer;
	
	private int currentFrame = 0;
	private int maxFrame;
	
	private ArrayList<TexturePolygon> textures = new ArrayList<TexturePolygon>();
	
	public AbstractAnimation(ArrayList<Integer> textureIds, int interval, Timer timer) {
		for(Integer id: textureIds) {
			TexturePolygon texture = new TexturePolygon(SystemParameters.context, id);
			textures.add(texture);
		}
		
		animateInterval = interval;
		maxFrame = textures.size();
		this.timer = timer;
	}
	
	@Override
	public void animateBefore(int x, int y, float w, float h, float angle){}
	@Override
	public void animateAfter(int x, int y, float w, float h, float angle){}
	
	@Override
	public void animate(int x, int y, float w, float h, float angle) {
		//
		if(animationStatus == ANIME_NOT_STARTED || animationStatus == ANIME_FINISHED) {
			animationStatus = ANIME_STARTED;
		}
		
		//be4
		animateBefore(x, y, w, h, angle);
		
		//draw
		textures.get(currentFrame).draw(x, y, w, h, angle);
		
		//aftr
		animateAfter(x, y, w, h, angle);
		
		//if displaying last frame, set animation status to finished
		if(timer.getCurrent()%animateInterval == 0) {
			if(currentFrame == maxFrame-1) {
				animationStatus = ANIME_FINISHED;
				currentFrame = 0;
			}
			else {
				currentFrame++;
			}
//			timer.reset();
		}
		timer.tick();
	}

	@Override
	public int getAnimationStatus() {
		return animationStatus;
	}
	
	@Override
	public void delete() {
		for(TexturePolygon texture: textures) {
			texture.delete();
		}
		textures.clear();
		textures = null;
	}
	
	/**
	 * detect character's current motion.
	 * 
	 * @param crnt_x
	 * @param crnt_y
	 * @param prev_x
	 * @param prev_y
	 * @return
	 */
	public static int detectMotion(int crnt_x, int crnt_y, int prev_x, int prev_y) {
		
		//not moving
		if(crnt_x == prev_x && crnt_y == prev_y) {
			return MOTION_NOMOTION;
		}
		
		//moving right
		if(crnt_x > prev_x) {
			return MOTION_RIGHT;
		}
		//moving left
		if(crnt_x < prev_x) {
			return MOTION_LEFT;
		}
		//moving down
		if(crnt_y > prev_y) {
			return MOTION_DOWN;
		}
		//moving up
		if(crnt_y < prev_y) {
			return MOTION_UP;
		}
		
		//other situation, no motion
		return MOTION_NOMOTION;
	}
}
