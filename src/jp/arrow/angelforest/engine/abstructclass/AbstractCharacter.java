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
	
	protected CharacterParameters charParam;
	
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
			CharacterParameters charParam
			) {
		this.charParam = charParam;
		//no motion animation
		if(charParam.getTextureParameters().getNomotiontextureIds() != null) {
			nomotion = new NoMotionAnimation(charParam);
		}
		else {
			System.err.println("**No NOMOTION anime textures defined!**");
			System.exit(1);
		}
		
		//other motion animation
		if(charParam.getTextureParameters().getDownmotiontextureIds() != null) {
			downmotion = new DownMotionAnimation(charParam);
		}
		if(charParam.getTextureParameters().getUpmotiontextureIds() != null) {
			upmotion = new UpMotionAnimation(charParam);
		}
		if(charParam.getTextureParameters().getLeftmotiontextureIds() != null) {
			leftmotion = new LeftMotionAnimation(charParam);
		}
		if(charParam.getTextureParameters().getRightmotiontextureIds() != null) {
			rightmotion = new RightMotionAnimation(charParam);
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
		if(charParam.getCurrentTime()%charParam.getBasicParameters().getInterval() == 0) {
			switch(AbstractAnimation.detectMotion(x, y, charParam.getPrev_x(), charParam.getPrev_y())) {
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
			charParam.setPrev_x(x);
			charParam.setPrev_y(y);
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
		
		drawMiddle(getX(), getY(), w, h, angle);
		
		drawAfter(getX(), getY(), w, h, angle);
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
		charParam = characterParameters;
	}
	
	@Override
	public CharacterParameters getParameter() {
		return charParam;
	}
	
	//----------------------- getters and setters (for ease of use) -----------------------------------//
	public int getStatus() {
		return status;
	}

	public float getX() {
		return charParam.getBasicParameters().getX();
	}
	public void setX(float x) {
		charParam.getBasicParameters().setX(x);
	}

	public float getY() {
		return charParam.getBasicParameters().getY();
	}
	public void setY(float y) {
		charParam.getBasicParameters().setY(y);
	}
	
	public float getAngle() {
		return charParam.getBasicParameters().getAngle();
	}
	public void setAngle(float angle) {
		charParam.getBasicParameters().setAngle(angle);
	}
	
	public float getSpeed() {
		return charParam.getBasicParameters().getSpeed();
	}
	public void setSpeed(float speed) {
		charParam.getBasicParameters().setSpeed(speed);
	}
}
