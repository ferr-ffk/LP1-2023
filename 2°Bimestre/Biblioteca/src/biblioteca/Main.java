package biblioteca;

import usuarios.Dono;
import usuarios.Funcionario;
import usuarios.Livro;

public class Main {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Livraria Lira", new Dono("Fernando Freitas", 34425780990L, 9845434783L));

		Funcionario f1 = new Funcionario("Danilo Teixeira", 147194593915L, 295810583L, "Bibliotecario chefe");

		Funcionario f2 = new Funcionario("Melissa Cardoso", 12958693953L, 1294024059L, "Faxineira");

		Livro l1 = new Livro("Admirável Mundo novo", "Aldous Huxley", 1932);

		Livro l2 = new Livro("As memórias póstumas de Brás Cubas", "Machado de Assis", 1881);

		Livro l3 = new Livro("A revolução dos bichos", "George Orwell", 1928);

		System.out.printf("Biblioteca '%s'\n", biblioteca.getNome());
		System.out.printf("Dono atual: '%s'\n\n", biblioteca.getDono());

		biblioteca.addFuncionario(f1);
		biblioteca.addFuncionario(f2);
		biblioteca.addLivros(l1);
		biblioteca.addLivros(l2);
		biblioteca.addLivros(l3);
		biblioteca.mostraFuncionario();
		biblioteca.mostraLivros();

	}
}
