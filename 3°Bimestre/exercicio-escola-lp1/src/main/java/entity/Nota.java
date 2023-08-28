package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "boletim_tb")
@Table
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@Column
	private Double nota;

	public Nota(Turma turma, Double nota) {
		if(nota > 10 || nota < 0) {
			throw new RuntimeException("A nota é um número inválido!");
		}
		this.turma = turma;
		this.nota = nota;
	}
	
	public Nota(Double nota) {
		if(nota > 10 || nota < 0) {
			throw new RuntimeException("A nota é um número inválido!");
		}
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return nota.toString();
	}

	public Long getId_nota() {
		return id;
	}

	public void setId_nota(Long id_nota) {
		this.id = id_nota;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	
	
	
}
