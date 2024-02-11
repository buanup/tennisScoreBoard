package com.tennisscoreboard.application.utils;

public class ScoreUtils {
	
	public static void isCurrentGameWonByPlayer1(int currentGamePlayer1, int currentGamePlayer2, int currentSetPlayer1) {
		currentSetPlayer1++;
		currentGamePlayer1 = 0;
		currentGamePlayer2 = 0;
	}

}
