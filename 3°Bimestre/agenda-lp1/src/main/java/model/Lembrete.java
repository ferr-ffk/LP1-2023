package model;

import javafx.scene.control.Label;

public class Lembrete extends Acontecimento {

	private Label hora;

	private static Integer idBase = 0;

	public Lembrete(String nome, String data, String hora) {
		super(nome, data);

		// para depois remover o elemento da lista, temos que registrar seu id como um
		// numero inteiro
		// em cada lista
		setId(idBase.toString());
		idBase++;

		this.hora = new Label(hora);

		add(this.hora, 2, 0);

	}

	@Override
	public String toString() {
		return "L(" + super.toString() + ")";
	}
}
