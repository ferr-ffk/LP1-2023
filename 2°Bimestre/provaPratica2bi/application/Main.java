package provaPratica2bi.application;

import provaPratica2bi.model.ItemPedido;
import provaPratica2bi.model.Orcamento;

public class Main {
	
	public static void main(String[] args) {
		ItemPedido item1 = new ItemPedido("Bermuda", "Jogador", "G", 30.0);
		
		item1.exibir(true);
		System.out.println();
		item1.exibir(false);
		
		Orcamento orcamento1 = new Orcamento();
		
		orcamento1.addItem(item1);
		
		orcamento1.exibir(true);
		System.out.println();
		orcamento1.exibir(false);
	}
}
