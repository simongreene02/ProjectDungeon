package util;

import java.util.Random;

public class BetterRandom {
	private Random random;
	public BetterRandom() {
		random = new Random();
	}
	
	public BetterRandom(long seed) {
		random = new Random(seed);
	}
	
	/**
	 * 
	 * @param minimumValue The smallest possible random value (inclusive).
	 * @param maximumValue The largest possible random value (exclusive).
	 * @return
	 */
	public int randInt(int minimumValue, int maximumValue) {
		if (maximumValue <= minimumValue) {
			//"The maximum value (" + maximumValue + ") must be greater than the minimum value (" + minimumValue + ")."
			throw new IllegalArgumentException(String.format("The maximum value (%s) must be greater than the minimum value (%s).", 
					maximumValue, minimumValue));
		}
		if (minimumValue < 0) {
			//"The maximum value (" + maximumValue + ") must be greater than the minimum value (" + minimumValue + ")."
			throw new IllegalArgumentException(String.format("The minimum value (%s) must be greater than zero.", 
					minimumValue));
		}
		return random.nextInt(maximumValue - minimumValue) + minimumValue;
	}
}
