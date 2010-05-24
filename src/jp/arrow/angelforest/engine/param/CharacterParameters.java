package jp.arrow.angelforest.engine.param;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.utils.Timer;

public class CharacterParameters {
	private ArrayList<Integer> nomotiontextureIds;
	private ArrayList<Integer> downmotiontextureIds; 
	private ArrayList<Integer> upmotiontextureIds; 
	private ArrayList<Integer> leftmotiontextureIds; 
	private ArrayList<Integer> rightmotiontextureIds; 
	private int interval;
	private int x;
	private int originalx;
	private int y;
	private int originaly;
	private int hp;
	private int originalhp;
	private int power;
	private int originalpower;
	
	private float speed;
	private float originalspeed;
	private float angle;
	private float originalangle;
	
	private int prev_x;
	private int prev_y;
	
	private Timer timer;
	
	public CharacterParameters(
			ArrayList<Integer> nomotiontextureIds,
			ArrayList<Integer> downmotiontextureIds,
			ArrayList<Integer> upmotiontextureIds,
			ArrayList<Integer> leftmotiontextureIds,
			ArrayList<Integer> rightmotiontextureIds, 
			int hp, 
			int power, 
			int interval,
			float speed,
			float angle
			) {
		this.nomotiontextureIds = nomotiontextureIds;
		this.downmotiontextureIds = downmotiontextureIds;
		this.upmotiontextureIds = upmotiontextureIds;
		this.leftmotiontextureIds = leftmotiontextureIds;
		this.rightmotiontextureIds = rightmotiontextureIds;
		this.hp = hp;
		this.power = power;
		this.interval = interval;
		this.speed = speed;
		this.angle = angle;
		
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

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getOriginalx() {
		return originalx;
	}

	public int getOriginaly() {
		return originaly;
	}

	public int getOriginalhp() {
		return originalhp;
	}

	public int getOriginalpower() {
		return originalpower;
	}

	public int getPrev_x() {
		return prev_x;
	}

	public void setPrev_x(int prevX) {
		prev_x = prevX;
	}

	public int getPrev_y() {
		return prev_y;
	}

	public void setPrev_y(int prevY) {
		prev_y = prevY;
	}

	public ArrayList<Integer> getNomotiontextureIds() {
		return nomotiontextureIds;
	}

	public ArrayList<Integer> getDownmotiontextureIds() {
		return downmotiontextureIds;
	}

	public ArrayList<Integer> getUpmotiontextureIds() {
		return upmotiontextureIds;
	}

	public ArrayList<Integer> getLeftmotiontextureIds() {
		return leftmotiontextureIds;
	}

	public ArrayList<Integer> getRightmotiontextureIds() {
		return rightmotiontextureIds;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getOriginalspeed() {
		return originalspeed;
	}

	public float getOriginalangle() {
		return originalangle;
	}
	
	
}
