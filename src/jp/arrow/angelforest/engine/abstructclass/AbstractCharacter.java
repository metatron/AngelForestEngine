package jp.arrow.angelforest.engine.abstructclass;

import java.util.ArrayList;

import android.util.Log;

import jp.arrow.angelforest.engine.animations.DownMotionAnimation;
import jp.arrow.angelforest.engine.animations.LeftMotionAnimation;
import jp.arrow.angelforest.engine.animations.NoMotionAnimation;
import jp.arrow.angelforest.engine.animations.RightMotionAnimation;
import jp.arrow.angelforest.engine.animations.UpMotionAnimation;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.utils.Timer;

/**
 * nomotion ArrayList is required.
 * 
 * @author merabi
 *
 */
public abstract class AbstractCharacter implements IntrCharacter {
	private int status = IntrCharacter.STATUS_ALIVE;
	
	protected CharacterParameters param;
	
	private NoMotionAnimation nomotion;
	private DownMotionAnimation downmotion;
	private UpMotionAnimation upmotion;
	private LeftMotionAnimation leftmotion;
	private RightMotionAnimation rightmotion;
	
	protected AbstractAnimation currentMotion;
	
	/**
	 * nomotiontextureIds is required. otherwise the system will exit.
	 * 
	 * @param nomotiontextureIds
	 * @param downmotiontextureIds
	 * @param upmotiontextureIds
	 * @param leftmotiontextureIds
	 * @param rightmotiontextureIds
	 * @param interval
	 */
	public AbstractCharacter(
			CharacterParameters param
			) {
		this.param = param;
		//no motion animation
		if(param.getTextureParameters().getNomotiontextureIds() != null) {
			nomotion = new NoMotionAnimation(param);
		}
		else {
			System.err.println("**No NOMOTION anime textures defined!**");
			System.exit(1);
		}
		
		//other motion animation
		if(param.getTextureParameters().getDownmotiontextureIds() != null) {
			downmotion = new DownMotionAnimation(param);
		}
		if(param.getTextureParameters().getUpmotiontextureIds() != null) {
			upmotion = new UpMotionAnimation(param);
		}
		if(param.getTextureParameters().getLeftmotiontextureIds() != null) {
			leftmotion = new LeftMotionAnimation(param);
		}
		if(param.getTextureParameters().getRightmotiontextureIds() != null) {
			rightmotion = new RightMotionAnimation(param);
		}
		
		//set default
		currentMotion = nomotion;
	}
	
	//--------------------- Draw methods -------------------------//
	@Override
	public void drawBefore(float x, float y, float w, float h, float angle){
	}
	@Override
	public void drawAfter(float x, float y, float w, float h, float angle){
	}
	
	@Override
	public void drawMiddle(float x, float y, float w, float h, float angle) {
		if(param.getCurrentTime()%param.getBasicParameters().getInterval() == 0) {
			switch(AbstractAnimation.detectMotion(x, y, param.getPrev_x(), param.getPrev_y())) {
			case IntrAnimation.MOTION_DOWN:
				currentMotion = checkMotionDefinedAndAnimate(downmotion);
				break;
			case IntrAnimation.MOTION_RIGHT:
				currentMotion = checkMotionDefinedAndAnimate(rightmotion);
				break;
			case IntrAnimation.MOTION_LEFT:
				currentMotion = checkMotionDefinedAndAnimate(leftmotion);
				break;
			case IntrAnimation.MOTION_UP:
				currentMotion = checkMotionDefinedAndAnimate(upmotion);
				break;
			default:
				currentMotion = checkMotionDefinedAndAnimate(nomotion);
			}
//			Log.e(null, "x: " + x + ", y: " + y + "prev_x: " + prev_x + ", prev_y: " + prev_y);
			//save prev location
			param.setPrev_x(x);
			param.setPrev_y(y);
		}
		
		currentMotion.animate(x, y, w, h, angle);
	}
	
	/**
	 * check if each motion is defined.
	 * if not, then nomotion will be selected.
	 * 
	 * @param anime
	 * @return
	 */
	private AbstractAnimation checkMotionDefinedAndAnimate(AbstractAnimation anime) {
		if(anime != null) {
			return anime;
		}
		return nomotion;
	}
	
	@Override
	public void draw(float x, float y, float w, float h, float angle) {
		//check for deleted
		if(isDeleted()) {
			return ;
		}
		
		drawBefore(x, y, w, h, angle);
		
		drawMiddle(x, y, w, h, angle);
		
		drawAfter(x, y, w, h, angle);
	}
	
	
	//------------------------- Death methods -----------------------//
	@Override
	public void delete() {
		if(isDeleted()) {
			return ;
		}
		
		status = IntrCharacter.STATUS_DEAD;
		
		//nomotion
		nomotion.delete();
		
		if(downmotion != null) {
			downmotion.delete();
		}
		if(upmotion != null) {
			upmotion.delete();
		}
		if(leftmotion != null) {
			leftmotion.delete();
		}
		if(rightmotion != null) {
			rightmotion.delete();
		}
	}
	
	@Override
	public boolean isDeleted() {
		if(status == IntrCharacter.STATUS_DEAD) {
			return true;
		}
		return false;
	}
	
	//------------------------- reset param with new param -------------------------//
	@Override
	public void resetParameter(CharacterParameters characterParameters) {
		param = characterParameters;
	}
	
	@Override
	public CharacterParameters getParameter() {
		return param;
	}
	
	//----------------------- getters and setters (for ease of use) -----------------------------------//
	public int getStatus() {
		return status;
	}

	public float getX() {
		return param.getBasicParameters().getX();
	}
	public void setX(float x) {
		param.getBasicParameters().setX(x);
	}

	public float getY() {
		return param.getBasicParameters().getY();
	}
	public void setY(float y) {
		param.getBasicParameters().setY(y);
	}
	
	public float getAngle() {
		return param.getBasicParameters().getAngle();
	}
	public void setAngle(float angle) {
		param.getBasicParameters().setAngle(angle);
	}
}
