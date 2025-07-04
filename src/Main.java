
import java.util.Scanner;

import util.Converter;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char repeat = 's';

		while (Character.toLowerCase(repeat) == 's') {
			System.out.print("Insira o número que você quer converter: ");
			String inputNumber = sc.nextLine();
			inputNumber = inputNumber.toUpperCase();
			System.out.println("Indique a base do número que você inseriu: ");
			System.out.println("[10] Decimal");
			System.out.println("[2] Binário");
			System.out.println("[8] Octal");
			System.out.println("[16] Hexadecimal");
			int inputNumberBase = sc.nextInt();
			sc.nextLine();

			boolean invalidInputNumberBase = Converter.validateInputNumberBase(inputNumberBase);

			if (invalidInputNumberBase) {
				continue;
			}

			boolean invalidInputNumber = Converter.validateInputNumber(inputNumber, inputNumberBase);

			if (invalidInputNumber) {
				continue;
			}

			Converter.convert(inputNumber, inputNumberBase);

			System.out.println("");
			System.out.print("Converter novamente ? s/n ");
			repeat = sc.next().charAt(0);
			sc.nextLine();
		}

		sc.close();
	}
}