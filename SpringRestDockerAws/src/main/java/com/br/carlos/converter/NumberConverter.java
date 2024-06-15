package com.br.carlos.converter;

import java.io.Serializable;

public class NumberConverter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Double converteNumber(String strNumber) {

		if (strNumber == null)
			return (Double) 0D;

		String number = strNumber.replaceAll(",", ".");
		if (isnumerico(strNumber))
			return (Double) Double.parseDouble(number);
		return (Double) 0D;
	}

	public static boolean isnumerico(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}
	
	

}
