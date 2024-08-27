package src;

import java.util.Arrays;
import java.util.Scanner;

public class Sobral {

	static boolean compare(String[] arr1, String[] arr2) {

		if (arr1.length != arr2.length) {
			return false;
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < arr1.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				return false;
			}
		}

		return true;
	}

	static boolean compara_conjuntos(String[] conjunto1, String[] conjunto2) {

		if (conjunto1.length != conjunto2.length) {
			return false;
		}

		int contador = 0;
		for (int i = 0; i < conjunto1.length; i++) {
			for (int j = 0; j < conjunto2.length; j++) {
				if (conjunto1[i].equals(conjunto2[j])) {
					contador++;
				}
			}
		}

		if (contador == conjunto1.length) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("\n\ndigite conjunto 1: ");
		String str1 = scanner.nextLine();
		System.out.print("digite conjunto 2: ");
		String str2 = scanner.nextLine();


		String[] conjunto1 = str1.split(",");
		String[] conjunto2 = str2.split(",");

		System.out.println("\n\n" + compare(conjunto1, conjunto2));

		scanner.close();
	}

}
