package src;

import java.util.Scanner;

public class CaesarCipher {

	private static final Scanner scanner = new Scanner(System.in);

	// main method, pede por input e gera a cifra.
	public static void main() {

		String texto = pedeTexto();
		int chave = pedeDeslocamento();

		String encoded = encode(texto, chave);
		String decoded = decode(encoded);

		System.out.println(encoded);
		System.out.println(decoded);
		
	}

	// método de codificação.
	public static String encode(String str, int deslocamento) {

		str = formating(str);

		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String cipher = ""; // output

		for (int i = 0; i < str.length(); i++) { // percorre string str

			// letra a ser codificada.
			char letra = str.charAt(i);

			if (Character.isLetter(letra)) {
				// se char letra == alfabero.

				if (Character.isLowerCase(letra)) { // MINUSCULAS
					// define o indice da letra coletada.
					int indice = indexOf(letra, lower);
					// desloca e mantém no escopo do alfabeto com %26.
					int desloca = (indice + deslocamento) % 26;
					// codifica
					cipher += lower.charAt(desloca);


				} else { // MAIUSCULAS
					// define o indice da letra coletada.
					int indice = indexOf(letra, upper);
					// Calculate the new index with wrapping
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

	// método auxiliar que encontra o indice de um chae em uma string.
	private static int indexOf(char letra, String alfabeto) {
		int i;
		for (i = 0; i < alfabeto.length(); i++) {
			if (letra == alfabeto.charAt(i)) {
				break;
			}
		}

		return i;
	}

	// método principal de decodificação >> calcula frequencia das letras e gera 3 possibilidades.
	public static String decode(String str) {
		
		String auxiliar = formating(str.toLowerCase());
		String lower = "abcdefghijklmnopqrstuvwxyz";
		
		int[] frequencia = new int[26];
		// calcula frequencia de cada letra.
		for (int i = 0; i < auxiliar.length(); i++) {
			
			char letra = auxiliar.charAt(i);
			if (Character.isLetter(letra)) {
				frequencia[indexOf(letra, lower)]++;
				
			}
		}

		int maior = 0;
		int indice = 0;
		// encontra letra com maior frequencia.
		for (int i = 0; i < 26; i++) {
			if (frequencia[i] > maior) {
				maior = frequencia[i];
				indice = i;
			}
		}


		String[] letras = {"a", "e", "o"};
		String[] decodificacoes = new String[letras.length];
		// assume que a letra com maior frequencia é 'a', 'e', ou 'o'.
		for (int i = 0; i < letras.length; i++) {

			// por album motivo só funciona se eu usar string e dps .charAt(0) ????
			int deslocamento = indice - indexOf(letras[i].charAt(0), lower);

			// garante que o deslocamento é um inteiro positivo.
			if (deslocamento < 0) {
				deslocamento += 26;
				
			}

			// gera as três possíveis decodificações.
			decodificacoes[i] = decodeShift(str, deslocamento);
		}

		// retorna a melhor decodificação.
		return bestGuess(decodificacoes);
	}

	// com um int de deslocamento, decodifica a cifragem.
	private static String decodeShift(String str, int deslocamento) {

		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String decoded = ""; // output;

		for (int i = 0; i < str.length(); i++) { // percorre string

			char letra = str.charAt(i);

			if (Character.isLetter(letra)) {
				// char letra == alfabeto.

				if (Character.isLowerCase(letra)) {
					// MINÚSCULA.
					// encontra indice da letra na string.
					int indice = indexOf(letra, lower);
					// calcula o deslocamento.
					int descloca = (indice - deslocamento + 26) % 26;
					decoded += lower.charAt(descloca);

				} else {
					// MAIÚSCULA.
					// encontra indice da letra na string.
					int indice = indexOf(letra, upper);
					// calcula o deslocamento.
					int desloca = (indice - deslocamento + 26) % 26;
					decoded += upper.charAt(desloca);

				}
			} else {
				// char letra != alfabeto.
				decoded += letra;
			}
		}

		return decoded;
	}

	// método auxiliar de decodificação >> calcula frequencia de letras raras na lingua portuguesa.
	private static String bestGuess(String[] decoded) {

		int[] repeticoes = new int[decoded.length]; // repetições por decodificação.

		for (int i = 0; i < decoded.length; i++) {

			String frase = decoded[i]; // decodificação a ser analisada.
			int cont = 0;

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
			// caso  isEqual != {0}.

			int[] indices = isEqual(repeticoes);

			for (int i = 0; i < indices.length; i++) { // percorre indices (isEqual).

				String frase = decoded[indices[i]]; // decodificação a ser analisada.
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
		return decoded[indice];
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