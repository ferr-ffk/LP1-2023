package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class Acontecimento extends GridPane {

	protected Label labelNome;

	protected Label labelData;

	public Acontecimento() {
	}

	public Acontecimento(String nome, String data) {
		this.setPadding(new Insets(10));

		labelNome = new Label(nome);
		labelData = new Label(data);

		getColumnConstraints().addAll(coluna25(), coluna25(), coluna25());

		add(labelNome, 0, 0);
		add(labelData, 1, 0);

		setAlignment(Pos.CENTER);
		setMinWidth(350);
		setPrefWidth(350);

		setVgap(7.5);
		setHgap(7.5);
	}

	private ColumnConstraints coluna25() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(25);
		cc.setFillWidth(true);
		return cc;
	}

	public String getNome() {
		return labelNome.getText();
	}

	@Override
	public String toString() {
		return getId() + ": " + labelNome.getText();
	}
}