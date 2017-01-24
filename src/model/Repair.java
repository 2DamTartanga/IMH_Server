package model;

import java.util.Date;

public class Repair {
	
	private Date finishDate;
	private float timeSpent;
	private boolean isSolved;
	private String difficulty;
	private boolean hasEnoughKnowledge;
	private boolean hasEnoughMaterial;
	private String instructionsFilledUrl;
	
	public Repair(Date finishDate, float timeSpent, boolean isSolved, String difficulty, boolean hasEnoughKnowledge,
			boolean hasEnoughMaterial, String instructionsFilledUrl) {
		this.finishDate = finishDate;
		this.timeSpent = timeSpent;
		this.isSolved = isSolved;
		this.difficulty = difficulty;
		this.hasEnoughKnowledge = hasEnoughKnowledge;
		this.hasEnoughMaterial = hasEnoughMaterial;
		this.instructionsFilledUrl = instructionsFilledUrl;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public float getTimeSpent() {
		return timeSpent;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public boolean isHasEnoughKnowledge() {
		return hasEnoughKnowledge;
	}

	public boolean isHasEnoughMaterial() {
		return hasEnoughMaterial;
	}

	public String getInstructionsFilledUrl() {
		return instructionsFilledUrl;
	}
	
	
}
