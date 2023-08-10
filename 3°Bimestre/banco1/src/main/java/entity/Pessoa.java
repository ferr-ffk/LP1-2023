package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column(name = "primeiro_nome")
	private String primeiroNome;

	@Column(name = "segundo_nome")
	private String segundoNome;

	@Column
	private String email;

	public Pessoa() {
	}

	public Pessoa(String primeiroNome, String segundoNome, String email) {
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id: " + id + ", primeiroNome: " + primeiroNome + ", segundoNome: " + segundoNome + ", email: "
				+ email + "]";
	}

}
