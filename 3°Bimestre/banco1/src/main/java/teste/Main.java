package teste;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Pessoa;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		 
		 Pessoa p1 = new Pessoa("davi", "gomes", "davi@gmail.com");
		 Pessoa p2 = new Pessoa("nando", "freitas", "nando@gmail.com");
		 Pessoa p3 = new Pessoa("yuta", "the man", "yuta@gmail.com");
		 Pessoa p4 = new Pessoa("forla", "forliene", "fola@gmail.com");
		 Pessoa p5 = new Pessoa("mister", "rocha", "mr@gmail.com");
		 Pessoa p6 = new Pessoa("zorza", "nn tem sobrenome", "zorza@gmail.com");
		 
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		 session.persist(p1);
		 session.persist(p2);
		 session.persist(p3);
		 session.persist(p4); 
		 session.persist(p5);
		 session.persist(p6);
		 
		 transaction.commit();

		 List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list();

		 System.out.println("\n");
		 
		 for(Pessoa p : pessoas) {
			 System.out.println(p);
		 }
		 
		 session.close();
	}
}
