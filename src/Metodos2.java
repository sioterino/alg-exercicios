package src;

import java.util.Arrays;
import java.util.Scanner;

public class Metodos2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

// q1: calcular a área de um retângulo a partir da base e da altura.
        System.out.println("\n1. " + area(7,8));

// q2: calcular a área de um quadrado a partir do seu lado.
        System.out.println("\n2. " + area(9));


// q3: calcular o perímetro de um círculo a partir do seu raio
        System.out.println("\n3. " + perimeter(7));


// q4: calcular a área de um círculo a partir do seu perímetro.
        System.out.println("\n4. " + area(perimeter(7)));


// q5: somar os dígitos de um número.
        System.out.println("\n5. " + somaDigitos(1234));


// q6: calcular o MDC (máximo divisor comum) de dois números inteiros.
        System.out.println("\n6. " + mdc(132, 165));


// q7: calcular o MDC dos números em um array de inteiros, alterando o metodo anterior.
        int[] numeros = {1,2,3,4,5,6,7,8,9};
        crescente(numeros);
//        System.out.println("\n7. " + );


// q8: converter a temperatura de Celsius para Fahrenheit
//        System.out.println("\n8. " + );


// q9: ordenar de forma crescente um array de inteiros.
//        System.out.println("\n9. " + );


// q10: ordenar de forma crescente um array de caracteres.
//        System.out.println("\n10. " + );


// q11: busca linear de um valor em um array de inteiros, retorne o índice do valor no array ou -1 caso o valor não seja encontrado.
//        System.out.println("\n11. " + );


// q12: testar se um array de inteiros está ordenado de forma crescente
//        System.out.println("\n12. " + );


// q13: testar se um array de inteiros está ordenado, retorne caso:
// crescente    = 1;
// decrescente  = 1;
// default      = 0;
//        System.out.println("\n13. " + );


// q14: busca binária de um valor em um array de inteiros, retorne o indice ou -1.
//        System.out.println("\n14. " + );


// q15: busca de um valor em um array de inteiros, caso esteja ordenado, faça busca binária, caso contrário faça uma busca linear.
//        System.out.println("\n15. " + );


// q16:  calcular a mediana de um array de inteiros.
//        System.out.println("\n16. " + );


// q17:  calcular a moda de um array de inteiros.
//        System.out.println("\n17. " + );


// q18: azer a cifragem de César de uma string.
// A cifragem de César é uma técnica de criptografia que consiste em substituir cada letra do texto por outra letra que esteja um número fixo de posições à frente no alfabeto
//        System.out.println("\n18. " + );


// q19: fazer a decifragem de César de uma string.
//        System.out.println("\n19. " + );

    }

    static int area(int b, int h) {
        return b * h;
    }

    static int area(int a) {
        return a * a;
    }

    static double perimeter(int radius) {
        return Math.PI * 2 * radius;
    }

    static double area(double perimeter) {

        double radius = perimeter / (Math.PI * 2);

        return radius * radius * Math.PI;
    }

    static int somaDigitos(int numero) {

        int soma = 0;
        while (numero > 0) {
            soma += numero % 10;
            numero = numero / 10;
        }

        return soma;
    }

    static int mdc(int a, int b) {


        // ordenando entre maior e menor
        int maior = a;
        int menor = b;
        if (b > a) {
            menor = a;
            maior = b;
        }

        int mdc = menor;

        for (int i = menor; i > 0; i--) {
            if (maior % i == 0 && menor % i == 0) {
                mdc = i;
                break;
            }

        }

        return mdc;

    }

    static int mdc(int[] numeros) {

        int mdc = 0;
        numeros = crescente(numeros);

        for (int i = numeros[0]; i > 0; i--) {
            for (int j = 0; j < numeros.length; j++)



            }
        }



        return mdc;
    }

    static int[] crescente(int[] numeros) {

        for (int i = 0; i < numeros.length - 1; i++) { // percorre ordenados
            for (int j = 0; j > numeros.length - 1 - i; j++) {

                if (numeros[j] < numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }

            }
        }

        return numeros;
    }

}
