package br.com.paulo.utils;

import br.com.paulo.exceptions.UnsupportedMathOperationException;

public class Utils {
	public static void checkNumbers(String numberOne, String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	}
	
	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		//BR 10,25 ; US 10.25
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
			
		return 0D;
	}	
}
