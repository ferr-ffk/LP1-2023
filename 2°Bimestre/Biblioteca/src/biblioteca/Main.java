package biblioteca;

import usuarios.Dono;
import usuarios.Funcionario;
import usuarios.Livro;

public class Main {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setNome("Livraria Lira");

		Dono dono = new Dono();
		dono.setNome("Fernando Freitas");
		dono.setCpf(344257890);
		dono.setTelefone(984534783);

		Funcionario f1 = new Funcionario();
		f1.setNome("Danilo Teixeira");
		f1.setCargo("Bibliotecário chefe");
		f1.setCpf(147194593915L);
		f1.setTelefone(295810583L);
		Funcionario f2 = new Funcionario();
		f2.setNome("Melissa Cardoso");
		f2.setCargo("Faxineira");
		f2.setCpf(12958693953l);
		f2.setTelefone(1294024059);

		Livro l1 = new Livro();
		l1.setNome("Admirável Mundo novo");
		l1.setAno(1932);
		l1.setAutor("Aldous Huxley");
		Livro l2 = new Livro();
		l2.setNome("As memórias póstumas de Brás Cubas");
		l2.setAno(1881);
		l2.setAutor("Machado de Assis");
		Livro l3 = new Livro();
		l3.setNome("A revolução dos bichos");
		l3.setAno(1928);
		l3.setAutor("George Orwell");

		System.out.printf("Biblioteca '%s'\n", biblioteca.getNome());
		System.out.printf("Dono atual: '%s'\n\n", dono.getNome());

		biblioteca.addFuncionario(f1, f2);
		biblioteca.addLivros(l1, l2, l3);
		biblioteca.mostraFuncionario();
		biblioteca.mostraLivros();

	}
}
