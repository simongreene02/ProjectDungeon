package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderSimple {
	
	private static ConfigReaderSimple configReader;
	private final long randomSeed;
	private final int floor;
	private ConfigReaderSimple() {
		InputStream inStream = getClass().getResourceAsStream("/config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inStream);
		} catch (IOException e) {
			throw new IllegalStateException("Config loading failed.");
		}
		String seedTxt = properties.getProperty("seed");
		if (seedTxt == null) {
			throw new IllegalStateException("seed value must exist in the /config.properties.");
		}
		String floorTxt = properties.getProperty("floor");
		if (floorTxt == null) {
			throw new IllegalStateException("floor value must exist in the /config.properties.");
		}
		randomSeed = Long.parseLong(seedTxt);
		floor = Integer.parseInt(floorTxt);
	}
	
	
	long getRandomSeed() {
		return randomSeed;
	}


	int getFloor() {
		return floor;
	}


	public static ConfigReaderSimple init() {
		if (configReader == null) {
			configReader = new ConfigReaderSimple();
		}
		return configReader;
	}
	
}
