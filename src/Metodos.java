package src;

import java.util.Scanner;
import java.util.Arrays;

public class Metodos {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("\nforneça um texto: ");
        String palavra = scanner.nextLine();
        palavra = tratamento(palavra);

        System.out.print("\nforneça um tamanho para um array de inteiros: ");
        int tamanho = scanner.nextInt();

        int[] inteiros = new int[tamanho];
        inteiros = preencher(inteiros);

//q1: some 3 números distintos.
        System.out.println("\n1. " + somaInteiros(1,2,3));

//q2: soma de uma array de inteiros.
        System.out.println("\n2. " + somaArray(inteiros));

//q3: média de notas.
        System.out.println("\n3. " + media(inteiros));

//q4: retorne o maior valor de uma array de inteiros.
        System.out.println("\n4. " + maior(inteiros));

//q5: conte o número de vogais de uma string.
        System.out.println("\n5. " + vogais(palavra));

//q6: conte quantas vezes uma caractere é repetida em uma string.
        System.out.println("\n6. " + repetição(palavra, 'o'));

//q7: inverta uma string.
        System.out.println("\n7. " + inverter(palavra));

//q8: descubra se uma string é um palíndromo.
        System.out.println("\n8. " + palindromo(palavra));

//q9: preencha uma array de inteiros com valores fornecidos pelo usuário.
        System.out.println(Arrays.toString(preencher(inteiros)));

//q10: zere todos os valores de uma array de inteiros.
        System.out.println("\n10. " + Arrays.toString(zerar(inteiros)));

//q11: encontre o meio de uma string.
        System.out.println("\n11. " + meio(palavra));

        scanner.close();

    }

    static int somaInteiros(int a, int b, int c) {
        int soma = a + b + c;
        return soma;
    }

    static int somaArray(int[] inteiros) {
        int soma = 0;
        for (int i = 0; i < inteiros.length; i++) {
            soma += inteiros[i];
        }
        return soma;
    }

    static double media(int[] inteiros) {
        double media = (double) somaArray(inteiros) / inteiros.length;
        return media;

    }

    static int maior(int[] inteiros) {
        int maior = inteiros[0];
        for (int i = 1; i< inteiros.length; i++) {
            if (inteiros[i] > maior) {
                maior = inteiros[i];
            }
        }
        return maior;

    }

    static int vogais(String input) {
        input = input.toLowerCase();

        int vogais = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u':
                    vogais++;
            }
        }
        return vogais;

    }

    static int repetição(String input, char letra) {
        input = input.toLowerCase();

        int times = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == letra) {
                times++;
            }
        }

        return times;
    }

    static String inverter(String input) {
        String invertida = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }
        return  invertida;

    }

    static boolean palindromo(String input) {
        input = tratamento(input);
        boolean palidromo = false;
        if (input.equals(inverter(input))) {
            palidromo = true;
        }
        return palidromo;

    }

    static int[] preencher(int[] inteiros) {
        System.out.print("\n9. insira " + inteiros.length + " valores inteiros: ");
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = scanner.nextInt();
        }
        return inteiros;
    }

    static int[] zerar(int[] inteiros) {
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = 0;
        }
        return inteiros;
    }

    static String meio(String input) {
        String meio = "";
        int metade = input.length() / 2;

        if (input.length() % 2 != 0) {
            meio = String.valueOf(input.charAt(metade));
        } else {
            meio = input.substring(metade - 1, metade + 1);
        }
        return meio;
    }

    static String tratamento(String input) {
        input= input.toLowerCase();

        String[] replace = {" ", ".", ",", "!", "?"};
        for (int i = 0; i < replace.length; i++) {
            input = input.replace(replace[i], "");
        }
        return input;
    }

}
