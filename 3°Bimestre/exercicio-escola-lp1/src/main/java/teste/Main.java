 package teste;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Aluno;
import entity.Nota;
import entity.Professor;
import entity.Turma;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Professor p1 = new Professor("abcdef", "655.356.987.00", "Igojogs", "3045565");
		
		List<Aluno> alunos = new ArrayList<>();
		
		Aluno a1 = new Aluno("fedcba", "Davi Gomes", "SP305758X");
		a1.adicionarNota(new Nota(7.6));
		a1.adicionarNota(new Nota(6.5));
		a1.adicionarNota(new Nota(3.6));
		
		Aluno a2 = new Aluno("xyzabc", "Giovanny Foliene", "SP355538X");
		a2.adicionarNota(new Nota(8.6));
		a2.adicionarNota(new Nota(9.3));
		a2.adicionarNota(new Nota(0.0));
		
		Aluno a3 = new Aluno("aorbwjg", "Lucas Milhomem", "SP3088715");
		a3.adicionarNota(new Nota(3.5));
		a3.adicionarNota(new Nota(6.0));
		a3.adicionarNota(new Nota(4.5));
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		
		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		
		Turma t1 = new Turma(p1, 07, alunos, "SP079 LP1-2");
		session.persist(t1);
		
		transaction.commit();
		
		System.out.println("\n");
		
		List<Turma> turmas = session.createQuery("from turma_tb", Turma.class).list();
		
		turmas.forEach(t -> System.out.println(t));
		
		session.close();
	}
}
