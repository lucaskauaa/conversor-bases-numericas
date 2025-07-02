package util;

public class Converter {

	public static String converterDecimalParaOutraBase(String numeroDeEntrada, int baseNumericaDeSaida) {

		int numeroDecimal = converterParaInteiro(numeroDeEntrada);
		String numeroConvertido = "";

		while (numeroDecimal >= 1) {
			numeroConvertido += converterParaString(numeroDecimal % baseNumericaDeSaida);
			numeroDecimal /= baseNumericaDeSaida;
		}

		numeroConvertido = inverterString(numeroConvertido);

		return numeroConvertido;
	}

	public static String converterParaDecimal(String numeroDeEntrada, int baseNumericaDeEntrada) {

		int numeroDecimal = 0;

		if (baseNumericaDeEntrada != 16) {
			
			numeroDeEntrada = inverterString(numeroDeEntrada);

			String[] listaDeDigitos = numeroDeEntrada.split("");

			for (int i = 0; i < listaDeDigitos.length; i++) {

				int digito = converterParaInteiro(listaDeDigitos[i]);

				numeroDecimal += digito * Math.pow(baseNumericaDeEntrada, i);
			}
			
			return converterParaString(numeroDecimal);
			
		} else {
			return converterHexadecimalParaDecimal(numeroDeEntrada);
		}
	}

	public static String converterHexadecimalParaDecimal(String numeroDeEntrada) {
		int[] listaHexadecimal = formatarNumeroHexadecimalDeEntrada(numeroDeEntrada);
		
		int numeroDecimal = 0;
		
		int c = 0;
		for (int i = listaHexadecimal.length - 1; i >= 0; i--) {

			int digito = listaHexadecimal[i];

			numeroDecimal += digito * Math.pow(16, c);
			c++;
		}
		
		return converterParaString(numeroDecimal);
	}

	public static int[] formatarNumeroHexadecimalDeEntrada(String numeroDeEntrada) {
		String[] digitosHexadecimais = numeroDeEntrada.toUpperCase().split("");

		int[] listaHexadecimal = new int[digitosHexadecimais.length];
		for (int i = 0; i < listaHexadecimal.length; i++) {
			switch (digitosHexadecimais[i]) {
			case "A":
				listaHexadecimal[i] = 10;
				break;
			case "B":
				listaHexadecimal[i] = 11;
				break;
			case "C":
				listaHexadecimal[i] = 12;
				break;
			case "D":
				listaHexadecimal[i] = 13;
				break;
			case "E":
				listaHexadecimal[i] = 14;
				break;
			case "F":
				listaHexadecimal[i] = 15;
				break;
			default:
				listaHexadecimal[i] = converterParaInteiro(digitosHexadecimais[i]);
			}
		}

		return listaHexadecimal;
	}
	
//	public static String formatarNumeroHexadecimalDeSaida() {
//		
//	}

	public static String converterParaString(int numero) {
		return Integer.toString(numero);
	}

	public static int converterParaInteiro(String texto) {
		return Integer.parseInt(texto);
	}

	public static String inverterString(String texto) {
		String textoInvertido = new StringBuilder(texto).reverse().toString();

		return textoInvertido;
	}

}
