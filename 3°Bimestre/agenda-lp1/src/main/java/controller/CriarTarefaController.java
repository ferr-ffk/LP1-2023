package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Tarefa;

public class CriarTarefaController {

	private Stage stage;

	private TextField entradaDataNome;

	private DatePicker entradaDia;

	private TextField entradaHora;

	private Button botaoEnviar;

	public Button criarTarefa() {
		stage = new Stage();

		Label labelData = new Label("Nova Tarefa");
		entradaDataNome = new TextField();
		Label labelEntradaDia = new Label("Dia:");
		entradaDia = new DatePicker();
		Label labelEntradaHora = new Label("Hora: (ex 16:15)");
		entradaHora = new TextField();
		botaoEnviar = new Button("Registrar");

		FlowPane flowCriarTarefa = new FlowPane();
		flowCriarTarefa.setOrientation(Orientation.VERTICAL);
		flowCriarTarefa.setAlignment(Pos.CENTER);

		flowCriarTarefa.getChildren().addAll(labelData, entradaDataNome, labelEntradaDia, entradaDia, labelEntradaHora,
				entradaHora, botaoEnviar);

		Scene cena = new Scene(flowCriarTarefa, 300, 400);

		stage.setScene(cena);
		stage.show();

		return botaoEnviar;
	}

	public Tarefa getTarefa() {
		String nome = entradaDataNome.getText();
		LocalDate data = entradaDia.getValue();
		String hora = "às " + entradaHora.getText();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataString = dtf.format(data);

		entradaDataNome.setText("");
		entradaDia.setValue(null);
		entradaHora.setText("");

		return new Tarefa(nome, dataString, hora);
	}

	// TODO seguinte, a tarefa ta sendo criada certinho mas nn da pra fechar o stage
	// dps disso tem q fazer isso de extrair os metodo pro arquivo FXML do Evento e
	// do Lembrete
	// depois disso tudo kkkk tem que fazer o ngc de remover q ate agr eu n sei como

}
