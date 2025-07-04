package util;

public class Converter {
	private static final int DECIMAL_BASE = 10;
	private static final int BINARY_BASE = 2;
	private static final int OCTAL_BASE = 8;
	private static final int HEXADECIMAL_BASE = 16;

	public static void convert(String inputNumber, int inputNumberBase) {

		String decimal = "", binary = "", octal = "", hexadecimal = "";
		
		switch (inputNumberBase) {
		case DECIMAL_BASE:
			decimal = inputNumber;
			break;
		case BINARY_BASE:
			decimal = convertToDecimal(inputNumber, BINARY_BASE);
			break;
		case OCTAL_BASE:
			decimal = convertToDecimal(inputNumber, OCTAL_BASE);
			break;
		case HEXADECIMAL_BASE:
			decimal = convertToDecimal(inputNumber, HEXADECIMAL_BASE);
			break;
		}
		
		binary = convertDecimalToAnotherBase(decimal, BINARY_BASE);
		octal = convertDecimalToAnotherBase(decimal, OCTAL_BASE);
		hexadecimal = convertDecimalToAnotherBase(decimal, HEXADECIMAL_BASE);

		System.out.println("");
		System.out.println("Número inserido: " + inputNumber + " base " + inputNumberBase);
		System.out.println("");
		System.out.println("Resultado da conversão:");
		System.out.println("Decimal: " + decimal);
		System.out.println("Binário: " + binary);
		System.out.println("Octal: " + octal);
		System.out.println("Hexadecimal: " + hexadecimal);
	}

	public static boolean validateInputNumber(String inputNumber, int inputNumberBase) {

		if (inputNumberBase == BINARY_BASE && !inputNumber.matches("[01]+")) {
			System.out.println("Insira um número binário válido!");
			System.out.println("Números binários só contém valores 0s e 1s.");
			System.out.println("");
			return true;
			
		} else if (inputNumberBase == OCTAL_BASE && !inputNumber.matches("[01234567]+")) {
			System.out.println("Insira um número octal válido!");
			System.out.println("Números octais só contém valores de 0 a 7.");
			System.out.println("");
			return true;
			
		} else if (inputNumberBase == DECIMAL_BASE && !inputNumber.matches("[0123456789]+")) {
			System.out.println("Insira um número decimal válido!");
			System.out.println("Números decimais só contém valores de 0 a 9.");
			System.out.println("");
			return true;
			
		} else if (inputNumberBase == HEXADECIMAL_BASE && !inputNumber.matches("[0123456789ABCDEF]+")) {
			System.out.println("Insira um número hexadecimal válido!");
			System.out.println("Números hexadecimais só contém valores de 0 a 9 e A - F.");
			System.out.println("");
			return true;
		}
			
		return false;
	}

	public static boolean validateInputNumberBase(int inputNumberBase) {

		if (inputNumberBase != BINARY_BASE && inputNumberBase != OCTAL_BASE && inputNumberBase != DECIMAL_BASE & inputNumberBase != HEXADECIMAL_BASE) {
			System.out.println("Base numérica inválida!");
			System.out.println("Selecione uma das opções acima.");
			System.out.println("");
			return true;
		} else {
			return false;
		}
	}

	public static String convertDecimalToAnotherBase(String inputNumber, int outputNumberBase) {

		int decimalNumber = convertToInteger(inputNumber);
		String convertedNumber = "";
		String hexadecimalNumber = "";

		if (outputNumberBase != HEXADECIMAL_BASE) {
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

		if (inputNumberBase != HEXADECIMAL_BASE) {

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

		int power = 0;
		for (int i = hexadecimalList.length - 1; i >= 0; i--) {

			int digit = hexadecimalList[i];

			decimalNumber += digit * Math.pow(HEXADECIMAL_BASE, power);
			power++;
		}

		return convertToString(decimalNumber);
	}

	public static int[] formatInputHexadecimalNumber(String inputNumber) {
		String[] hexadecimalDigits = inputNumber.split("");

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
