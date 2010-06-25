package jp.arrow.angelforest.engine.tasks;

import java.util.ArrayList;

import android.util.Log;

import jp.arrow.angelforest.engine.characters.JikiCharacter;
import jp.arrow.angelforest.engine.param.SystemParameters;
import jp.arrow.angelforest.engine.param.bulletparam.BulletParameters;
import jp.arrow.angelforest.engine.utils.BulletFactory;

public class JikiBulletTask extends AbstractBulletTask {
	private JikiCharacter jiki;
	
	public JikiBulletTask(JikiCharacter jiki) {
		super(SystemParameters.jikiBullets);
		this.jiki = jiki;
	}

	@Override
	protected void generateBullet() {
		ArrayList<BulletParameters> genedBulletParams = jiki.createOriginalBulletParameters();
//		Log.e(null, "genedBulletParam size: " + genedBulletParams.size() + ", jikibulletArray size: " + SystemParameters.jikiBullets.size());
		if(genedBulletParams.size() > 0) {
			SystemParameters.jikiBullets.addAll(BulletFactory.create(genedBulletParams));
		}
	}
}
