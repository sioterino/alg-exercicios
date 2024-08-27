package src;

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
		String decoded = decode(encoded);

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

		// array com todas as decifragens possíveis.
		String[] decifragens = new String[lower.length()];

		// decifra cada deslocamento possível.
		for (int i = 0; i < decifragens.length; i++) {
			decifragens[i] = encode(str, i);
		}

		// retorna a melhor decodificação.
		return decifragem(decifragens);
	}

	// metodo q decodifica contando vogais e consoantes.
	private static String decifragem(String[] decifragens) {

		int[] repeticoes = new int[decifragens.length]; // repetições por decodificação.

		String vogais = "aeiou";
		String consoantes = "bcdfghjklmnpqrstvwxyz";

		for (int i = 0; i < decifragens.length - 1; i++) { // percorre array de decifragens

			int cont = 0;

			for (int j = 0; j < decifragens[i].length() - 1; j++) { // percorre a string armazenada no decifragens[i]

				String antecessor = String.valueOf(decifragens[i].charAt(j)); // consoante.
				String sucessor = String.valueOf(decifragens[i].charAt(j + 1)); // vogal.

				if (consoantes.contains(antecessor) && vogais.contains(sucessor)) {
					// se a consoante for sucedida de uma vogal:
					cont++;
				}
			}
			// armazena no array.
			repeticoes[i] = cont;
		}


		// define o indice da decodificação com a MAIOR frequencia de cosoantes sucedidas por vogal.
		int maior = repeticoes[0];
		int indice = 0;
		for (int i = 1; i < repeticoes.length; i++) {
			if (maior < repeticoes[i]) {
				maior = repeticoes[i];
				indice = i;
			}
		}

		// decodificação com maior ocorrencias de cosoantes sucedidas por vogal.
		return decifragens[indice];
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