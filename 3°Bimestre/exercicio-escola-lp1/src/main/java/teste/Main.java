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
		
		Professor p1 = new Professor("abcdef", "655.356.987.00", "Igor Sampaio", "3045565");
		
		List<Aluno> alunos = new ArrayList<>();
		
		List<Nota> notasA1 = new ArrayList<>();
		notasA1.add(new Nota(7.6));
		notasA1.add(new Nota(6.5));
		notasA1.add(new Nota(3.6));
		Aluno a1 = new Aluno("fedcba", notasA1, "Davi Gomes", "SP305758X");
		
		List<Nota> notasA2 = new ArrayList<>();
		notasA2.add(new Nota(8.6));
		notasA2.add(new Nota(9.3));
		notasA2.add(new Nota(0.0));
		Aluno a2 = new Aluno("xyzabc", notasA2, "Giovanny Foliene", "SP355538X");
		
		List<Nota> notasA3 = new ArrayList<>();
		notasA3.add(new Nota(3.5));
		notasA3.add(new Nota(6.0));
		notasA3.add(new Nota(4.5));
		Aluno a3 = new Aluno("aorbwjg", notasA3, "Lucas Milhomem", "SP3088715");
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		
		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		
		Turma t1 = new Turma(p1, 07, alunos, "SP079");
		session.persist(t1);
		
		transaction.commit();
		
		System.out.println("\n");
		
		List<Turma> turmas = session.createQuery("from turma_tb", Turma.class).list();
		
		turmas.forEach(t -> System.out.println(t));
		
		session.close();
	}
}
