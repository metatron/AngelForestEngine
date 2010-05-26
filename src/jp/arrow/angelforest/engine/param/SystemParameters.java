package jp.arrow.angelforest.engine.param;

import java.util.ArrayList;

import jp.arrow.angelforest.engine.abstructclass.AbstractBullet;
import jp.arrow.angelforest.engine.characters.LiveCharacter;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class SystemParameters {
	public static final int SCREEN_HEIGHT = 480;
	public static final int SCREEN_WIDTH = 320;
	public static int realScreenHeight;
	public static int realScreenWidth;
	
	public static Context context;
	
	public static ArrayList<AbstractBullet> jikiBullets;
	public static ArrayList<AbstractBullet> enemyBullets;
	public static ArrayList<AbstractBullet> deadBullets;
	
	public static ArrayList<LiveCharacter> enemies;
	
	public static void init(Context context) {
		SystemParameters.context = context;
		// detect actual screen size
		WindowManager wm = (WindowManager) (context
				.getSystemService(Context.WINDOW_SERVICE));
		Display display = wm.getDefaultDisplay();
		realScreenWidth = display.getWidth();
		realScreenHeight = display.getHeight();
		
		jikiBullets = new ArrayList<AbstractBullet>();
		enemyBullets = new ArrayList<AbstractBullet>();
		enemies = new ArrayList<LiveCharacter>();
	}
}
