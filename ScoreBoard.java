package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

	private static final String SCORE_A = "A";
	private static final String SCORE_B = "B";

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Please provide input and output file names.");
			System.exit(1);
		}

		ScoreBoard sc = new ScoreBoard();
		sc.displayTennisScore(args[0], args[1]);
	}

	void displayTennisScore(String inputFile, String outputFile) {

		System.out.println("Input file: " + inputFile);
		System.out.println("Output file: " + outputFile);

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

			String line;

			while ((line = reader.readLine()) != null) {
				String[] scores = line.split("");

				Player a = new Player();
				Player b = new Player();
				Player server;
				Player receiver;
				int currentGameA = 0;
				int currentGameB = 0;
				int currentSetA = 0;
				int currentSetB = 0;
				boolean isServerA = true;

				for (int i = 0; i < scores.length; i++) {
					String score = scores[i];
					if (score.equals(SCORE_A)) {
						currentGameA++;
					} else if (score.equals(SCORE_B)) {
						currentGameB++;
					}
					if (currentGameA >= 4 && currentGameA - currentGameB >= 2) {
						currentSetA++;
						currentGameA = 0;
						currentGameB = 0;
					} else if (currentGameB >= 4 && currentGameB - currentGameA >= 2) {
						currentSetB++;
						currentGameA = 0;
						currentGameB = 0;
					}
					if (currentGameA == 4 && currentGameB == 4) {
						currentGameA--;
						currentGameB--;
					}
					if (currentSetA > 5 && currentSetA - currentSetB >= 2) {
						a.getCompletedSet().add(currentSetA);
						b.getCompletedSet().add(currentSetB);
						currentGameA = 0;
						currentGameB = 0;
						currentSetA = 0;
						currentSetB = 0;
					}
					if (currentSetB > 5 && currentSetB - currentSetA >= 2) {
						a.getCompletedSet().add(currentSetA);
						b.getCompletedSet().add(currentSetB);
						currentGameA = 0;
						currentGameB = 0;
						currentSetA = 0;
						currentSetB = 0;
					}
					if (currentGameA == 0 && currentGameB == 0) {
						isServerA = !isServerA;
					}
				}

				a.setCurrentSet(currentSetA);
				b.setCurrentSet(currentSetB);
				a.setCurrentScore(currentGameA);
				b.setCurrentScore(currentGameB);

				if (isServerA) {
					server = a;
					receiver = b;
				} else {
					server = b;
					receiver = a;
				}

				StringBuffer outputBuffer = new StringBuffer();

				for (int i = 0; i < a.getCompletedSet().size(); i++) {
					outputBuffer.append(server.getCompletedSet().get(i));
					outputBuffer.append("-");
					outputBuffer.append(receiver.getCompletedSet().get(i));
					outputBuffer.append(" ");
				}
				outputBuffer.append(server.getCurrentSet());
				outputBuffer.append("-");
				outputBuffer.append(receiver.getCurrentSet());

				if (!(currentGameA == 0 && currentGameB == 0)) {
					outputBuffer.append(" ");
					outputBuffer.append(getCorrespondingCall(server.getCurrentScore()));
					outputBuffer.append("-");
					outputBuffer.append(getCorrespondingCall(receiver.getCurrentScore()));
				}

				writer.println(outputBuffer.toString().trim());
				System.out.println(outputBuffer.toString().trim());
			}

		} catch (FileNotFoundException ex) {
			System.err.println("File Not Found. Please provide absolute file path.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println("IOException Occured :");
			ex.printStackTrace();
		}

	}

	private static String getCorrespondingCall(int points) {

		return switch (points) {
		case 0 -> "0";
		case 1 -> "15";
		case 2 -> "30";
		case 3 -> "40";
		case 4 -> "A";
		default -> throw new IllegalArgumentException("Unexpected value: " + points);
		};
	}

}
class Player {

	private int currentScore;
	private int currentSet;
	private List<Integer> completedSet;

	public Player() {
		super();
		this.completedSet = new ArrayList<Integer>();
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getCurrentSet() {
		return currentSet;
	}

	public void setCurrentSet(int currentSet) {
		this.currentSet = currentSet;
	}

	public List<Integer> getCompletedSet() {
		return completedSet;
	}

	public void setCompletedSet(List<Integer> completedSet) {
		this.completedSet = completedSet;
	}

}


