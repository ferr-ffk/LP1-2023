package model;

import javafx.scene.control.Label;

public class Evento extends Acontecimento {

	private Label horaInicio;

	private Label horaTermino;

	private static Integer idBase = 0;

	public Evento(String nome, String data, String horaInicio, String horaTermino) {
		super(nome, data);

		this.horaInicio = new Label(horaInicio);
		this.horaTermino = new Label(horaTermino);

		add(this.horaInicio, 2, 0);
		add(this.horaTermino, 3, 0);

		// para depois remover o elemento da lista, temos que registrar seu id como um
		// numero inteiro
		// em cada lista
		setId(idBase.toString());
		idBase++;

	}

	@Override
	public String toString() {
		return "E(" + super.toString() + ")";
	}

}
