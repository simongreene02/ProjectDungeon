package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BetterRandomTest {
	
	private BetterRandom random;

	@Before
	public void setUp() throws Exception {
		random = new BetterRandom(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void randInt_sixAndFive_error() {
		random.randInt(6, 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void randInt_negativeNumber_error() {
		random.randInt(-1, 5);
	}
	
	@Test
	public void randInt_fiveAndSix_5() {
		assertEquals(5, random.randInt(5, 6));
	}

}
