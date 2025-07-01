
import java.util.Scanner;

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
				System.out.println(converterDecimalParaOutraBase(numeroDeEntrada, baseNumericaDeSaida));
				
			} else if (baseNumericaDeEntrada != 1 && baseNumericaDeSaida == 1) {
				System.out.println(converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada));
				
			} else {
				String numeroDecimal = converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada);
				System.out.println(converterDecimalParaOutraBase(numeroDecimal, baseNumericaDeSaida));
			}
			
			System.out.println("Converter novamente ? s/n");
			repetir = sc.next().charAt(0); 
			
		} while (repetir == 's');
		
		sc.close();
	}
	
	public static String converterDecimalParaOutraBase (String numeroDeEntrada, int baseNumericaDeSaida) {
		
		int baseNumerica = verificarBaseNumerica(baseNumericaDeSaida);
		
		int numero = converterParaInteiro(numeroDeEntrada);
		String numeroConvertido = "";
		
		
		while (numero >= 1) {
			numeroConvertido += converterParaString(numero % baseNumerica);
			numero /= baseNumerica;
		} 
		
		numeroConvertido = inverterString(numeroConvertido);
		
		return numeroConvertido;
	}

	public static String converterParaDecimal (String numeroDeEntrada, int baseNumericaDeEntrada) {
		
		int baseNumerica = verificarBaseNumerica(baseNumericaDeEntrada);
		
		String numero = numeroDeEntrada;
		
		int digito = 0;
		
		int numeroDecimal = 0;
			
		numero = inverterString(numero);
			
		String[] listaDeDigitos = numero.split("");
			
		for (int i = 0; i < listaDeDigitos.length; i++) {
						
			digito = converterParaInteiro(listaDeDigitos[i]);
			
			numeroDecimal += digito * Math.pow(baseNumerica, i);
		}
	
		return converterParaString(numeroDecimal);
	}
	
	public static int verificarBaseNumerica (int baseNumericaDeEntrada) {
		switch (baseNumericaDeEntrada) {
		case 1:
			return 10;
		case 2:
			return 2;
		case 3:
			return 8;
		case 4:
			return  16;
		default:
			return  0;
		}
	}
	
//	public static String formatarNumeroHexadecimalDeEntrada (String numeroDeEntrada) {
//		String[] listaHexadecimal = numeroDeEntrada.split("");
//		
//		String digito = "";
//		
//		for (int i = 0; i < listaHexadecimal.length; i++) {
//			switch (listaHexadecimal[i]) {
//			case "A":
//				digito += "10";
//				break;
//			case "B":
//				digito += "11";
//				break;
//			case "C":
//				digito += "12";
//				break;
//			case "D":
//				digito += "13";
//				break;
//			case "E":
//				digito += "14";
//				break;
//			case "F":
//				digito += "15";
//				break;
//			default:
//				digito += listaHexadecimal[i];
//			}
//		}
//		
//		return digito;
//	}
	
	public static String converterParaString (int numero) {
		return Integer.toString(numero);
	}
	
	public static int converterParaInteiro (String texto) {
		return Integer.parseInt(texto);
	}
	
	public static String inverterString (String texto) {
		String textoInvertido = new StringBuilder(texto).reverse().toString();
		
		return textoInvertido;
	}
	
}