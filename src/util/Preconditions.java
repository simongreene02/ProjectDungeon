package util;

public class Preconditions {
	public static int checkGreaterThanZero(int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Value is not allowed to be less than or equal to zero");
		}
		return value;
	}
	
	public static int checkGreaterThanEqualToZero(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value is not allowed to be less than zero");
		}
		return value;
	}
	
	public static int checkLessThanEqualToValue(int input, int value) {
		if (input > value) {
			throw new IllegalArgumentException("Input is not allowed to be greater than value");
		}
		return input;
	}
}
