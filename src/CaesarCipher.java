package src;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class CaesarCipher {

	private static final Scanner scanner = new Scanner(System.in);
	static String lower = "abcdefghijklmnopqrstuvwxyz";
	static String upper = lower.toUpperCase();

	// main method, pede por input e gera a cifra.
	public static void main(String[] args) {

		String texto = pedeTexto();
		int chave = pedeDeslocamento();

		String encoded = encode(texto, chave);
		String decoded = decodeConsonant(encoded);

		System.out.println("\nenconded: " + encoded);
		System.out.println("deconded: " + decoded);
		
	}

	// metodo de codificação.
	public static String encode(String str, int deslocamento) {

		str = formating(str);
		String cipher = ""; // output

		for (int i = 0; i < str.length(); i++) { // percorre string str

			// letra a ser codificada.
			char letra = str.charAt(i);

			if (Character.isLetter(letra)) {
				// se char letra == alfabero.

				if (Character.isLowerCase(letra)) { // MINUSCULAS
					// define o indice da letra coletada.
					int indice = lower.indexOf(letra);
					// desloca e mantém no escopo do alfabeto com %26.
					int desloca = (indice + deslocamento) % 26;
					// codifica
					cipher += lower.charAt(desloca);


				} else { // MAIUSCULAS
					// define o indice da letra coletada.
					int indice = upper.indexOf(letra);
					// desloca e mantém no escopo do alfabeto com %26.
					int desloca = (indice + deslocamento) % 26;
					// codifica
					cipher += upper.charAt(desloca);
				}

			} else {
				// se char letra != alfabero.
				cipher += letra;
			}
		} // fecha for loop.

		// retorna string codificada.
		return cipher;
	}

	// metodo principal de decodificação >> calcula frequencia das letras e gera 3 possibilidades.
	public static String decode(String str) {

		str = formating(str);

		// calcula letra mais frequente.
		char maior = str.charAt(0);
		int indice = 0;
		for (int i = 1; i < str.length(); i++) {
			char letra = str.charAt(i);
			if (maior < letra) {
				maior = letra;
				indice = i;
			}
		}

		String[] letras = {"a", "e", "o"};
		String[] decifragens = new String[letras.length];

		// assume que a letra com maior frequencia é 'a', 'e', ou 'o'.
		for (int i = 0; i < letras.length; i++) {

			int deslocamento = -(indice - lower.indexOf(letras[i])) + 26;
			// garante que o deslocamento é um inteiro positivo.
			if (deslocamento < 0) {
				deslocamento += 26;
				
			}

			// gera as três possíveis decodificações.
			decifragens[i] = encode(str, deslocamento);
		}

		// retorna a melhor decodificação.
		return bestGuess(decifragens);
	}




	public static String decodeConsonant(String str) {

		String auxiliar = formating(str).toLowerCase();
		String[] decifragens = new String[lower.length()];

		for (int i = 0; i < decifragens.length; i++) {
			decifragens[i] = encode(str, i);
		}

		// retorna a melhor decodificação.
		return consonant(decifragens);
	}

	// metodo q decodifica contando vogais e consoantes.
	private static String consonant(String[] decifragens) {

		int[] repeticoes = new int[decifragens.length]; // repetições por decodificação.

		String vogais = "aeiou";
		String consoantes = "bcdfghjklmnpqrstvwxyz";

		for (int i = 0; i < decifragens.length - 1; i++) {

			int cont = 0;

			for (int j = 0; j < decifragens[i].length() - 1; j++) {

				String antecessor = String.valueOf(decifragens[i].charAt(j)); // consoante.
				String sucessor = String.valueOf(decifragens[i].charAt(j + 1)); // vogal.

				if (consoantes.contains(antecessor) && vogais.contains(sucessor)) {
					cont++;
				}
			}

			repeticoes[i] = cont;
		}


		// define o indice da decodificação com a MENOR frequencia de letras raras.
		int menor = repeticoes[0];
		int indice = 0;
		for (int i = 1; i < repeticoes.length; i++) {
			if (menor > repeticoes[i]) {
				menor = repeticoes[i];
				indice = i;
			}
		}

		// decodificação com menor ocorrencias de letras raras.
		System.out.println(Arrays.toString(repeticoes));
		System.out.println(decifragens[indice]);
		return decifragens[indice];
	}

	// metodo auxiliar de decodificação >> calcula frequencia de letras raras na lingua portuguesa.
	private static String bestGuess(String[] decifragens) {

		int[] repeticoes = new int[decifragens.length]; // repetições por decodificação.

		// conta frequência de 'x', 'w', 'y' e 'k'.
		for (int i = 0; i < decifragens.length; i++) {
			// decodificação a ser analisada.
			String frase = decifragens[i];
			int cont = 0; // conta ocorrÊncias.

			// conta ocorrencias de 'x', 'w', 'y' ou 'k'.
			for (int j = 0; j < frase.length(); j++) {

				char letra = frase.charAt(j);
				switch (letra) {
					case 'x','w','y','k':
						cont++;
				}

			}
			// armazena contador no int[] repetições.
			repeticoes[i] = cont;
		}


		// verifica se há empate de letras em repetições[].
		if (isEqual(repeticoes).length > 1) {
			// caso isEqual != {0}.

			// armazena indices das
			int[] indices = isEqual(repeticoes);

			// conta ocorrências de 'z'.
			for (int i = 0; i < indices.length; i++) { // percorre indices (isEqual).

				String frase = decifragens[indices[i]]; // decodificação a ser analisada.
				int cont = 0;

				// conta as ocorrencias de 'z'.
				for (int j = 0; j < frase.length(); j++) {
					char letra = frase.charAt(j);
					if (letra == 'z') {
						cont++;
					}
				}

				// soma o contador ao int[] repetições.
				repeticoes[indices[i]] += cont;
			}

		}

		// define o indice da decodificação com a MENOR frequencia de letras raras.
		int menor = repeticoes[0];
		int indice = 0;
		for (int i = 1; i < repeticoes.length; i++) {
			if (menor > repeticoes[i]) {
				menor = repeticoes[i];
				indice = i;
			}
		}

		// decodificação com menor ocorrencias de letras raras.
		return decifragens[indice];
	}

	// verifica e retorna os indices de frequencia de letras raras que estão empatados.
	public static int[] isEqual(int[] numeros) {

		if (numeros[0] == numeros[1] && numeros[0] == numeros[2]) {
			return new int[] {0, 1, 2};

		} else if (numeros[0] == numeros[1]) {
			return new int[] {0, 1};

		} else if (numeros[0] == numeros[2]) {
			return new int[] {0, 2};

		} else if (numeros[1] == numeros[2]) {
			return new int[] {1, 2};

		} else {
			return new int[] {0};
		}

	}

	// usa scanner para pedir string input do usuário.
	public static String pedeTexto() {
		System.out.println();
		System.out.print("Insira um texto qualquer: ");
		return scanner.nextLine();
	}

	// usa scanner para pedir int input do usuário.
	public static int pedeDeslocamento() {
		System.out.print("Insira uma chave de código numérica: ");
		int deslocamento;
		// pede o deslocamento certo
		while (true) {
			String str = scanner.nextLine();
			// previne que o input seja uam string.
			try {
				deslocamento = Integer.parseInt(str);
				break; // para while loop.
			} catch (Exception e) {
				System.out.println("Por favor, insira apenas valores numéricos.");
			}
		}
		System.out.println();

		// verifica se o deslocamento está dentro do alfabeto.
		if (deslocamento > 25) {
			deslocamento = deslocamento % 26;
		}

		// garante que haverá deslocamento.
		if (deslocamento == 0) {
			deslocamento = 1;
		}

		return deslocamento;
	}

	// substitui acentos e caracteries especiais como ç.
	private static String formating(String str) {

		char[][] letters = {
				{'á', 'à', 'â', 'ã', 'ä'},	// 0.
				{'é', 'è', 'ê', 'ë'},		// 1.
				{'í', 'ì', 'î', 'ï'},		// 2.
				{'ó', 'ò', 'ô', 'õ', 'ö'},	// 3.
				{'ú', 'ù', 'û', 'ü' },		// 4.
				{'ñ'},						// 5.
				{'ç'},						// 6.
		};

		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);

			// replacing all the As.
			for (int j = 0; j < letters[0].length; j++) {
				if (letter == letters[0][j]) {
					str = str.replace(letter, 'a');
				}
			}

			// replacing all the Es.
			for (int j = 0; j < letters[1].length; j++) {
				if (letter == letters[1][j]) {
					str = str.replace(letter, 'e');
				}
			}

			// replacing all the Is.
			for (int j = 0; j < letters[2].length; j++) {
				if (letter == letters[2][j]) {
					str = str.replace(letter, 'i');
				}
			}

			// replacing all the Os.
			for (int j = 0; j < letters[3].length; j++) {
				if (letter == letters[3][j]) {
					str = str.replace(letter, 'o');
				}
			}

			// replacing all the u's.
			for (int j = 0; j < letters[4].length; j++) {
				if (letter == letters[4][j]) {
					str = str.replace(letter, 'u');
				}
			}

			// replacing all the Ñ.
			if (letter == letters[5][0]) {
				str = str.replace(letter, 'n');
			}

			// replacing all the Ç.
			if (letter == letters[6][0]) {
				str = str.replace(letter, 'c');
			}

		}

		return str;
	}

}