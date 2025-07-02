package util;

public class Converter {

	public static String converterDecimalParaOutraBase(String numeroDeEntrada, int baseNumericaDeSaida) {

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

	public static String converterParaDecimal(String numeroDeEntrada, int baseNumericaDeEntrada) {

		int baseNumerica = verificarBaseNumerica(baseNumericaDeEntrada);

		String numero = numeroDeEntrada;

		int numeroDecimal = 0;

		if (baseNumericaDeEntrada != 16) {
			
			numero = inverterString(numero);

			String[] listaDeDigitos = numero.split("");

			for (int i = 0; i < listaDeDigitos.length; i++) {

				int digito = converterParaInteiro(listaDeDigitos[i]);

				numeroDecimal += digito * Math.pow(baseNumerica, i);
			}
			
			return converterParaString(numeroDecimal);
			
		} else {
			return converterHexadecimalParaDecimal(numeroDeEntrada);
		}
	}

	public static String converterHexadecimalParaDecimal(String numeroDeEntrada) {
		String[] teste = formatarNumeroHexadecimalDeEntrada(numeroDeEntrada);
		
		int numeroDecimal = 0;
		
		int c = 0;
		for (int i = teste.length - 1; i >= 0; i--) {

			int digito = Integer.parseInt(teste[i]);

			numeroDecimal += digito * Math.pow(16, c);
			c++;
		}
		
		return converterParaString(numeroDecimal);
	}

	public static String[] formatarNumeroHexadecimalDeEntrada(String numeroDeEntrada) {
		String[] listaHexadecimal = numeroDeEntrada.toUpperCase().split("");

		String[] teste = new String[listaHexadecimal.length];
		for (int i = 0; i < listaHexadecimal.length; i++) {
			switch (listaHexadecimal[i]) {
			case "A":
				teste[i] = "10";
				break;
			case "B":
				teste[i] = "11";
				break;
			case "C":
				teste[i] = "12";
				break;
			case "D":
				teste[i] = "13";
				break;
			case "E":
				teste[i] = "14";
				break;
			case "F":
				teste[i] = "15";
				break;
			default:
				teste[i] = listaHexadecimal[i];
			}
		}

		return teste;
	}

	public static int verificarBaseNumerica(int baseNumericaDeEntrada) {
		switch (baseNumericaDeEntrada) {
		case 1:
			return 10;
		case 2:
			return 2;
		case 3:
			return 8;
		case 4:
			return 16;
		default:
			return 0;
		}
	}

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
