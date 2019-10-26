package com.logesh.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MultiplicationResultAttemptDeserializer.class)
public class MultiplicationResultAttempt {

	private String userName;

	private int multiplicationId;

	private int userValue;

	public MultiplicationResultAttempt() {
	}

	public MultiplicationResultAttempt(String userName, int userValue, int multiplicationId) {
		super();
		this.userName = userName;
		this.userValue = userValue;
		this.multiplicationId = multiplicationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserValue() {
		return userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	public int getMultiplicationId() {
		return multiplicationId;
	}

	public void setMultiplicationId(int multiplicationId) {
		this.multiplicationId = multiplicationId;
	}

	@Override
	public String toString() {
		return "MultiplicationResultAttempt [userName=" + userName + ", multiplicationId=" + multiplicationId
				+ ", userValue=" + userValue + "]";
	}

}
