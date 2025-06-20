import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numeroDeEntrada = sc.nextInt();
		
		System.out.println(decimalParaBinario(numeroDeEntrada));
		
		sc.close();

	}
	
	public static String decimalParaBinario (int numeroDecimalDeEntrada) {
		
		int numeroDecimal = numeroDecimalDeEntrada;
		String numeroBinario = "";
		
		
		while (numeroDecimal >= 1) {
			numeroBinario += Integer.toString(numeroDecimal % 2);
			numeroDecimal /= 2;
		} 
		
		numeroBinario = new StringBuilder(numeroBinario).reverse().toString();
		
		return numeroBinario;
	}

	public static String binarioParaDecimal (int numeroBinarioDeEntrada) {
		
		String numeroBinario = Integer.toString(numeroBinarioDeEntrada);
		
		numeroBinario = new StringBuilder(numeroBinario).reverse().toString();
		
		String[] listaDeBits = numeroBinario.split("");
		
		int bit;
		
		int numeroDecimal = 0;
		
		for (int i = 0; i < listaDeBits.length; i++) {
			bit = Integer.parseInt(listaDeBits[i]);
			
			numeroDecimal += bit * Math.pow(2, i);
		}
		
		return Integer.toString(numeroDecimal);
	}
}