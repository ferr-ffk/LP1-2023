package biblioteca;

import java.util.ArrayList;
import java.util.List;
import usuarios.Dono;
import usuarios.Funcionario;
import usuarios.Livro;

public class Biblioteca {
	private Dono dono;
	private String nome;

	private List<Livro> livros = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();

	public void addLivros(Livro livro) {
		livros.add(livro);
	}

	public void mostraLivros() {
		System.out.println("===Livros Disponíveis===");
		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getNome());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Ano de lançamento: " + livro.getAno());
			System.out.println();
		}
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void mostraFuncionario() {
		System.out.println("===Funcionarios===");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Funcionario(a) " + funcionario.getNome());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println();
		}
	}

	public Biblioteca(String nome, Dono dono) {
		this.dono = dono;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDono() {
		return dono.getNome();
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	
}
