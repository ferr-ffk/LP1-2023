package collections.atividadePratica0106.model;

import collections.atividadePratica0106.interfaces.Comercializar;

public abstract class Item implements Comercializar{
	protected static Long idBase = 0L;
	protected Long id;
	protected String nome;
	protected Double preco;
	
	@Override
	public String toString() {
		return String.format("[id: %d, nome: %s, preco: %,f]", id, nome, preco);
	}

	public Item(String nome, Double preco) {
		this.id = idBase++;
		this.nome = nome;
		this.preco = preco;
	}

	public static Long getIdBase() {
		return idBase;
	}

	public static void setIdBase(Long idBase) {
		Item.idBase = idBase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
