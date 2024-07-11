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

		System.out.println("\n1.");
		int resultado[][] = new int[3][3];
		for (int i = 0; i < matriz1.length; i++) { // linhas
			for (int j = 0; j < matriz1[0].length; j++) { // colunas
				resultado[i][j] = matriz1[i][j] + matriz2[i][j];
				System.out.print(resultado[i][j] + " ");
			}
			System.out.println();
		}


//q2: calcule a média dos elementos de uma matriz
        int soma = 0;
        int contador = 0;
        for (int i = 0; i < matriz1.length; i++) { // linhas
            for (int j = 0; j < matriz1[0].length; j++) { // colunas
                soma = soma + matriz1[i][j];
                contador++;
            }
        }
        double media = soma / contador;
        System.out.println("\n2.");
        System.out.println("total de itens: " + contador);
        System.out.println("soma dos itens: " + soma);
        System.out.println("média dos itens: " + media);


//q3: encontre o maior elemento de uma matriz
        int[][] matriz3 = {
                {5, 8, 3},
                {1, 2, 9},
                {7, 4, 6}
        };
        int maior = matriz3[0][0];
        int linhas = 0;
        int colunas = 0;

        for (int i = 0; i < matriz3.length; i++) { // linhas
            for (int j = 0; j < matriz3[0].length; j++) { // colunas
                if (maior < matriz3[i][j]) {
                    maior = matriz3[i][j];
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

        double[] mediaLinhas = new double[3];
        double[] mediaColunas = new double[3];

        for (int i = 0; i < matriz1.length; i++) { // linhas
            for (int j = 0; j < matriz1[0].length; j++) { // colunas
                if (contador < matriz1.length) {
                    soma = soma + matriz1[i][j];
                    contador++;
                }
                if (contador == matriz1.length) {
                    media = soma / matriz1.length;
                    mediaLinhas[linhas] = media;
                    linhas++;
                    soma = 0;
                    contador = 0;
                }
            }
        }

		for (int i = 0; i < matriz1.length; i++) { // colunas
			for (int j = 0; j < matriz1[0].length; j++) { // linhas
				if (contador < matriz1.length) {
					soma = soma + matriz1[j][i];
					contador++;
				}
				if (contador == matriz1.length) {
					media = soma / matriz1.length;
					mediaColunas[colunas] = media;
					colunas++;
					soma = 0;
					contador = 0;
				}
			}
		}

		System.out.println("\n4. ");
		for (int i = 0; i < mediaLinhas.length; i++) {
			System.out.print(mediaLinhas[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < mediaLinhas.length; i++) {
			System.out.print(mediaColunas[i] + " ");
		}


//q5: crie a matriz identidade de tamanho 'n x n'
		int n = 10;
		int[][] matriz4 = new int[n][n];

		System.out.println("\n\n5.");
		for (int i = 0; i < matriz4.length; i++) {
			matriz4[i][i] = 1;
			for (int j = 0; j < matriz4[0].length; j++) {
				System.out.print(matriz4[i][j] + " ");
			}
			System.out.println();
		}


//q6: calcule o produto escalar de duas matrizes
		System.out.println("\n\n6.");
		for (int i = 0; i < matriz1.length; i++) { // linhas
			for (int j = 0; j < matriz1[0].length; j++) { // colunas
				resultado[i][j] = 0; // depois de cada elemento, a soma zera;
				for (int k = 0; k < matriz1.length; k++) { // linhas e colunas
					resultado[i][j] = resultado[i][j] + (matriz1[i][k] * matriz2[k][j]);
				}
				System.out.print(resultado[i][j] + " ");
			}
			System.out.println();
		}


//q7: transponha uma matriz
		int[][] transposta = new int[matriz1[0].length][matriz1.length];

		for (int i = 0; i < transposta.length; i++) {
			for (int j = 0; j < transposta[0].length; j++) {
				transposta[j][i] = matriz1[i][j];
			}
		}

		System.out.println("\n\n7.");
		for (int i = 0; i < transposta.length; i++) {
			for (int j = 0; j < transposta[0].length; j++) {
				System.out.print(transposta[i][j] + " ");
			}
			System.out.println();
		}


//q8: construa a tabuada do 0 ao 10
		int[][] tabuada = new int[11][11];

		for (int i = 0; i < tabuada.length; i++) {
			for (int j = 0; j < tabuada[0].length; j++) {
				tabuada[i][j] = i * j;
			}
		}
		System.out.println("\n8. " + tabuada[7][8]);

//end
	}
}