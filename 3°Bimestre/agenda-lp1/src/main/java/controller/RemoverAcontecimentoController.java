package controller;

import java.util.List;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Evento;
import model.Lembrete;
import model.Tarefa;
import model.TipoAcontecimento;

public class RemoverAcontecimentoController {

	Stage stage;

	Scene cena;

	private ChoiceBox<TipoAcontecimento> escolhaTipo;

	private Button botaoRemoverElemento;

	private ChoiceBox<String> escolhaElemento;

	public Button removerAcontecimento() {
		Label labelTipo = new Label("Escolha o tipo:");
		escolhaTipo = new ChoiceBox<>();
		Label labelIndice = new Label("Escolha qual deseja remover:");
		botaoRemoverElemento = new Button("Remover");

		FlowPane flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.setOrientation(Orientation.VERTICAL);

		escolhaTipo.getItems().add(TipoAcontecimento.EVENTO);
		escolhaTipo.getItems().add(TipoAcontecimento.LEMBRETE);
		escolhaTipo.getItems().add(TipoAcontecimento.TAREFA);

		List<Evento> eventos = AgendaController.getEventos();
		List<Lembrete> lembretes = AgendaController.getLembretes();
		List<Tarefa> tarefas = AgendaController.getTarefas();

		escolhaElemento = new ChoiceBox<>();

		// define o tipo e qual elemento o usuário vai querer remover
		escolhaTipo.setOnAction(e -> {
			if (escolhaTipo.getValue() == TipoAcontecimento.EVENTO) {
				escolhaElemento.getItems().clear();

				eventos.forEach(ev -> {
					escolhaElemento.getItems().add(ev.getNome());
				});
			} else if (escolhaTipo.getValue() == TipoAcontecimento.LEMBRETE) {
				escolhaElemento.getItems().clear();

				lembretes.forEach(l -> {
					escolhaElemento.getItems().add(l.getNome());
				});
			} else if (escolhaTipo.getValue() == TipoAcontecimento.TAREFA) {
				escolhaElemento.getItems().clear();

				tarefas.forEach(t -> {
					escolhaElemento.getItems().add(t.getNome());
				});
			}
		});

		flow.getChildren().addAll(labelTipo, escolhaTipo, labelIndice, escolhaElemento, botaoRemoverElemento);

		stage = new Stage();
		cena = new Scene(flow, 300, 250);

		stage.setScene(cena);
		stage.show();

		return botaoRemoverElemento;
	}

	/**
	 * Obtém o elemento a ser removido no método
	 * 
	 * @return A string do acontecimento a ser removido
	 */
	public String getAcontecimentoARemover() {
		return escolhaElemento.getValue() == null ? null : escolhaElemento.getValue().toString();
	}

	public TipoAcontecimento getTipoAcontecimentoARemover() {
		return escolhaTipo.getValue();
	}
}
