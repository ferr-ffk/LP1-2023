package teste;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Endereco;
import entity.Pessoa;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		 
		 Pessoa p1 = new Pessoa("davi", "gomes", "davi@gmail.com", new Endereco("Avenida das Gracas", "SBC"));
		 Pessoa p2 = new Pessoa("nando", "freitas", "nando@gmail.com", new Endereco("Rua dos Jequitibás", "SP"));
		 Pessoa p3 = new Pessoa("yuta", "the man", "yuta@gmail.com", new Endereco("Rua tal", "GO"));
		 Pessoa p4 = new Pessoa("forla", "forliene", "fola@gmail.com", null);
		 Pessoa p5 = new Pessoa("mister", "rocha", "mr@gmail.com", new Endereco("Rua Xiró", "SP"));
		 Pessoa p6 = new Pessoa("zorza", "nn tem sobrenome", "zorza@gmail.com", new Endereco("Avenida 198247wnueufw", "Armênia"));
		 
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
