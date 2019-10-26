package com.logesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "multiplication_generator")
public class MultiplicationGenerator {
	@Id
	@Column(name = "multiplication_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int multiplicationId;
	private int factorA;
	private int factorB;
	private int result;

	public MultiplicationGenerator() {

	}

	public MultiplicationGenerator(int factorA, int factorB, int result) {
		super();
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = result;
	}

	public int getMultiplicationId() {
		return multiplicationId;
	}

	public void setMultiplicationId(int multiplicationId) {
		this.multiplicationId = multiplicationId;
	}

	public int getFactorA() {
		return factorA;
	}

	public void setFactorA(int factorA) {
		this.factorA = factorA;
	}

	public int getFactorB() {
		return factorB;
	}

	public void setFactorB(int factorB) {
		this.factorB = factorB;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "MultiplicationGenerator [multiplicationId=" + multiplicationId + ", factorA=" + factorA + ", factorB="
				+ factorB + ", result=" + result + "]";
	}

}
