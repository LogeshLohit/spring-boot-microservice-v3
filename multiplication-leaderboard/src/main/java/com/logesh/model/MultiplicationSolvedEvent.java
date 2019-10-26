package com.logesh.model;

public class MultiplicationSolvedEvent {

	private int attemptId;
	private String userId;
	private int multiplicationId;
	private boolean isCorrect;

	public MultiplicationSolvedEvent() {
		// TODO Auto-generated constructor stub
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMultiplicationId() {
		return multiplicationId;
	}

	public void setMultiplicationId(int multiplicationId) {
		this.multiplicationId = multiplicationId;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "MultiplicationSolvedEvent [attemptId=" + attemptId + ", userId=" + userId + ", multiplicationId="
				+ multiplicationId + ", isCorrect=" + isCorrect + "]";
	}

}
