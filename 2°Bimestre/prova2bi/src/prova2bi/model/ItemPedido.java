package prova2bi.model;

import prova2bi.repository.ExibirInterface;

public class ItemPedido implements ExibirInterface {
	private static Long idBase = 0l;
	private Long id;
	private String peca;
	private String modelo;
	private String tamanho;
	private Double valor;

	@Override
	public void exibir(Boolean isCompleta) {
		if (isCompleta) {
			exibirCompleto(this);
		} else {
			exibirReduzido(this);
		}
	}
	

	public ItemPedido(String peca, String modelo, String tamanho, Double valor) {
		this.peca = peca;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.valor = valor;
		this.id = idBase++;
	}
	

	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return this.id;
	}

	private void exibirCompleto(ItemPedido i) {
		System.out.println("Item do pedido: " + i.getId());
		System.out.println("- Peça: " + i.getPeca());
		System.out.println("- Modelo: " + i.getModelo());
		System.out.println("- Tamanho: " + i.getTamanho());
		System.out.println("- Valor: R$" + i.getValor());
	}
	
	private void exibirReduzido(ItemPedido i ) {
		System.out.printf("- %s, %s, %s, R$%.2f", i.getPeca(), i.getModelo(), i.getTamanho(), i.getValor());
	}
}
