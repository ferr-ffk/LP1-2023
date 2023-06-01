package collections.atividadePratica0106.model;

import collections.atividadePratica0106.exception.ComercializarException;

public class Servico extends Item{
	private Boolean disponivel;
	
	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public void liberar() throws ComercializarException{
		try {
			if(!this.disponivel) {
				this.disponivel = true;
			} else {
				throw new ComercializarException("O produto já está disponível!");
			}
		} catch (ComercializarException e){
			System.out.println(e.getMessage());
		}
	}

	public Servico(String nome, Double preco, Boolean disponivel) {
		super(nome, preco);
		this.disponivel = disponivel;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("[Disponivel: %b]", disponivel);
	}
	
	@Override
	public void comercializar() {
		try {
			if(this.disponivel) {
				this.disponivel = false;
			} else {
				throw new ComercializarException("O produto já não está disponível!");
			}
		} catch (ComercializarException e){
			System.out.println(e.getMessage());
		}
	}
}
