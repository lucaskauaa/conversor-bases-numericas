import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CONVERSOR DE BASES NUMÉRICAS");
		System.out.println("");
		System.out.print("Insira o número que você quer converter: ");
		int numeroDeEntrada = sc.nextInt();
		System.out.println("[1] Decimal");
		System.out.println("[2] Binário");
		System.out.println("[3] Octal");
		System.out.println("[4] Hexadecimal");
		System.out.print("Selecione a base do número de entrada: ");
		int baseNumericaDeEntrada = sc.nextInt();
		System.out.print("Selecione a base do número de saída: ");
		int baseNumericaDeRetorno = sc.nextInt();
		
		if (baseNumericaDeEntrada == 1) {
			System.out.println(converterDecimalParaOutraBase(numeroDeEntrada, baseNumericaDeRetorno));
			
		} else if (baseNumericaDeEntrada != 1 && baseNumericaDeRetorno == 1) {
			System.out.println(converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada));
			
		} else {
			String numeroDecimal = converterParaDecimal(numeroDeEntrada, baseNumericaDeEntrada);
			System.out.println(converterDecimalParaOutraBase(converterParaInteiro(numeroDecimal), baseNumericaDeRetorno));
		}
		
		sc.close();

	}
	
	public static String converterDecimalParaOutraBase (int numeroDeEntrada, int baseNumericaDeSaida) {
		
		int baseNumerica = verificarBaseNumerica(baseNumericaDeSaida);
		
		int numero = numeroDeEntrada;
		String numeroConvertido = "";
		
		
		while (numero >= 1) {
			numeroConvertido += converterParaString(numero % baseNumerica);
			numero /= baseNumerica;
		} 
		
		numeroConvertido = inverterString(numeroConvertido);
		
		return numeroConvertido;
	}

	public static String converterParaDecimal (int numeroDeEntrada, int baseNumericaDeEntrada) {
		
		int baseNumerica = verificarBaseNumerica(baseNumericaDeEntrada);
		
		String numero = converterParaString(numeroDeEntrada);
		
		numero = inverterString(numero);
		
		String[] listaDeDigitos = numero.split("");
		
		int digito;
		
		int numeroDecimal = 0;
		
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
	
	public static String formatarNumeroHexadecimal (int numeroDeEntrada) {
		
	}
	
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