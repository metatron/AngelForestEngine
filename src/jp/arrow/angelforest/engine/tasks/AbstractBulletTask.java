package jp.arrow.angelforest.engine.tasks;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.abstructclass.IntrTask;
import jp.arrow.angelforest.engine.param.SystemParameters;

public abstract class AbstractBulletTask implements IntrTask {
	private ArrayList<AbstractBullet> bulletList;
	
	public AbstractBulletTask(ArrayList<AbstractBullet> bulletList) {
		this.bulletList = bulletList;
	}

	@Override
	public synchronized void doTask() {
		//generaetae buletif it is necessary
		generateBullet();
		
		//for each bullets do collision test and draw.
		for(int i=0; i<bulletList.size(); i++) {
			AbstractBullet bullet = bulletList.get(i);
			
			//check for death (collision detection)
			
			//check for death (inside the screen)
			checkInsideScreen(bullet, i);
			
			//check for movement
			bullet.draw(bullet.getX(), bullet.getY(), 1.0f, 1.0f, bullet.getParameter().getAngle());
		}
	}
	
	/**
	 * create bullets using LiveCharacter's bulletParameters.
	 * 
	 */
	protected abstract void generateBullet();
	
	/**
	 * check for inside of the screen
	 * delete the bullet and removes from the list.
	 * 
	 * @param bullet
	 */
	private synchronized void checkInsideScreen(AbstractBullet bullet, int index) {
		if(!(bullet.getX() <= SystemParameters.SCREEN_WIDTH && 
				bullet.getX() >= 0 &&
				bullet.getY() <= SystemParameters.SCREEN_HEIGHT &&
				bullet.getY() >= 0)) {
			bullet.delete();
			bulletList.remove(index);
		}
	}
}
