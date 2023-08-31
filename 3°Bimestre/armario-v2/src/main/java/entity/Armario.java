package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "armarios")
@Table
public class Armario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer capacidade;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_dono")
	private Dono dono;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_acessorio")
	private List<Acessorio> acessorios;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_roupa")
	private List<Roupa> roupas;

	public Armario() {
	}

	public Armario(Dono dono, Integer capacidade) {
		if (capacidade < 0) {
			throw new RuntimeException("A capacidade não pode ser menor que zero!");
		}

		this.dono = dono;
		this.capacidade = capacidade;
		this.acessorios = new ArrayList<Acessorio>();
		this.roupas = new ArrayList<Roupa>();
	}

	public void adicionarRoupa(Roupa roupa) {
		if (ocupacao() < capacidade) {
			roupas.add(roupa);
			return;
		}

		throw new RuntimeException("O armário está cheio!");
	}

	public void adicionarAcessorio(Acessorio acessorio) {
		if (ocupacao() < capacidade) {
			acessorios.add(acessorio);
			return;
		}

		throw new RuntimeException("O armário está cheio!");
	}

	private Integer ocupacao() {
		return roupas.size() + acessorios.size();
	}

	@Override
	public String toString() {
		return "Armario [" + id + "]: Dono: " + dono + ", está com estilo!" + "\nRoupas: " + exibirRoupas()
				+ "\nAcessórios: " + exibirAcessorios() + "\nEstá com " + ocupacao() + " roupas/acessórios, até "
				+ capacidade;
	}

	private String exibirRoupas() {
		StringBuilder sb = new StringBuilder();

		roupas.forEach(r -> {
			sb.append(r);
			sb.append(System.getProperty("line.separator"));
		});

		return sb.toString();
	}

	private String exibirAcessorios() {
		StringBuilder sb = new StringBuilder();

		acessorios.forEach(a -> {
			sb.append(a);
			sb.append(System.getProperty("line.separator"));
		});

		return sb.toString();
	}

}
