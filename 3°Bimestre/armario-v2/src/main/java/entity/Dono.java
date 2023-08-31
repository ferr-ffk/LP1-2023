package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "donos")
@Table
public class Dono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	public Dono() {}
	
	public Dono(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "n° " + id + ": " + nome;
	}
}
