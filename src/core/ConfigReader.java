package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static ConfigReader configReader;
	private final Properties properties = new Properties();
	private ConfigReader() {
		InputStream inStream = getClass().getResourceAsStream("/config.properties");
		try {
			properties.load(inStream);
		} catch (IOException e) {
			throw new IllegalStateException("Config loading failed.");
		}
	
	}
	
	
	long getRandomSeed() {
		return Long.parseLong(properties.getProperty("seed", "0"));
	}


	int getFloor() {
		return Integer.parseInt(properties.getProperty("floor", "1"));
	}


	public static ConfigReader init() {
		if (configReader == null) {
			configReader = new ConfigReader();
		}
		return configReader;
	}
	
}
