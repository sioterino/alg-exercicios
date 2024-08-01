package src;
import java.util.*;
import java.util.Arrays;

public class Strings {
	public static void main(String[] args) {

/*
1. Escreva um programa que remova todas as vogais de uma string fornecida pelo
usuário

3. Escreva um programa que leia uma string fornecida pelo usuário e imprima
quantas vezes cada letra aparece na string.
 */

		Scanner scanner = new Scanner(System.in);
		String[] vogais = {"a","e","i","o","u"};
		int cont = 0;

		System.out.print("digite um texto qualquer: ");
		String input = scanner.nextLine().toLowerCase();

		
// q-2: apague todas as vogais da string fornecida.
		String consoante = input;
		for (int i = 0; i < vogais.length; i++) {
			consoante = consoante.replace(vogais[i], "");
		}
		System.out.println("\n-2. apenas consoantes: " + consoante + ".\n");


// q-1: imprima a string fornecida invertida.
		String invertida = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			invertida = invertida + String.valueOf(input.charAt(i));
		}
		System.out.println("-1. " + input + " invertido fica: " + invertida + ".\n");


// q0: imprima quantas vezes cada letra de uma palavra é repetida.
		String repetição = input.replace(" ","");
		System.out.println("0. número de repetição de letras: ");
		for (int i = 0; i < repetição.length(); i++) {

			cont = 0;
			char letter = repetição.charAt(0);
			System.out.print(letter + ": ");

			for (int j = 0; j < repetição.length(); j++) {
				if (letter == repetição.charAt(j)) {
					cont ++;
				}
			}

			repetição = repetição.replace(String.valueOf(letter),"");

			System.out.println(cont + ".");

		}


// q1: programa que pessa uma string para um usuário e conte o número de carateries.
		System.out.println("\n1. número de carateries da string inserida: " + input.length() + ".\n");


// q2: verifique se a palavra é um palídromo.
		String palindromo = invertida.replace(" ", "");
		if (input.replace(" ","").equals(palindromo)) {
			System.out.println("2. " + input + " é um palíndromo.\n");
		} else {
			System.out.println("2. " + input + " não é um palíndromo.\n");
		}


// q3: conte o número de vogais.
		cont = 0;
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < vogais.length; j++) {
				if (String.valueOf(input.charAt(i)).equals(vogais[j])) {
					cont++;
				}
			}
		}
		System.out.println("3. existem " + cont + " vogais.\n");


// q4: remova os espaços de uma string.
		System.out.println("4. sem espaços: " + input.replace(" ","") + ".\n");


// q5: remova os espaços de uma string.
		System.out.print("5. digite um símbolo para substituir os espaços: ");
		String symbol = scanner.nextLine();
		System.out.println("sem espaços: " + input.replace(" ",symbol.substring(0,1)) + ".\n");


// q6: conte o número de palavras.
		int palavras = 0;
		if (!input.isBlank()) {
			palavras++;
			for (int i = 0; i < input.length(); i++) {
				String letter = String.valueOf(input.charAt(i));
				if (letter.equals(" ")) {
					palavras++;
				}
			}
		}
		if (palavras == 1) {
			System.out.println("6. você digitou " + palavras + " palavra.\n");
		} else {
			System.out.println("6. você digitou " + palavras + " palavras.\n");
		}


// q7: descubra a maior palavra escrita.
		String text = input;
		int index = 0;
		String[] words = new String[palavras];

		// separating all the words.
		for (int i = 0; i < palavras; i++) {
			if (i == palavras - 1) {
				// only one word.
				words[i] = text;
			} else {
				// more than one words left.
				index = text.indexOf(" ");
				words[i] = text.substring(0,index);
				text = text.substring(index + 1);
			}
		}

		if (palavras == 0) {
			// if the input string is null.
			System.out.println("7. nenhuma palavra foi fornecida.\n");

		} else {
			// if the input string is NOT null.

			String maior = words[0];
			cont = words[0].length();

			if (palavras > 1)
				// if only there is more than 1 word.
				for (int i = 1; i < words.length; i++) {
					if (cont < words[i].length()) {
						maior = words[i];
						cont = words[i].length();
					}
				}

			System.out.println("7. a maior palavra escrita é: " + maior + ".\n");

		}


// q8: pessa outro input do usuário e descubra se é um anagrama da primeira string.
		System.out.print("digite um outro texto qualquer: ");
		String anagrama = scanner.nextLine().toLowerCase();

//      System.out.println("8. as palavras " + input + " e " + + " são anagramas.\n");


// q9: transforme a string fornecida para camalCase
		String camalCase = words[0];
		for (int i = 1; i < words.length; i++) {
			camalCase = camalCase + words[i].substring(0,1).toUpperCase() + words[i].substring(1);
		}

      System.out.println("9. camalCase: " + camalCase + ".\n");


// fim.
		scanner.close();
	}
}