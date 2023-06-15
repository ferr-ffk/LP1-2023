package provaPratica2bi.model;

import java.util.ArrayList;
import java.util.List;

import provaPratica2bi.repository.ExibirInterface;

/*
 
   A classe Orcamento descreve um orçamento de um pedido. O construtor dessa
   classe deve ser vazio e todos os valores devem ser alterados automaticamente ou
   através de métodos.
   Essa classe só deve possuir getters e nenhum setter.
   O id deve ser adicionado automaticamente ao criar um orçamento, usando o idBase
   
 */

public class Orcamento implements ExibirInterface {
	private static Long idBase = 0l;
	private Long id;
	protected List<ItemPedido> itens = new ArrayList();
	private Double valorTotal;

	public Orcamento() {
		this.id = idBase++;
	}

	@Override
	public void exibir(Boolean isCompleta) {
		if(isCompleta) {
			exibirCompleto(this);
		} else {
			exibirReduzido(this);
		}
	}

	public Long getId() {
		return id;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public Long getIdBase() {
		return idBase;
	}

	public void addItem(ItemPedido item) {
		itens.add(item);
	}

	public void removerItem(Long id) throws Exception {
		try {
			for (ItemPedido item : itens) {
				if (item.getId() == id) {
					valorTotal -= item.getValor();
					itens.remove(item);
					return;
				}
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println("O item não foi encontrado!");
		}
	}
	
	private void exibirCompleto(Orcamento o) {
		System.out.println("Orçamento" + o.getId());
		itens.forEach((item) -> {
			System.out.printf("- %s, %s, %s, %s", item.getPeca(), item.getModelo(), item.getTamanho(), item.getValor());
		});
		System.out.println("Valor Total: R$" + o.getValorTotal());
	}
	
	
	private void exibirReduzido(Orcamento o) {
		System.out.print("- " + o.getId());
		System.out.printf(", R$%.2f", o.getValorTotal());
	}
}
