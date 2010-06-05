package jp.arrow.angelforest.engine.param;

public class BasicParameters {
	private float hit_r;
	private int dmg;
	private int original_hp;
	private int hp;
	
	private float x;
	private float y;
	private float speed;
	private float angle;
	private int interval;
	private float angle_rate;
	private float speed_accelerate;
	private float angle_accelerate;
	
	private float original_angle;
	private float original_speed_accelerate;
	private float original_angle_accelerate;
	private float original_speed;
	private int original_interval;
	
	private float max_angle;
	private float max_speed;

	
	
	public BasicParameters(float x, float y, float speed, float hitR, int dmg, int hp, 
			 float angle, int interval, float angleRate, float angleAccelerate, float maxAngle, 
			float speedAccelerate, float maxSpeed) {
		
		hit_r = hitR;
		this.dmg = dmg;
		this.hp = hp;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angle = angle;
		this.interval = interval;
		angle_rate = angleRate;
		speed_accelerate = speedAccelerate;
		angle_accelerate = angleAccelerate;
		
		//set originals
		original_angle = angle;
		original_speed_accelerate = speedAccelerate;
		original_angle_accelerate = angleAccelerate;
		original_speed = speed;
		original_interval = interval;
		
		max_angle = maxAngle;
		max_speed = maxSpeed;
	}
	
	public float getHit_r() {
		return hit_r;
	}
	public void setHit_r(float hitR) {
		hit_r = hitR;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
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
	public float getAngle_rate() {
		return angle_rate;
	}
	public void setAngle_rate(float angleRate) {
		angle_rate = angleRate;
	}
	public float getSpeed_accelerate() {
		return speed_accelerate;
	}
	public void setSpeed_accelerate(float speedAccelerate) {
		speed_accelerate = speedAccelerate;
	}
	public float getAngle_accelerate() {
		return angle_accelerate;
	}
	public void setAngle_accelerate(float angleAccelerate) {
		angle_accelerate = angleAccelerate;
	}
	public int getOriginal_hp() {
		return original_hp;
	}
	public float getOriginal_angle() {
		return original_angle;
	}
	public float getOriginal_speed_accelerate() {
		return original_speed_accelerate;
	}
	public float getOriginal_angle_accelerate() {
		return original_angle_accelerate;
	}
	public float getOriginal_speed() {
		return original_speed;
	}
	public int getInterval() {
		return interval;
	}
	public int getOriginal_interval() {
		return original_interval;
	}

	public float getMax_angle() {
		return max_angle;
	}

	public float getMax_speed() {
		return max_speed;
	}

	
}
