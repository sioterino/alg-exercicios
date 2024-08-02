package src;
import java.util.*;

public class Strings {
	public static void main(String[] args) {

// DECLARAÇÃO DE INDEPENDÊNCIA:
		Scanner scanner = new Scanner(System.in);
		String[] vogais = {"a","e","i","o","u"};
		int cont = 0;
// INPUT
		System.out.print("digite um texto qualquer: ");
		String input = scanner.nextLine().toLowerCase(); // descapitalizado.


// q-2: apague todas as vogais da string fornecida.
		String consoante = input; // string com apenas consoantes.
		for (int i = 0; i < vogais.length; i++) {
		// percorre a array de vogais e vai substituindo cada uma.
			consoante = consoante.replace(vogais[i], "");
		}
		System.out.println("\n-2. apenas consoantes: " + consoante + ".\n");


// q-1: imprima a string fornecida invertida.
		String invertida = ""; // string onde o input invertido será armazenado para a questão 2.
		for (int i = input.length() - 1; i >= 0; i--) {
			// percore o input de trás para frente e armazena letra por letra na string invertida.
			invertida = invertida + String.valueOf(input.charAt(i));
		}
		System.out.println("-1. " + input + " invertido fica: " + invertida + ".\n");


// q0: imprima quantas vezes cada letra de uma palavra é repetida.
		String repetição = input.replace(" ",""); // string que será modificada ao invés do input original.
		int number = 0; // número de letras que compõe o input.

		char[] letrasInput = new char[repetição.length()]; // armazena letras do input para questão 8.
		int[] timesInput = new int[repetição.length()]; // armazena repetições do input para questão 8.

		System.out.println("0. número de repetição de letras: ");
		for (int i = 0; repetição.length() > 0; i++) {
			// for loop que percorre as arrays enquanto a string repetição não for nula.

			char letter = repetição.charAt(0); // letra a ser contada.
			cont = 0; // número de repetições da letra.

			System.out.print(letter + ": ");

			for (int j = 0; j < repetição.length(); j++) {
				// for loop que percorre todas as letras restantes na string repetição.
				if (letter == repetição.charAt(j)) {
					// caso a letra em análise seja igual a letra do index j,
					cont ++; // adiciona 1 ao contador.
				}
			}

			letrasInput[i] = letter; // guarda a letra no array.
			timesInput[i] = cont; // guarda o número de repetição no array.

			System.out.println(cont + ".");

			repetição = repetição.replace(String.valueOf(letter),""); // apaga a letra analisada da string.
			number++; // adiciona 1 ao número de letras da palavra.

		}


// q1: programa que pessa uma string para um usuário e conte o número de carateries.
		System.out.println("\n1. número de carateries da string inserida: " + input.length() + ".\n");


// q2: verifique se a palavra é um palídromo.
		String palindromo = invertida.replace(" ", ""); // apaga os espaços da string invertida.

		if (input.replace(" ","").equals(palindromo)) {
			// caso input = palíndromo.
			System.out.println("2. " + input + " é um palíndromo.\n");
		} else {
			// caso input != palíndromo.
			System.out.println("2. " + input + " não é um palíndromo.\n");
		}


// q3: conte o número de vogais.
		cont = 0; // contador de vogais.

		for (int i = 0; i < input.length(); i++) { // percorre o input.
			for (int j = 0; j < vogais.length; j++) { // percorre o arrays de vogais.
				if (String.valueOf(input.charAt(i)).equals(vogais[j])) {
					// caso a letra em análise esteja contida no array de vogays,
					cont++; // adiciona 1 ao contador de vogais.
				}
			}
		}
		System.out.println("3. existem " + cont + " vogais.\n");


// q4: remova os espaços de uma string.
		System.out.println("4. sem espaços: " + input.replace(" ","") + ".\n");


// q5: substitua os espaços de uma string por um char fornecida pelo usuário.
		System.out.print("5. digite um símbolo para substituir os espaços: ");
		String symbol = String.valueOf(scanner.nextLine().charAt(0)); // input char.
		System.out.println("sem espaços: " + input.replace(" ",symbol.substring(0,1)) + ".\n"); // substitui e imprime.


// q6: conte o número de palavras.
		int palavras = 0; // conta o número de palavras.

		if (!input.isBlank()) {
			// se o input não for nulo/vazio,
			palavras++; // uma palavra é garantia que tem.

			for (int i = 0; i < input.length(); i++) { // percorre o input.
				String letter = String.valueOf(input.charAt(i));
				if (letter.equals(" ")) {
					// se a letra em análise for um espaço,
					palavras++; // conta mais uma palavra.
				}
			}
		}

		if (palavras == 1) {
			// caso só uma palavra tenha sido ecrita, imprima no SINGULAR.
			System.out.println("6. você digitou " + palavras + " palavra.\n");
		} else {
			// caso mais de uma palavra tenha sido ecrita, imprima no PLURAL.
			System.out.println("6. você digitou " + palavras + " palavras.\n");
		}


// q7: descubra a maior palavra escrita.
		String text = input; // guarda as palavras momentaneamente.
		int index = 0; // guarda o index dos espaços.
		String[] words = new String[palavras]; // guarda as palavras individualmente.

		// SEPARA AS PALAVRAS:
		for (int i = 0; i < palavras; i++) { // percorre a array de palavras.
			if (i == palavras - 1) {
				// se o input tiver apenas uma palavra,
				words[i] = text; // armazena no array direto.
			} else {
				// caso o input tenha mais de uma palavra.
				index = text.indexOf(" "); // encontra o primeiro espaço.
				words[i] = text.substring(0,index); // crie uma substring até esse espaço.
				text = text.substring(index + 1); // apague a primeira palavra do input.
			}
		}

		if (palavras == 0) {
			// se o input for nulo/vazio.
			System.out.println("7. nenhuma palavra foi fornecida.\n");

		} else {
			// se o input conter palavras.

			String maior = words[0]; // define a maior palavra como o primeiro item da array.
			cont = words[0].length(); // define o contador de tamanho de palavra como o tamnho do primeiro item do array.

			if (palavras > 1) {
				// apenas se tiver mais de uma palavra no input.
				for (int i = 1; i < words.length; i++) {
					// percorre a array de palavras, começando pelo segundo item.
					if (cont < words[i].length()) {
						// caso o item seguinte seja maior que o item anterior,
						// defina ele como a nova maior palavra.
						maior = words[i];
						cont = words[i].length();
					}
				} // fecha for loop.
			} // fecha condicional if (palavras > 1).

			System.out.println("7. a maior palavra escrita é: " + maior + ".\n");

		} // fecha else (se o input conter palavras).


// q8: pessa outro input do usuário e descubra se é um anagrama da primeira string.

		// ANAGRAMA INPUT.
		System.out.print("8. digite um outro texto qualquer: ");
		String anagrama = scanner.nextLine().toLowerCase(); // descapitalizado.


		if (input.replace(" ", "").length() != anagrama.replace(" ","").length()) {
			// caso o temanho do INPUT e do ANAGRAMA sem espaços não sejam iguais NÃO É ANAGRAMA.
			System.out.println("as palavras " + input + " e " + anagrama + " não são anagramas.\n");
		} else {
			// caso o tamanho do INPUT e do ANAGRAMA sem espaços seja o mesmo, executa.

			String repetiçãoAnagrama = anagrama.replace(" ",""); // string do anagrama que será modificada.
			int numberAnagrama = 0; // guarda o número de letras do anagrama.

			char[] letrasAnagrama = new char[repetiçãoAnagrama.length()]; // armazena as letras do anagrama.
			int[] timesAnagrama = new int[repetiçãoAnagrama.length()]; // armazena as repetiçõies das letras do anagrama.

			for (int i = 0; repetiçãoAnagrama.length() > 0; i++) {
				// percorre os arrays enquanto o anagrama não for nulo.

				char letter = repetiçãoAnagrama.charAt(0); // guarda a letra a ser analisada.
				cont = 0; // contador de repetições da letra.

				for (int j = 0; j < repetiçãoAnagrama.length(); j++) { // percorre o anagrama.
					if (letter == repetiçãoAnagrama.charAt(j)) {
						// caso a letra em análise seja igual a letra do index j,
						cont ++; // adiciona 1 ao contador.
					}
				}

				letrasAnagrama[i] = letter; // guarda a letra analisada no array.
				timesAnagrama[i] = cont; // guarda a repetição da letra analisada no array.

				// apaga a letra já analisada do anagrama.
				repetiçãoAnagrama = repetiçãoAnagrama.replace(String.valueOf(letter),"");

				numberAnagrama++; // adiciona 1 ao número de letras contidas no anagrama.

			}

			if (number != numberAnagrama) {
				// caso o INPUT e o ANAGRAMA não possuam a mesma quantidade de letras contidas NÃO SÃO ANAGRAMAS.
				System.out.println("as palavras " + input + " e " + anagrama + " não são anagramas.\n");
			} else {
				// caso o INPUT e o ANAGRAMA possuam a mesma quantidade de letras contidas, executa.
				cont = 0; // contador de letras em semelhante.

				for (int i = 0; i < number; i++) { // PERCORRE INPUT
					for (int j = 0; j < numberAnagrama; j++) { // PERCORRE ANAGRAMA

						if (letrasInput[i] == letrasAnagrama[j]) {
							if (timesInput[i] == timesAnagrama[j]) {
								// caso o item i do input seja igual ao item j do anagrama E
								// caso o número de repetição dessas letras IGUAIS sejam a mesma,
								cont++; // aadiciona 1 ao contador de letras semelhante.
							}
						}

					}  // fecha for que PERCORRE ANAGRAMA.
				} // fecha for que PERCORRE INPUT.


				if (cont == number) {
					// caso o contador de letras semelhantes seja igual ao número de letras contidas no input/anagrama, SÃO ANAGRAMAS.
					System.out.println("as palavras " + input + " e " + anagrama + " são anagramas.\n");
				} else {
					// caso o contador de letras semelhantes NÃO seja igual ao número de letras contidas no input/anagrama, NÃO SÃO ANAGRAMAS.
					System.out.println("as palavras " + input + " e " + anagrama + " não são anagramas.\n");
				}

			} // fehca else (number != numberAnagrama).

		} // fehca else (tamanho do INPUT e ANAGRAMA não é o mesmo)


// q9: transforme a string fornecida para camalCase
		String camalCase = words[0]; // define a primeira palavra como o primeiro item da array de palavras.
		for (int i = 1; i < words.length; i++) { // percorre o array de palavras, começando pelo segundo item.

			// adiciona a string do camalCase a próxima palavra do array capitalizada.
			camalCase = camalCase + words[i].substring(0,1).toUpperCase() + words[i].substring(1);
		}

		System.out.println("9. camalCase: " + camalCase + ".\n");


// fim.
		scanner.close();
	}
}