package teste;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Endereco;
import entity.Pedido;
import entity.Pessoa;
import entity.Produto;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		gerenciarPessoas();

		gerenciarPedidos();
	}

	private static void gerenciarPedidos() {

		Pessoa p1 = new Pessoa("Luis", "Felipe", "luis.felipe@gmail.com", new Endereco("Meu coração", "SP"));

		Produto pro1 = new Produto("Tinta", 23.90);
		Produto pro2 = new Produto("Abacaxi", 8.90);

		Pedido pe1 = new Pedido(p1, Arrays.asList(pro1, pro2));

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(pe1);

		transaction.commit();

		List<Pedido> pedidos = session.createQuery("from pedido", Pedido.class).list();

		System.out.println("\n");

		pedidos.forEach(p -> System.out.println(p));

		pe1.adicionarProduto(new Produto("Jaqueta Jeans", 149.89));
		pe1.adicionarProduto(new Produto("Bota de Couro que gótico", 219.89));

		session.persist(pe1);

		transaction.commit();

		List<Pedido> pedidosNovo = session.createQuery("from pedido", Pedido.class).list();

		System.out.println("\n");

		pedidosNovo.forEach(p -> System.out.println(p));
	}

	private static void gerenciarPessoas() {
		Pessoa p1 = new Pessoa("davi", "gomes", "davi@gmail.com", new Endereco("Avenida das Gracas", "SBC"));
		Pessoa p2 = new Pessoa("nando", "freitas", "nando@gmail.com", new Endereco("Rua dos Jequitibás", "SP"));
		Pessoa p3 = new Pessoa("yuta", "the man", "yuta@gmail.com", new Endereco("Rua tal", "GO"));
		Pessoa p4 = new Pessoa("forla", "forliene", "fola@gmail.com", null);
		Pessoa p5 = new Pessoa("mister", "rocha", "mr@gmail.com", new Endereco("Rua Xiró", "SP"));
		Pessoa p6 = new Pessoa("zorza", "nn tem sobrenome", "zorza@gmail.com",
				new Endereco("Avenida 198247wnueufw", "Armênia"));

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		session.persist(p4);
		session.persist(p5);
		session.persist(p6);

		transaction.commit();

		System.out.println("\n");

		List<Pessoa> pessoas = session.createQuery("from pessoas", Pessoa.class).list();

		System.out.println("\n");

		pessoas.stream().forEach(p -> System.out.println(p + "\n "));

		System.out.println();

		List<Endereco> enderecos = session.createQuery("from enderecos", Endereco.class).list();

		System.out.println("\n");

		enderecos.stream().forEach(e -> System.out.println(e));

		session.close();
	}

}
