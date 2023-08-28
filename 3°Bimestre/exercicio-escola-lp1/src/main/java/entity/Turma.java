package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "turma_tb")
@Table
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@Column
	private Integer horario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "alunos_turmas", joinColumns = @JoinColumn(name = "id_professor"), inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private List<Aluno> alunos;
	
	@Override
	public String toString() {
		return "[" + id + "] Turma " + codigo +  ", Professor: " + professor + ", horario=" + horario + ", alunos=" + alunos;
	}

	@Column
	private String codigo;
	
	public Turma() {}

	public Turma(Professor professor, Integer horario, List<Aluno> alunos, String codigo) {
		this.professor = professor;
		this.horario = horario;
		this.alunos = alunos;
		this.codigo = codigo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	
	
}
