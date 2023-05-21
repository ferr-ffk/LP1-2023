package exercicios.exGastos.application;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Variavel v1 = new Variavel("Parcela de Carro", 189.90, 18);
		Variavel v2 = new Variavel("Fatura do cartão", 45, 2);
		List<Variavel> gastosVariaveis = new ArrayList<>();
		gastosVariaveis.add(v1, v2);
		
		for(Variavel gasto: gastosVariaveis) {
			System.out.println("Nome: " + gasto.nome);
			System.out.println("Valor: " + gasto.valor);
			System.out.println("Tempoe em meses: " + gasto.tempoMeses);
		}
		
		Lazer l1 = new Lazer("Assinatura de jogos", 44.90, true);
		Lazer l2 = new Lazer("Shopping", 89.90, false);
		Lazer l3 = new Lazer("Livros digitais", 12.9, true);
		List<Lazer> gastosLazer = new ArrayList();
		gastosLazer.add(l1, l2, l3);
		
		for(Lazer gasto: gastosLazer) {
			System.out.println("Nome: " + gasto.nome);
			System.out.println("Valor: " + gasto.valor);
			System.out.println("Tempoe em meses: " + gasto.tempoMeses);
		}
	}

}
