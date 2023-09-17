package model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Tarefa extends Acontecimento {

	private CheckBox checkbox;

	protected boolean concluido;

	private static Integer idBase = 0;

	public Tarefa(String nome, String data, String hora) {
		this.labelNome = new Label(nome);

		String tarefaTexto = nome + " " + data + " " + hora;

		checkbox = new CheckBox(tarefaTexto);

		add(checkbox, 3, 0);

		// para depois remover o elemento da lista, temos que registrar seu id como um
		// numero inteiro
		// em cada lista
		setId(idBase.toString());
		idBase++;

		if (checkbox.isSelected()) {
			this.concluido = true;

		}
		if (!checkbox.isSelected()) {
			this.concluido = false;

		}

	}

	@Override
	public String toString() {
		return "T(" + super.toString() + ")";
	}
}
