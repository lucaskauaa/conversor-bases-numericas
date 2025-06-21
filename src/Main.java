import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira um número: ");
		int numeroDeEntrada = sc.nextInt();
		
		System.out.println(decimalParaBinario(numeroDeEntrada));
		
		sc.close();

	}
	
	public static String decimalParaBinario (int numeroDecimalDeEntrada) {
		
		int numeroDecimal = numeroDecimalDeEntrada;
		String numeroBinario = "";
		
		
		while (numeroDecimal >= 1) {
			numeroBinario += converterParaString(numeroDecimal % 2);
			numeroDecimal /= 2;
		} 
		
		numeroBinario = inverterString(numeroBinario);
		
		return numeroBinario;
	}

	public static String binarioParaDecimal (int numeroBinarioDeEntrada) {
		
		String numeroBinario = converterParaString(numeroBinarioDeEntrada);
		
		numeroBinario = inverterString(numeroBinario);
		
		String[] listaDeBits = numeroBinario.split("");
		
		int bit;
		
		int numeroDecimal = 0;
		
		for (int i = 0; i < listaDeBits.length; i++) {
			bit = converterParaInteiro(listaDeBits[i]);
			
			numeroDecimal += bit * Math.pow(2, i);
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