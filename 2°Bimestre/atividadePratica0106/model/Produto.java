package collections.atividadePratica0106.model;

import collections.atividadePratica0106.exception.ComercializarException;

public class Produto extends Item {
	private int estoque;

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Produto(String nome, Double preco, int estoque) {
		super(nome, preco);
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("[Estoque: %,d]", estoque);
	}
	
	@Override
	public void comercializar() {
		try {
			if(estoque <= 0) {
				throw new ComercializarException(String.format("O estoque do produto %s já está vazio!", this.nome));
			} else {
				estoque--;
			}
		} catch (ComercializarException e) {
			System.err.println(e.getMessage());
			estoque = 0;
		}
	}
}
