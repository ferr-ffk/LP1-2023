package prova2bi;

import prova2bi.model.ItemPedido;
import prova2bi.model.Orcamento;
import prova2bi.model.Pedido;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ItemPedido item1 = new ItemPedido("Bermuda", "Jogger", "G", 5.0);
		item1.exibir(true);
		System.out.println();
		item1.exibir(false);
		System.out.println();
		
		Orcamento orc = new Orcamento();
		orc.addItem(item1);
		orc.exibir(true);
		System.out.println();
		orc.exibir(false);
		
		ItemPedido item2 = new ItemPedido("calça", "sla man", "P", 19.0);
		orc.addItem(item2);
		System.out.println();
		
		orc.exibir(true);
		orc.removerItem(1L);
		System.out.println("\nitem2: " + item2.getId());
		orc.exibir(true);
		orc.removerItem(19l);
		orc.exibir(true);
		
		Pedido pedido1 = new Pedido("19/06/2023");
		pedido1.exibir(true);
		pedido1.exibir(false);
		pedido1.entregar();
		pedido1.entregar();
	}
}
