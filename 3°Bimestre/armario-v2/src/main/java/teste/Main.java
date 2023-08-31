package teste;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Acessorio;
import entity.Armario;
import entity.Dono;
import entity.Roupa;
import util.HibernateUtil;

public class Main {
	
	public static void main(String[] args) {
		
		Acessorio acessorio1 = new Acessorio("Óculos", "M", 24);
		Acessorio acessorio2 = new Acessorio("Corrente de cria", "N/A", 4004);
		Acessorio acessorio3 = new Acessorio("Brinco de pressão", "L", 3);

		Roupa roupa1 = new Roupa("Preto", "Torso", "Bombojaco do Igojogs", "M");
		Roupa roupa2 = new Roupa("Verde Escuro", "Torso", "Camiseta do IgoJogs", "M");
		Roupa roupa3 = new Roupa("Preto", "Inferior", "Calça Social C&A", "43");
		Roupa roupa4 = new Roupa("Cinza e Preto", "Calçado", "Tênis de corrida Nike", "43");
		
		Dono dono = new Dono("Igojogs");
		
		Armario armario1 = new Armario(dono, 10);
		
		armario1.adicionarAcessorio(acessorio1);
		armario1.adicionarAcessorio(acessorio2);
		armario1.adicionarAcessorio(acessorio3);
		
		armario1.adicionarRoupa(roupa1);
		armario1.adicionarRoupa(roupa2);
		armario1.adicionarRoupa(roupa3);
		armario1.adicionarRoupa(roupa4);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		

		session.persist(armario1);
		
		transaction.commit();
		
		
		List<Armario> armarios = session.createQuery("from armarios", Armario.class).list();
		
		System.out.println("\n");
		armarios.forEach(a -> System.out.println(a));
		
		session.close();
		
	}

}
