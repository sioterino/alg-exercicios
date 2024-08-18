package src;

import java.util.Arrays;
import java.util.Scanner;

public class Metodos2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

// q1: calcular a área de um retângulo a partir da base e da altura.
        System.out.println("\n1. area de um retangulo: (b = 7, h = 8) = " + area(7,8));

// q2: calcular a área de um quadrado a partir do seu lado.
        System.out.println("\n2. area de um quadrado: (a = 9) = " + area(9));


// q3: calcular o perímetro de um círculo a partir do seu raio
        System.out.println("\n3. perimetro de um círculo: (r = 7) = " + perimeter(7));


// q4: calcular a área de um círculo a partir do seu perímetro.
        System.out.println("\n4. area dde um círculo: (r = 7) = " + area(perimeter(7)));


// q5: somar os dígitos de um número.
        System.out.println("\n5. soma dos digitos: (1234) = " + somaDigitos(1234));


// q6: calcular o MDC (máximo divisor comum) de dois números inteiros.
        System.out.println("\n6. mdc: (132, 165) = " + mdc(132, 165));


// q7: calcular o MDC dos números em um array de inteiros, alterando o metodo anterior.
		int[] numeros = {630, 504, 378, 252};
		System.out.println("\n7. mdc: " + formating(numeros) + " = " + mdc(numeros));


// q8: converter a temperatura de Celsius para Fahrenheit
        System.out.println("\n8. C: 25 >> F: " + c2f(25));


// q9: ordenar de forma crescente um array de inteiros.
		int[] random = {23, 87, 12, 45, 56, 89, 78, 32, 90, 67, 21, 5, 34, 76, 49};
		System.out.println("\n9. ordenando crescente: (select sort)");
		System.out.println(Arrays.toString(random));
		System.out.println(Arrays.toString(crescente(random)));


// q10: ordenar de forma crescente um array de caracteres.
		char[] naturais = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
		System.out.println("\n10. ordenando char[] em crescente: (select sort)");
		System.out.println(formating(naturais));
		System.out.println(formating(crescente(naturais)));


// q11: busca linear de um valor em um array de inteiros, retorne o índice do valor no array ou -1 caso o valor não seja encontrado.
        System.out.println("\n11. busca linear:");
		System.out.println(formating(random));
		System.out.println("indice encontrado: 	   (67) " + buscaLinear(random, 67));
		System.out.println("indice não encontrado: (7) " + buscaLinear(random, 7));


// q12: testar se um array de inteiros está ordenado de forma crescente
		int[] paradigma = {23, 87, 12, 45, 56, 89, 78, 32, 90, 67, 21, 5, 34, 76, 49};
        System.out.println("\n12. conferindo se um int[] está ordenado:");
		System.out.println(formating(paradigma) + " " + isSortedCres(paradigma));
		System.out.println(formating(crescente(paradigma)) + " " + isSortedCres(crescente(paradigma)));


// q13: testar se um array de inteiros está ordenado, retorne caso:
// crescente    = 1;
// decrescente  = -1;
// default      = 0;
		int[] polymídio = {23, 87, 12, 45, 56, 89, 78, 32, 90, 67, 21, 5, 34, 76, 49};
		System.out.println("\n12. conferindo se um int[] está ordenado:");
		System.out.println(formating(polymídio) + " " + isSorted(polymídio));
		System.out.println(formating(decrescente(polymídio)) + " " + isSorted(decrescente(polymídio)));
		System.out.println(formating(crescente(polymídio)) + " " + isSorted(crescente(polymídio)));


// q14: busca binária de um valor em um array de inteiros, retorne o indice ou -1.
		System.out.println("\n11. busca binária:");
		System.out.println(formating(polymídio));
		System.out.println("indice encontrado: 	   (32) " + buscaBinaria(polymídio, 32));
		System.out.println("indice não encontrado: (9) " + buscaBinaria(polymídio, 9));


// q15: busca de um valor em um array de inteiros, caso esteja ordenado, faça busca binária, caso contrário faça uma busca linear.
		int[] paralelepipedo = {23, 87, 12, 45, 56, 89, 78, 32, 90, 67, 21, 5, 34, 76};
        System.out.println("\n15. verifica se está ordenado e executa a melhor opção de busca");
		System.out.println(formating(paralelepipedo));
		System.out.println("indice encontrado: 	   (32) " + busca(paralelepipedo, 32));
		System.out.println("indice não encontrado: (9) " + busca(paralelepipedo, 9) + "\n");

		System.out.println(formating(crescente(paralelepipedo)));
		System.out.println("indice encontrado: 	   (32) " + busca(crescente(paralelepipedo), 32));
		System.out.println("indice não encontrado: (9) " + busca(crescente(paralelepipedo), 9));


// q16:  calcular a mediana de um array de inteiros.
        System.out.println("\n16. mediana: " + formating(paralelepipedo) + " " + mediana(paralelepipedo));


// q17:  calcular a moda de um array de inteiros.
		char[] frequencia = {'i', 'i', 'u', 'e', 'o', 'o', 'a', 'i', 'e', 'u', 'o', 'u', 'a', 'e', 'u'};
		moda(frequencia);


// q18: fazer a cifragem de César de uma string.
// A cifragem de César é uma técnica de criptografia que consiste em substituir cada letra do texto por outra letra que esteja um número fixo de posições à frente no alfabeto
        String cipher = CaesarCipher.encode("Panetone", 7);
		System.out.println("\n18. " + cipher);


// q19: fazer a decifragem de César de uma string.
		String decoded  = CaesarCipher.decode(cipher);
        System.out.println("\n19. " + decoded);

    }

	// q1!
    static int area(int b, int h) {
        return b * h;
    }

	// q2!
    static int area(int a) {
        return a * a;
    }

	// q3!
    static double perimeter(int radius) {
        return Math.PI * 2 * radius;
    }

	// q4!
    static double area(double perimeter) {

        double radius = perimeter / (Math.PI * 2);

        return radius * radius * Math.PI;
    }

	// q5!
    static int somaDigitos(int numero) {

        int soma = 0;
        while (numero > 0) {
            soma += numero % 10;
            numero = numero / 10;
        }

        return soma;
    }

	// q6!
    static int mdc(int a, int b) {


        // ordenando entre maior e menor
        int maior = a;
        int menor = b;
        if (b > a) {
            menor = a;
            maior = b;
        }

        int mdc = 1;

        for (int i = menor; i > 0; i--) {
            if (maior % i == 0 && menor % i == 0) {
                mdc = i;
                break;
            }
        }

        return mdc;

    }

	// q7!
    static int mdc(int[] numeros) {

		int cont;
        int mdc = 1;
        numeros = crescente(numeros);

        for (int i = numeros[0]; i > 0; i--) {
			cont = 0;

            for (int j = 0; j < numeros.length; j++) {
				if (numeros[j] % i == 0) {
					cont++;
				}
			}

			if (cont == numeros.length) {
				mdc = i;
				break;
			}
		}

        return mdc;
    }

	// q8!
	static int c2f(int celcius) {
		return ((celcius*9)+160)/5;
	}

	// q9!
	static int[] crescente(int[] numeros) {

		for (int i = 0; i < numeros.length; i++) { // percorre numeros
			for (int j = i + 1; j < numeros.length; j++) { // percorre sucessor dos numeros

				if (numeros[i] > numeros[j]) {
					int temp = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = temp;
				}
			}
		}

		return numeros;
	}

	// q10!
	static char[] crescente(char[] numeros) {

		int[] inteiros = new int[numeros.length];

		// tranforma char[] >> int[].
		for (int i = 0; i < numeros.length; i++) {
			inteiros[i] = Character.getNumericValue(numeros[i]);
		}

		// ordena.
		inteiros = crescente(inteiros);

		// tranforma int[] >> cahr[].
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (char) (inteiros[i] + '0');
		}

		return numeros;

	}

	// q11!
	static int buscaLinear(int[] numeros, int alvo) {

		boolean achou = false;

		int i;
		for (i = 0; i < numeros.length; i++) {
			if (numeros[i] == alvo) {
				achou = true;
				break;
			}
		}

		if (!achou) {
			i = -1;
		}

		return i;
	}

	// q12!
	static boolean isSortedCres(int[] numeros) {

		// select sort normal
		for (int i = 0; i < numeros.length; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				// ao inves de trocar os numeros, apenas retorna falso.
				if (numeros[i] > numeros[j]) {
					return false;
				}

			}
		}

		return true;
	}

	//q13!
	static int isSorted(int[] numeros) {

		//usa mérodo anterior
		if (isSortedCres(numeros)) {
			return 1; // crescente
		}

		// select sort normal mas testa pra decrescente.
		for (int i = 0; i < numeros.length; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				// ao inves de trocar os numeros, apenas retorna falso.
				if (numeros[i] < numeros[j]) {
					return 0; // não ordenado
				}

			}
		}

		return -1; // decrescente
	}

	// q14!
	static int buscaBinaria(int[] numeros, int alvo) {

		numeros = crescente(numeros);

		int inicio = 0;
		int fim = numeros.length - 1;

		while (inicio <= fim) {
			int meio = inicio + (fim - inicio) / 2; // indice do meio!

			if (numeros[meio] == alvo) {
				// alvo é o meio.
				return meio;

			} else if (numeros[meio] > alvo) {
				// alvo ta na esquerda (menores).
				fim = meio - 1;

			} else {
				// alvo ta na direita (maiores).
				inicio = meio + 1;
			}

		} // end loop.

		return -1;
	}

	// q15!
	static int busca(int[] numeros, int alvo) {

		int sorted = isSorted(numeros);

		if (sorted == 0) {
			// não ordenado:
			return buscaLinear(numeros, alvo);
		} else {
			// ordenado:
			return buscaBinaria(numeros, alvo);
		}
	}

	// q16!
	static double mediana(int[] numeros) {

		numeros = crescente(numeros);
		int meio = (numeros.length - 1) / 2; // indice do meio!

		if (numeros.length % 2 == 0) {
			// caso exista um numero PAR de itens no int[].
			return (double) (numeros[meio] + numeros[meio + 1]) / 2;
		} else {
			// caso exista um numero IMPAR de itens no int[].
			return (numeros[meio]);
		}
	}

	// q17!
	static char moda(char[] letras) {

		int contador;
		int[] frequencia = new int[letras.length];

		// conta frequencia.
		for (int i = 0; i < frequencia.length; i++) {
			contador = 0;
			char letra = letras[i];
			for (int j = 0; j < frequencia.length; j++) {
				if (letra == letras[j]) {
					contador++;
				}
			}
			frequencia[i] = contador;
		}

		// descobre maior frequencia.
		int maior = frequencia[0];
		for (int i = 0; i < frequencia.length; i++) {
			if (maior < frequencia[i]) {
				maior = frequencia[i];
			}
		}

		// encontra indice da maior frequencia
		int indice;
		for (indice = 0; indice < frequencia.length; indice++) {
			if (maior == frequencia[indice]) {
				break;
			}
		}

		System.out.println("\n17. encontra moda: " + letras[indice] + " (" + frequencia[indice] + ")");
		System.out.println(formating(letras));
		System.out.println(formating(frequencia));

		// encontra moda.
		return letras[indice];
	}



	// extras
	static int[] decrescente(int[] numeros) {

		for (int i = 0; i < numeros.length; i++) { // percorre numeros
			for (int j = i + 1; j < numeros.length; j++) { // percorre sucessor dos numeros

				if (numeros[i] < numeros[j]) {
					int temp = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = temp;
				}
			}
		}

		return numeros;
	}

	static String formating(int[] arr){
		return Arrays.toString(arr).replace(']',')').replace('[','(');
	}

	static String formating(char[] arr){
		return Arrays.toString(arr).replace(']',')').replace('[','(');
	}

}
