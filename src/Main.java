
import java.util.Scanner;

import util.Converter;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char repetir;
		
		do {
			System.out.print("Insira o número que você quer converter: ");
			String numeroDeEntrada = sc.nextLine();
			System.out.println("Indique a base do número que você inseriu: ");
			System.out.println("[10] Decimal");
			System.out.println("[2] Binário");
			System.out.println("[8] Octal");
			System.out.println("[16] Hexadecimal");
			int baseNumericaDeEntrada = sc.nextInt();
			
			String decimal = "", binario = "", octal = "", hexadecimal = "";
			
			switch (baseNumericaDeEntrada) {
			case 10: 
				decimal = numeroDeEntrada;
				binario = Converter.converterDecimalParaOutraBase(numeroDeEntrada, 2);
				octal = Converter.converterDecimalParaOutraBase(numeroDeEntrada, 8);
				hexadecimal = Converter.converterDecimalParaOutraBase(numeroDeEntrada, 16);
				break;
			case 2:
				binario = numeroDeEntrada;
				decimal = Converter.converterParaDecimal(binario, 2);
				octal = Converter.converterDecimalParaOutraBase(decimal, 8);
				hexadecimal = Converter.converterDecimalParaOutraBase(decimal, 16);
				break;
			case 8:
				octal = numeroDeEntrada;
				decimal = Converter.converterParaDecimal(octal, 8);
				binario = Converter.converterDecimalParaOutraBase(decimal, 2);
				hexadecimal = Converter.converterDecimalParaOutraBase(decimal, 16);
				break;
			case 16:
				hexadecimal = numeroDeEntrada;
				decimal = Converter.converterParaDecimal(hexadecimal, 16);
				binario = Converter.converterDecimalParaOutraBase(decimal, 2);
				octal = Converter.converterDecimalParaOutraBase(decimal, 8);
				break;
			}
			
			System.out.println("");
			System.out.println("Número inserido: " + numeroDeEntrada + " base " + baseNumericaDeEntrada);
			System.out.println("");
			System.out.println("Decimal: " + decimal);
			System.out.println("Binário: " + binario);
			System.out.println("Octal: " + octal);
			System.out.println("Hexadecimal: "+ hexadecimal);
			
			System.out.println("");
			System.out.println("Converter novamente ? s/n");
			repetir = sc.next().charAt(0);
			sc.nextLine();
			
		} while (repetir == 's');

		sc.close();
	}
}