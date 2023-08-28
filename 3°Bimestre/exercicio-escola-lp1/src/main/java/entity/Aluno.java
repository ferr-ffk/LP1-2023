package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "aluno_tb")
@Table
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String senha;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_notas")
	private List<Nota> notas;

	@Column
	private String nome;

	@Column
	private String prontuario;

	@Column
	private Double media = 0.0;

	@Override
	public String toString() {
		return "[" + prontuario + "]: " + nome + " senha = " + senha + ", notas: " + notas + ", media: " + getMedia();
	}

	public Aluno(String senha, List<Nota> notas, String nome, String prontuario) {
		this.senha = senha;
		this.notas = notas;
		this.nome = nome;
		this.prontuario = prontuario;
		this.media = getMedia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void adicionarNota(Nota nota) {
		notas.add(nota);
		getMedia();
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

	public Double getMedia() {
		notas.forEach(nota -> {
			media += nota.getNota();
		});

		return media / notas.size();
	}
}
