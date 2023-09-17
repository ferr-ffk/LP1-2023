package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Evento;
import model.Lembrete;
import model.Tarefa;

/**
 * A porta principal da aplicação
 * 
 * @author fe_fr
 *
 */
public class Agenda extends Application {

	private List<Evento> eventos = new ArrayList<>();

	private List<Tarefa> tarefas = new ArrayList<>();

	private List<Lembrete> lembretes = new ArrayList<>();

	public void adicionarLembrete(Lembrete l) {
		lembretes.add(l);
	}

	public void adicionarEvento(Evento e) {
		eventos.add(e);
	}

	public void adicionarTarefa(Tarefa t) {
		tarefas.add(t);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			URL arquivoFXML = getClass().getResource("/view/Agenda.fxml");

			FlowPane raiz = FXMLLoader.load(arquivoFXML);

			Scene cena = new Scene(raiz, 380, 650);

			primaryStage.setResizable(false);
			primaryStage.setScene(cena);
			primaryStage.setTitle("Agenda");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
