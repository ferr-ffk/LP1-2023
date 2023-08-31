package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "acessorios")
@Table
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String tipo;
	
	@Column
	private String peca;
	
	@Column
	private Integer ocupacao;

	public Acessorio() {}
	
	public Acessorio(String tipo, String peca, Integer ocupacao) {
		super();
		this.tipo = tipo;
		this.peca = peca;
		this.ocupacao = ocupacao;
	}

	@Override
	public String toString() {
		return "Acessorio: {Tipo=" + tipo + ", peca=" + peca + ", ocupacao=" + ocupacao + "}";
	}
	
}
