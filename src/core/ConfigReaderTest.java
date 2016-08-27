package core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConfigReaderTest {

	private ConfigReader reader;
	@Before
	public void setUp() throws Exception {
		reader = ConfigReader.init();
	}

	@Test
	public void randomSeed() {
		assertEquals(1, reader.getRandomSeed());
	}

	@Test
	public void floor() {
		assertEquals(2, reader.getFloor());
	}
}
