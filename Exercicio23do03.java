package codigosFederal;

import java.util.Scanner;

public class Exercicio23do03 {

	static String nomes[] = new String[3];
	static double contas[][] = new double[4][4];

	private static void exibirNomes(String nomes[]) {
		System.out.println("Nomes digitados:");
		for (String nome : nomes) {
			System.out.println(nome);
		}
	}

	private static void exibirNomes(int num) {
		if (num == 1) {
			System.out.printf("Primeiro nome: \n%s \n", nomes[0]);
		} else if (num > 1 && num <= 10) {
			System.out.printf("Segundo nome: \n%s \n", nomes[1]);
		} else if (num > 10) {
			System.out.printf("Terceiro nome:\n%s \n", nomes[2]);
		} else {
			System.out.println("Opção Inválida!");
		}
	}

	private static void exibirMatriz(double matriz[][]) {
		System.out.println("Valores digitados:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.printf("[%.2f] ", matriz[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double valores[] = new double[4];
		int opcao = 0;
		int a = 0;

		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Digite um nome:");
			nomes[i] = entrada.nextLine();
		}

		exibirNomes(nomes);

		for (int i = 0; i < 4; i++) {
			System.out.println("Digite um numero de opção:");
			opcao = entrada.nextInt();
			exibirNomes(opcao);
		}

		System.out.println("Digite o primeiro valor");
		valores[0] = entrada.nextDouble();
		System.out.println("Digite o segundo valor");
		valores[1] = entrada.nextDouble();
		System.out.println("Digite o terceiro valor");
		valores[2] = entrada.nextDouble();

		for (int i = 1; i < contas.length; i++) {
			a = i - 1;
			contas[0][i] = valores[a];
		}

		for (int i = 1; i < contas.length; i++) {
			a = i - 1;
			contas[i][0] = valores[a];
		}

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				if (i == j) {
					contas[i][j] = valores[i - 1] * valores[j - 1];
				} else {
					contas[i][j] = valores[i - 1] - valores[j - 1];
				}
			}
		}

		exibirMatriz(contas);
		entrada.close();
	}

}
