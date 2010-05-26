package jp.arrow.angelforest.engine.utils;

public class Timer {
	private Long current = 0l;

	public Long getCurrent() {
		return current;
	}

	public void tick() {
		current++;
		if (current == Long.MAX_VALUE) {
			reset();
		}
	}

	public void reset() {
		current = 0l;
	}

}
