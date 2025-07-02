
import java.util.Scanner;

import util.Converter;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char repetir;
		
		do {
			System.out.println("CONVERSOR DE BASES NUMÉRICAS:");
			System.out.println("");
			System.out.print("Insira o número que você quer converter: ");
			String numeroDeEntrada = sc.nextLine();
			System.out.println("Indique a base do número que você inseriu: ");
			System.out.println("[1] Decimal");
			System.out.println("[2] Binário");
			System.out.println("[3] Octal");
			System.out.println("[4] Hexadecimal");
			System.out.print("=");
			int baseNumericaDeEntrada = sc.nextInt();
			System.out.print("Selecione a base numérica que você quer converter: ");
			int baseNumericaDeSaida = sc.nextInt();
			
			if (baseNumericaDeEntrada == 1) {
				System.out.println(Converter.converterDecimalParaOutraBase(numeroDeEntrada, baseNumericaDeSaida));
				
			} else if (baseNumericaDeEntrada != 1 && baseNumericaDeSaida == 1) {
				System.out.println(Converter.converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada));
				
			} else {
				String numeroDecimal = Converter.converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada);
				System.out.println(Converter.converterDecimalParaOutraBase(numeroDecimal, baseNumericaDeSaida));
			}
			
			System.out.println("Converter novamente ? s/n");
			repetir = sc.next().charAt(0); 
			sc.nextLine();
			
		} while (repetir == 's');
		
		sc.close();
	}
}