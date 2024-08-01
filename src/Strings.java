package src;
import java.util.*;

public class Strings {
	public static void main(String[] args) {

/*
1. Escreva um programa que remova todas as vogais de uma string fornecida pelo
usuário

2. Escreva um programa que leia uma string fornecida pelo usuário e a imprima
invertida.

3. Escreva um programa que leia uma string fornecida pelo usuário e imprima
quantas vezes cada letra aparece na string.
 */

		char[] vogais = {'a','e','i','o','u'};
		int cont = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.print("digite um texto qualquer: ");
		String str = scanner.nextLine();
		str = str.toLowerCase();


// q1: programa que pessa uma string para um usuário e conte o número de carateries.
		System.out.println("1. número de carateries da string inserida: " + str.length() + ".\n");


// q2: verifique se a palavra é um palídromo.
		String palindromo = new StringBuilder(str).reverse().toString().replace(" ", "");
		if (str.replace(" ","").equals(palindromo)) {
			System.out.println("2. " + str + " é um palíndromo.\n");
		} else {
			System.out.println("2. " + str + " não é um palíndromo.\n");
		}
		System.out.println(palindromo);

// q3: conte o número de vogais.
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < vogais.length; j++) {
				if (str.charAt(i) == vogais[j]) {
					cont++;
				}
			}
		}
		System.out.println("3. existem " + cont + " vogais.\n");


// q4: remova os espaços de uma string.
		System.out.println("4. sem espaços: " + str.replace(" ","") + ".\n");



// q5: remova os espaços de uma string.
		System.out.print("5. digite um símbolo para substituir os espaços: ");
		String symbol = scanner.nextLine();
		System.out.println("sem espaços: " + str.replace(" ",symbol.substring(0,1)) + ".\n");


// q6: conte o número de palavras.
		cont = 0;
		if (!str.isBlank()) {
			cont++;
			for (int i = 0; i < str.length(); i++) {
				String letter = String.valueOf(str.charAt(i));
				if (letter.equals(" ")) {
					cont++;
				}
			}
		}
		System.out.println("6. você digitou " + cont + " palavras.\n");


// q7: descubra a maior palavra escrita.
//        System.out.println("7. você digitou " + cont + " palavras.\n");


// q8: descubra a maior palavra escrita.
//        System.out.println("8. você digitou " + cont + " palavras.\n");


// q9: transforme a string fornecida para camalCase
//        System.out.println("9. você digitou " + cont + " palavras.\n");


// q0: transforme a string fornecida para camalCase
//        System.out.println("0. você digitou " + cont + " palavras.\n");

		scanner.close();
	}
}