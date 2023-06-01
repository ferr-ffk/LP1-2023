package collections.atividadePratica0106;

import collections.atividadePratica0106.model.*;

public class Application {

	public static void main(String[] args) {
		Servico p1 = new Servico("Escolta", 189.9, true);
		Produto p2 = new Produto("Vassoura", 1789.25, 5);
		Produto p3 = new Produto("Celular do Davi", 15.5, 200);
		Servico p4 = new Servico("Pintura de paredes", 79.9, false);
		
		
		Empresa empresa = new Empresa();
		empresa.addItem(p1);
		empresa.addItem(p2);
		empresa.addItem(p3);
		empresa.addItem(p4);
		
		
	}

}
