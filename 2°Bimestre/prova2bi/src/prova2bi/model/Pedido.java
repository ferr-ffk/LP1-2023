package prova2bi.model;

import prova2bi.repository.ExibirInterface;

/* A classe Pedido descreve um pedido e herda de Orcamento por isso tudo para
	Orcamento � valido para Pedido.
		 Somente a dataEntrega pode ser alterada por um setter.
		 O contrutor do pedido s� recebe a dataEntrega e inicia o entregue com
 		  false automaticamente*/

public class Pedido extends Orcamento implements ExibirInterface {
	private String dataEntrega;
	private Boolean entregue;

	public Pedido(String dataEntrega) {
		this.dataEntrega = dataEntrega;
		this.entregue = false;
	}

	@Override
	public void exibir(Boolean isCompleta) {
		if(isCompleta) {
			exibirPedidoCompleto(this);
		} else {
			exibirPedidoReduzido(this);
		}
	}

	public void entregar() {
		try {
			if (this.entregue) {
				throw new Exception();
			} else {
				this.entregue = true;
			}
		} catch (Exception e) {
			System.err.println("\nO pedido já foi entregue!");
		}
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getEntregue() {
		return entregue;
	}

	private void exibirPedidoCompleto(Pedido p) {
		System.out.println("Pedido: " + p.getId());
		System.out.println("Itens:");
		itens.forEach((item) -> {
			System.out.println("- " + item.getPeca() + ", " + item.getModelo() + ", " + item.getTamanho() + ", "
					+ item.getValor());
		});
		System.out.println("Data de Entrega: " + p.getDataEntrega());
		System.out.println("Situa��o: ");
		if(entregue) {
			System.out.print("Entregue"); 
		} else {
			System.out.print("N�o entregue");
		}
		System.out.println("Valor Total: R$" + p.getValorTotal());
	}
	
	private void exibirPedidoReduzido(Pedido p) {
		System.out.print("- " + p.getId());
		System.out.printf(", %s", p.getDataEntrega());
		if(p.entregue) {
			System.out.print("Entregue");
		} else {
			System.out.print("N�o entregue");
		}
		System.out.printf(", %s", p.getValorTotal());
	}
}