package jp.arrow.angelforest.engine.abstructclass;

import jp.arrow.angelforest.engine.core.AngelForest2DEngine;
import jp.arrow.angelforest.engine.core.SquarePolygon;
import jp.arrow.angelforest.engine.param.SystemParameters;

public abstract class AbstractGameView implements IntrGameView {
	protected boolean isInited = false;
	protected boolean isDeleted;

	// for covering right side and bottom of the screen
	protected SquarePolygon bottomsqr;
	protected SquarePolygon rightsqr;
	
	protected AbstractGameView() {
		if (!isInited) {
			init();
			isInited = true;
		}
		this.isDeleted = false;
	}

	@Override
	public void init() {
		// init screen covers
		detectActualScrnSize();
	}
	
	private void detectActualScrnSize() {
		// set color
		final int one = AngelForest2DEngine.one;
		final int[] black_bottm = { 
				one / 2, 0, 0, one, // letf top
				0, 0, 0, one, // left bottom
				one / 2, 0, 0, one, // right top
				0, 0, 0, one // right bottom
		};
		final int[] black_right = { one, 0, 0, one, // letf top
				one / 2, 0, 0, one, // left bottom
				one, 0, 0, one, // right top
				one / 2, 0, 0, one // right bottom
		};

		final int[] panelVertices = new int[] { 
				0, 0, 0,// letf top
				0, -one, 0,// left bottom
				one, 0, 0,// right top
				one, -one, 0 // right bottom
			};

		// init squares
		bottomsqr = new SquarePolygon(panelVertices, black_bottm);
		rightsqr = new SquarePolygon(panelVertices, black_right);
	}

	@Override
	public void delete() {
		isDeleted = true;
	}

	@Override
	public boolean isDeleted() {
		return isDeleted;
	}
	
	//--------------------- Draw related functions -------------------------------//

	protected void drawBefore(){}
	protected void drawAfter(){}
	protected abstract void drawMiddle();
	
	@Override
	public void draw() {
		//do something before drawing
		drawBefore();
		
		//draw characters, bg, etc.
		drawMiddle();
		
		//do something after drawing
		drawAfter();
		
		//cover up the rest of the screen
		fillScreen();
	}
	
	/**
	 * cover all the extra space on screen with gradient boxes.
	 * 
	 */
	protected void fillScreen() {
		// bottom square
		// square width is actually 1*screenwidth.
		// square height is actually 1*screenheight-480.
		if (SystemParameters.realScreenHeight - SystemParameters.SCREEN_HEIGHT > 0) {
			bottomsqr.draw(0, SystemParameters.SCREEN_HEIGHT, SystemParameters.realScreenWidth,
					SystemParameters.realScreenHeight - SystemParameters.SCREEN_HEIGHT, 0);
		}

		// rightside square
		// square width is actually 1*320-screenwidth.
		// square height is actually 1*screenheight.
		if (SystemParameters.realScreenWidth - SystemParameters.SCREEN_WIDTH > 0) {
			rightsqr.draw(SystemParameters.SCREEN_WIDTH, 0, SystemParameters.realScreenWidth - SystemParameters.SCREEN_WIDTH,
					SystemParameters.SCREEN_HEIGHT, 0);
		}
	}
}
