package collections.atividadePratica0106.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Item> itens = new ArrayList<Item>();

	public void addItem(Item i) {
		itens.add(i);
	}

	public void listarItens() {
		System.out.printf("[");
		for (Item i : itens) {
			System.out.println(i + ", ");
		}
		System.out.printf("]");
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void comercializarItem(Long idEntrada) {
		for (Item item : itens) {
			if(item.id == idEntrada) {
				item.comercializar();
				return;
			}
		}
		System.out.println("Id não encontrado");
	}

	public Empresa() {
		
	}
	
	@Override
	public String toString() {
		String empresa = "[";
		for(Item item : itens) {
			empresa += item + "\n";
		}
		return empresa + "]";
	}
}
