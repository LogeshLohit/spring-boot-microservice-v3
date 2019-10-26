package com.logesh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attempt")
public class Attempt {
	@Id
	@Column(name = "attempt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attemptId;
	@Column(name = "user_value")
	private int userValue;
	@Column(name = "is_correct")
	private boolean isCorrect;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "multiplication_id")
	private MultiplicationGenerator multiplicationTask;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User users;

	public MultiplicationGenerator getMultiplicationTask() {
		return multiplicationTask;
	}

	public void setMultiplicationTask(MultiplicationGenerator multiplicationTask) {
		this.multiplicationTask = multiplicationTask;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Attempt() {

	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public int getUserValue() {
		return userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Attempt [attemptId=" + attemptId + ", userValue=" + userValue + ", isCorrect=" + isCorrect + "]";
	}

	public Attempt(int userValue, boolean isCorrect) {
		super();
		this.userValue = userValue;
		this.isCorrect = isCorrect;
	}

}
