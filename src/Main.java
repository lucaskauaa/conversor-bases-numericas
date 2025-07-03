
import java.util.Scanner;

import util.Converter;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char repeat;
		
		do {
			System.out.print("Insira o número que você quer converter: ");
			String inputNumber = sc.nextLine();
			System.out.println("Indique a base do número que você inseriu: ");
			System.out.println("[10] Decimal");
			System.out.println("[2] Binário");
			System.out.println("[8] Octal");
			System.out.println("[16] Hexadecimal");
			int inputNumberBase = sc.nextInt();
			
			String decimal = "", binary = "", octal = "", hexadecimal = "";
			
			switch (inputNumberBase) {
			case 10: 
				decimal = inputNumber;
				binary = Converter.convertDecimalToAnotherBase(inputNumber, 2);
				octal = Converter.convertDecimalToAnotherBase(inputNumber, 8);
				hexadecimal = Converter.convertDecimalToAnotherBase(inputNumber, 16);
				break;
			case 2:
				binary = inputNumber;
				decimal = Converter.convertToDecimal(binary, 2);
				octal = Converter.convertDecimalToAnotherBase(decimal, 8);
				hexadecimal = Converter.convertDecimalToAnotherBase(decimal, 16);
				break;
			case 8:
				octal = inputNumber;
				decimal = Converter.convertToDecimal(octal, 8);
				binary = Converter.convertDecimalToAnotherBase(decimal, 2);
				hexadecimal = Converter.convertDecimalToAnotherBase(decimal, 16);
				break;
			case 16:
				hexadecimal = inputNumber;
				decimal = Converter.convertToDecimal(hexadecimal, 16);
				binary = Converter.convertDecimalToAnotherBase(decimal, 2);
				octal = Converter.convertDecimalToAnotherBase(decimal, 8);
				break;
			}
			
			System.out.println("");
			System.out.println("Número inserido: " + inputNumber + " base " + inputNumberBase);
			System.out.println("");
			System.out.println("Decimal: " + decimal);
			System.out.println("Binário: " + binary);
			System.out.println("Octal: " + octal);
			System.out.println("Hexadecimal: "+ hexadecimal);
			
			System.out.println("");
			System.out.println("Converter novamente ? s/n");
			repeat = sc.next().charAt(0);
			sc.nextLine();
			
		} while (repeat == 's');

		sc.close();
	}
}