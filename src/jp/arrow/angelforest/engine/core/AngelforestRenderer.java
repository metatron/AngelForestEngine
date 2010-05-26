package jp.arrow.angelforest.engine.core;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import jp.arrow.angelforest.engine.abstructclass.AbstractGameView;
import jp.arrow.angelforest.engine.param.SystemParameters;
import jp.arrow.angelforest.view.MainGameView;
import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

public class AngelforestRenderer implements Renderer {
	public static AbstractGameView currentView;
	
	public AngelforestRenderer(Context context) {
		SystemParameters.init(context);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglconf) {
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		AngelForest2DEngine.init(gl, width, height);
		currentView = new MainGameView();
		System.gc();
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		currentView.draw();
		
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		return currentView.onTouchEvent(event);
	}
}
