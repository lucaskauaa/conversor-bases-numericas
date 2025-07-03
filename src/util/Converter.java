package util;

public class Converter {

	public static String convertDecimalToAnotherBase(String inputNumber, int outputNumberBase) {

		int decimalNumber = convertToInteger(inputNumber);
		String convertedNumber = "";
		String hexadecimalNumber = "";

		int hexadecimalBase = 16;

		if (outputNumberBase != hexadecimalBase) {
			while (decimalNumber >= 1) {
				convertedNumber += convertToString(decimalNumber % outputNumberBase);
				decimalNumber /= outputNumberBase;
			}

		} else {
			while (decimalNumber >= 1) {
				convertedNumber = convertToString(decimalNumber % outputNumberBase);
				hexadecimalNumber += formatOutputHexadecimalNumber(convertedNumber);
				decimalNumber /= outputNumberBase;
			}

			convertedNumber = hexadecimalNumber;
		}

		convertedNumber = reverseString(convertedNumber);

		return convertedNumber;
	}

	public static String convertToDecimal(String inputNumber, int inputNumberBase) {

		int decimalNumber = 0;

		int hexadecimalBase = 16;

		if (inputNumberBase != hexadecimalBase) {

			inputNumber = reverseString(inputNumber);

			String[] listOfDigits = inputNumber.split("");

			for (int i = 0; i < listOfDigits.length; i++) {

				int digit = convertToInteger(listOfDigits[i]);

				decimalNumber += digit * Math.pow(inputNumberBase, i);
			}

			return convertToString(decimalNumber);

		} else {
			return convertHexadecimalToDecimal(inputNumber);
		}
	}

	public static String convertHexadecimalToDecimal(String inputNumber) {
		int[] hexadecimalList = formatInputHexadecimalNumber(inputNumber);

		int decimalNumber = 0;

		int hexadecimalBase = 16;

		int power = 0;
		for (int i = hexadecimalList.length - 1; i >= 0; i--) {

			int digit = hexadecimalList[i];

			decimalNumber += digit * Math.pow(hexadecimalBase, power);
			power++;
		}

		return convertToString(decimalNumber);
	}

	public static int[] formatInputHexadecimalNumber(String inputNumber) {
		String[] hexadecimalDigits = inputNumber.toUpperCase().split("");

		int[] hexadecimalList = new int[hexadecimalDigits.length];
		for (int i = 0; i < hexadecimalList.length; i++) {
			switch (hexadecimalDigits[i]) {
			case "A":
				hexadecimalList[i] = 10;
				break;
			case "B":
				hexadecimalList[i] = 11;
				break;
			case "C":
				hexadecimalList[i] = 12;
				break;
			case "D":
				hexadecimalList[i] = 13;
				break;
			case "E":
				hexadecimalList[i] = 14;
				break;
			case "F":
				hexadecimalList[i] = 15;
				break;
			default:
				hexadecimalList[i] = convertToInteger(hexadecimalDigits[i]);
			}
		}

		return hexadecimalList;
	}

	public static String formatOutputHexadecimalNumber(String inputNumber) {
		switch (inputNumber) {
		case "10":
			return "A";
		case "11":
			return "B";
		case "12":
			return "C";
		case "13":
			return "D";
		case "14":
			return "E";
		case "15":
			return "F";
		case "16":
			return "G";
		default:
			return inputNumber;
		}
	}

	public static int convertToInteger(String text) {
		return Integer.parseInt(text);
	}

	public static String convertToString(int number) {
		return Integer.toString(number);
	}

	public static String reverseString(String text) {
		String invertedText = new StringBuilder(text).reverse().toString();

		return invertedText;
	}

}
