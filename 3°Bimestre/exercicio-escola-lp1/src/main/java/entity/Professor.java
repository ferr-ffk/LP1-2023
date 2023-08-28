package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "professor_tb")
@Table
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_professor;
	
	@Column
	private String senha;
	
	@Column
	private String cpf;
	
	@Column
	private String nome;
	
	@Column
	private String prontuario;
	
	@Override
	public String toString() {
		return "{[" + id_professor + "]: " + nome + " prontuario = " + prontuario + ", senha = " + senha + ", cpf=" + cpf + "}";
	}

	public Professor() {}
	
	public Professor(String senha, String cpf, String nome, String prontuario) {
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.prontuario = prontuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId_professor() {
		return id_professor;
	}

	public void setId_professor(Long id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
}
