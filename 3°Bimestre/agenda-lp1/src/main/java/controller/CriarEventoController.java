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
import model.Evento;

public class CriarEventoController {

	private Stage stage;

	private TextField entradaDataNome;

	private DatePicker entradaDia;

	private TextField entradaHoraInicio;

	private TextField entradaHoraTermino;

	private Button botaoEnviar;

	public Button criarEvento() {
		stage = new Stage();

		Label labelData = new Label("Novo Evento");
		entradaDataNome = new TextField();
		Label labelEntradaDia = new Label("Dia:");
		entradaDia = new DatePicker();
		Label labelEntradaHoraInicio = new Label("Hora de início: (ex 16:15)");
		entradaHoraInicio = new TextField();
		Label labelEntradaHoraTermino = new Label("Hora de término:");
		entradaHoraTermino = new TextField();
		botaoEnviar = new Button("Registrar");

		FlowPane flowCriarTarefa = new FlowPane();
		flowCriarTarefa.setOrientation(Orientation.VERTICAL);
		flowCriarTarefa.setAlignment(Pos.CENTER);

		flowCriarTarefa.getChildren().addAll(labelData, entradaDataNome, labelEntradaDia, entradaDia,
				labelEntradaHoraInicio, entradaHoraInicio, labelEntradaHoraTermino, entradaHoraTermino, botaoEnviar);

		Scene cena = new Scene(flowCriarTarefa, 300, 400);

		stage.setScene(cena);
		stage.show();

		return botaoEnviar;
	}

	public Evento getEvento() {
		String nome = entradaDataNome.getText();
		LocalDate data = entradaDia.getValue();
		String horaInicio = "às " + entradaHoraInicio.getText();
		String horaTermino = " até " + entradaHoraTermino.getText();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataString = dtf.format(data);

		entradaDataNome.setText("");
		entradaDia.setValue(null);
		entradaHoraInicio.setText("");
		entradaHoraTermino.setText("");

		return new Evento(nome, dataString, horaInicio, horaTermino);
	}

}
