import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira um número: ");
		int numeroDeEntrada = sc.nextInt();
		int baseNumerica = sc.nextInt();
		
		System.out.println(converterParaDecimal(numeroDeEntrada, baseNumerica));
		
		sc.close();

	}
	
	public static String converterDecimalParaOutraBase (int numeroDeEntrada, int baseNumerica) {
		
		int numero = numeroDeEntrada;
		String numeroConvertido = "";
		
		
		while (numero >= 1) {
			numeroConvertido += converterParaString(numero % baseNumerica);
			numero /= baseNumerica;
		} 
		
		numeroConvertido = inverterString(numeroConvertido);
		
		return numeroConvertido;
	}

	public static String converterParaDecimal (int numeroDeEntrada, int baseNumerica) {
		
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