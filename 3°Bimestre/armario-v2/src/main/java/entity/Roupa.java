package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "roupas")
@Table
public class Roupa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String cor;
	
	@Column
	private String ocupacao;
	
	@Column
	private String peca;
	
	@Column
	private String tamanho;

	public Roupa() {}
	
	public Roupa(String cor, String ocupacao, String peca, String tamanho) {
		super();
		this.cor = cor;
		this.ocupacao = ocupacao;
		this.peca = peca;
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Roupa: {Cor=" + cor + ", ocupacao=" + ocupacao + ", peca=" + peca + ", tamanho=" + tamanho + "}";
	}
	
}
