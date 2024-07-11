package src;
public class Main {
    public static void main(String[] args) {

// q1: soma dos elementos de uma matriz
        int[][] matriz1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matriz2 = {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
        };

        int resultado[][] = new int[3][3];
        for (int i = 0; i < matriz1.length; i++) { // linhas
            for (int j = 0; j < matriz1[0].length; j++) { // colunas
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        // imprimindo
        System.out.println("\n1.");
        for (int i = 0; i < resultado.length; i++) { // linhas
            for (int j = 0; j < resultado[0].length; j++) { // colunas
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }


//q2: calcule a média dos elementos de uma matriz
        int[][] matriz3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int soma = 0;
        int contador = 0;
        for (int i = 0; i < matriz3.length; i++) { // linhas
            for (int j = 0; j < matriz3[0].length; j++) { // colunas
                soma = soma + matriz3[i][j];
                contador++;
            }
        }
        double media = soma / contador;
        System.out.println("\n2.");
        System.out.println("total de itens: " + contador);
        System.out.println("soma dos itens: " + soma);
        System.out.println("média dos itens: " + media);


//q3: encontre o maior elemento de uma matriz
        int[][] matriz4 = {
                {5, 8, 3},
                {1, 2, 9},
                {7, 4, 6}
        };

        int maior = matriz4[0][0];
        int linhas = 0;
        int colunas = 0;
        for (int i = 0; i < matriz4.length; i++) { // linhas
            for (int j = 0; j < matriz4[0].length; j++) { // colunas
                if (maior < matriz4[i][j]) {
                    maior = matriz4[i][j];
                    linhas = i + 1;
                    colunas = j + 1;
                    break;
                }
            }
        }
        System.out.println("\n3.");
        System.out.println("maior item: " + maior);
        System.out.println("posição: " + linhas + " x " + colunas);


//q4: encontre a média de cada linha e coluna de uma martriz
        linhas = 0;
        colunas = 0;
        soma = 0;
        contador = 0;

        int[][] matriz5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[] mediaLinhas = new double[3];
        double[] mediaColunas = new double[3];

        for (int i = 0; i < matriz5.length; i++) { // linhas
            for (int j = 0; j < matriz5[0].length; j++) { // colunas

                if (contador < matriz5.length) {
                    soma = soma + matriz5[i][j];
                    contador++;
                }
                if (contador == matriz5.length) {
                    media = soma / matriz5.length;
                    mediaLinhas[linhas] = media;
                    linhas++;
                    soma = 0;
                    contador = 0;
                }

            }
        }

        System.out.println("\n4. ");
        for (int i = 0; i < mediaLinhas.length; i++) {
            System.out.print(mediaLinhas[i] + " ");
        }


        for (int i = 0; i < matriz5.length; i++) { // colunas
            for (int j = 0; j < matriz5[0].length; j++) { // linhas

                if (contador < matriz5.length) {
                    soma = soma + matriz5[j][i];
                    contador++;
                }
                if (contador == matriz5.length) {
                    media = soma / matriz5.length;
                    mediaColunas[colunas] = media;
                    colunas++;
                    soma = 0;
                    contador = 0;
                }

            }

        }

        System.out.println();
        for (int i = 0; i < mediaColunas.length; i++) {
            System.out.print(mediaColunas[i] + " ");
        }


//q5: crie a matriz identidade de tamanho 'n x n'
        int n = 10;
        int[][] matriz6 = new int[n][n];

        for (int i = 0; i < matriz6.length; i++) {
            matriz6[i][i] = 1;
        }

        System.out.println("\n\n5.");
        for (int i = 0; i < matriz6.length; i++) {
            for (int j = 0; j < matriz6[0].length; j++) {
                System.out.print(matriz6[i][j] + " ");
            }
            System.out.println();
        }


//q6: calcule o produto escalar de duas matrizes


//q7: transponha uma matriz
        int[][] matriz7 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] transposta = new int[matriz7[0].length][matriz7.length];

        for (int i = 0; i < transposta.length; i++) {
            for (int j = 0; j < transposta[0].length; j++) {
                transposta[j][i] = matriz7[i][j];
            }
        }


        System.out.println("\n\n7.");
        for (int i = 0; i < transposta.length; i++) {
            for (int j = 0; j < transposta[0].length; j++) {
                System.out.print(transposta[i][j] + " ");
            }
            System.out.println();
        }


//q8: multiplicação de matrizes
        int[][] matriz9 = {
                {1, 2},
                {3, 4},
        };
        int[][] matriz10 = {
                {5, 6},
                {7, 8}
        };

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {

//                resultado[i][j] = (matriz9[i][j] * matriz10[i][j]) + (matriz9[i + 1][j] * matriz10[i + 1][j + 1]);

            }
        }

        System.out.println("\n\n8.");
        for (int i = 0; i < matriz9.length; i++) {
            for (int j = 0; j < matriz10[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

    }
}