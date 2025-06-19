import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		
		System.out.println(decimalParaBinario(numero));
		
		sc.close();

	}
	
	public static int decimalParaBinario (int decimal) {
		String binario = "";
		int resultadoDivisão = decimal;
		
		while (resultadoDivisão >= 1) {
			binario += Integer.toString(resultadoDivisão % 2);
			resultadoDivisão /= 2;
		} 
		
		binario = new StringBuilder(binario).reverse().toString();
		
		int newBinario = Integer.parseInt(binario);
		
		return newBinario;
	}

}