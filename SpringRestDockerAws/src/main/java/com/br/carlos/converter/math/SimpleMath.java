package com.br.carlos.converter.math;

import java.io.Serializable;

public class SimpleMath implements Serializable {

	private static final long serialVersionUID = 1L;

	public Double sum(Double numberOne, Double numberTwo) {
		return (double) (numberOne + numberTwo);
	}

	public Double substrat(Double numberOne, Double numberTwo) {
		return (double) (numberOne - numberTwo);
	}

	public Double multiplication(Double numberOne, Double numberTwo) {
		return (double) (numberOne * numberTwo);
	}

	public Double division(Double numberOne, Double numberTwo) {
		return (double) (numberOne / numberTwo);
	}

	public Double media(Double numberOne, Double numberTwo) {
		return (double) (numberOne + numberTwo) / 2;
	}

	public Double square(Double numbersquare) {
		return Math.sqrt(numbersquare);
	}

}
