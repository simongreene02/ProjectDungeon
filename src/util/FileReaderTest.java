package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

	private FileReader fileReader;
	@Before
	public void setUp() throws Exception {
		fileReader = new FileReader();
	}

	@Test
	public void readFile() {
		assertEquals(18, fileReader.readFile().size());
	}
	
	@Test
	public void convert_10() {
		assertEquals(10, fileReader.convert("W,,D,,W,,,W,W,W").length);
	}
	
	@Test
	public void convert_emptyComma() {
		assertEquals(10, fileReader.convert("W,,D,,W,,,W,W,").length);
	}
	
	@Test
	public void convert_emptyCommaBeginning() {
		assertEquals(10, fileReader.convert(",,D,,W,,,W,W,").length);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void convert_null() {
		fileReader.convert(null);
	}
	
	@Test
	public void convert_empty() {
		assertEquals(1, fileReader.convert("").length);
	}
	
	@Test
	public void convert_singleCharacter() {
		assertEquals(1, fileReader.convert("E").length);
	}

}
