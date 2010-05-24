package jp.arrow.angelforest.view;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractGameView;
import jp.arrow.angelforest.engine.characters.JikiCharacter;
import jp.arrow.angelforest.engine.param.CharacterParameters;
import jp.arrow.angelforest.engine.param.SystemParameters;
import jp.arrow.angelforest.engine.tasks.JikiBulletTask;
import jp.arrow.angelforest.main.R;
import android.view.MotionEvent;

public class MainGameView extends AbstractGameView {
	private static final int MAINGAMEVIEW_WAITTIME = 30;
	private int offsetX;
	private int offsetY;
	
	JikiCharacter jiki;
	JikiBulletTask jikiBulletTask;
	
	public MainGameView() {
		super();
		
		ArrayList<Integer> textures = new ArrayList<Integer>();
		textures.add(R.drawable.sinderella01);
		textures.add(R.drawable.sinderella02);
		CharacterParameters param = new CharacterParameters(textures, null, null, null, null, 10, 10, 15, 0, 0);
		param.setX(320/2);
		param.setY(450);
		jiki = new JikiCharacter(param);
		
		jikiBulletTask = new JikiBulletTask(jiki);
	}

	int angle = 0;
	@Override
	protected void drawMiddle() {
		jiki.draw(jiki.getX(), jiki.getY(), 1, 1, angle++);
		
		jikiBulletTask.doTask();
	}

	@Override
	public boolean keyPressedEvent(MotionEvent event) {
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (jiki != null && event.getAction() == MotionEvent.ACTION_DOWN) {
			offsetX = (int)event.getX() - jiki.getX();
			offsetY = (int)event.getY() - jiki.getY();

		} else if (jiki != null && event.getAction() == MotionEvent.ACTION_MOVE) {
			// x < 0
			float x = event.getX() - offsetX;
			if (x < 0) {
				jiki.setX(0);
			}
			// x > screen width
			else if ((int) x > SystemParameters.SCREEN_WIDTH) {
				jiki.setX(SystemParameters.SCREEN_WIDTH);
			} else {
				jiki.setX((int)x);
			}

			// y < 0
			float y = event.getY() - offsetY;
			if (y < 0) {
				jiki.setY(0);
			}
			// y > screen width
			else if ((int)y > SystemParameters.SCREEN_HEIGHT) {
				jiki.setY(SystemParameters.SCREEN_HEIGHT);
			} else {
				jiki.setY((int)y);
			}
		}
		
		//wait otherwisze it will output gc.
		try {
			Thread.sleep(MAINGAMEVIEW_WAITTIME);
		} catch (InterruptedException e) {
			e.printStackTrace(System.err);
			e.printStackTrace();
		}
		return true;
	}

}
