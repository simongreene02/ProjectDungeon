package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
	public List<String> readFile() {
		try {
			return Files.readAllLines(Paths.get(getClass().getResource("/data/floor1Data.csv").toURI()));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * Converts the input string into an array of Strings
	 * <pre>
	 * W,,D,,W,,,W,W,W
	 * </pre>
	 * That creates 10 length array of strings. 
	 * @param input
	 * @return Array of Strings
	 */
	String[] convert(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Do not enter a null value as an input");
		}
		if (input.endsWith(",")) {
			input += " ";
		}
		return input.split(",");
	}
	
	public String[][] createFloor(List<String> floor) {
		String [][] result = new String[floor.size()][];
		for (int i = 0; i < floor.size(); i++) {
			result[i] = convert(floor.get(i));
		}
		return result;
	}
}
