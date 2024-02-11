package com.tennisscoreboard.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ScoreBoardTest {

	private static final String PATH_PREFIX = "src/test/resources";

	@Test
	public void HappyFlowTest() throws IOException {
		String inputFile = PATH_PREFIX + "/inputFiles/Input.txt";
		String outputFile = PATH_PREFIX + "/outputFiles/Output.txt";
		String ExpectedOutputFile = PATH_PREFIX + "/outputFiles/ExpectedOutput.txt";
		ScoreBoard sc = new ScoreBoard();
		sc.displayTennisScore(inputFile, outputFile);
		testFileContents(ExpectedOutputFile, outputFile);
	}

	@Test
	public void getCorrespondingCallTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			ScoreBoard.getCorrespondingCall(5);
		});
	}

	private void testFileContents(String expectedFilePath, String actualFilePath) throws IOException {

		String expectedContent = readFileContent(expectedFilePath);
		String actualContent = readFileContent(actualFilePath);

		assertEquals(expectedContent, actualContent, "File contents are not same");
	}

	private String readFileContent(String filePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
		}
		return content.toString();
	}

}
