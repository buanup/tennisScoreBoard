package com.tennisscoreboard.application;

import java.util.ArrayList;
import java.util.List;

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
