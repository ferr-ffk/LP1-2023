package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import model.Acontecimento;
import model.Evento;
import model.Lembrete;
import model.Tarefa;
import model.TipoAcontecimento;

public class AgendaController {

	@FXML
	private Parent principal;

	@FXML
	private FlowPane entrada;

	@FXML
	private Label labelData;

	@FXML
	private DatePicker datePicker;

	@FXML
	private TextField entradaDataNome;

	@FXML
	private FlowPane eventos = new FlowPane();

	@FXML
	private FlowPane lembretes = new FlowPane();

	@FXML
	private FlowPane tarefas = new FlowPane();

	@FXML
	private Button botaoEnviar;

	private static List<Evento> listaEventos = new ArrayList<Evento>();

	private static List<Tarefa> listaTarefas = new ArrayList<Tarefa>();

	private static List<Lembrete> listaLembretes = new ArrayList<Lembrete>();

	@FXML
	public void criarNovaTarefa() {
		CriarTarefaController controller = new CriarTarefaController();

		Button botaoEnviar = controller.criarTarefa();

		botaoEnviar.setOnAction(e -> {
			Tarefa tarefa = controller.getTarefa();
			tarefas.getChildren().add(tarefa);

			listaTarefas.add(tarefa);
		});
	}

	@FXML
	public void criarNovoEvento() {
		CriarEventoController controller = new CriarEventoController();

		Button botaoEnviar = controller.criarEvento();

		botaoEnviar.setOnAction(e -> {
			Evento evento = controller.getEvento();

			eventos.getChildren().add(evento);
			listaEventos.add(evento);
		});
	}

	@FXML
	public void criarNovoLembrete() {
		CriarLembreteController controller = new CriarLembreteController();

		Button botaoEnviar = controller.criarLembrete();

		botaoEnviar.setOnAction(e -> {
			Lembrete lembrete = controller.getLembrete();

			lembretes.getChildren().add(lembrete);
			listaLembretes.add(lembrete);
		});
	}

	@FXML
	/**
	 * Para remover o elemento, ele obtem o valor da id do elemento que é obtida na
	 * outra janela para depois buscar em cada lista, depois remove-o filtrando da
	 * lista virtual e da lista de elementos na janela
	 */
	public void removerAcontecimento() {
		RemoverAcontecimentoController controller = new RemoverAcontecimentoController();

		Button botaoRemoverAcontecimento = controller.removerAcontecimento();

		botaoRemoverAcontecimento.setOnAction(e -> obterQualAcontecimentoARemover(controller));
	}

	private void obterQualAcontecimentoARemover(RemoverAcontecimentoController controller) {
		String acontecimentoASerRemovido = controller.getAcontecimentoARemover();
		Predicate<? super Acontecimento> acontecimentoComMesmoId = t -> t.getNome().equals(acontecimentoASerRemovido);
		TipoAcontecimento tipoAcontecimentoASerRemovido = controller.getTipoAcontecimentoARemover();

		if (tipoAcontecimentoASerRemovido.equals(TipoAcontecimento.TAREFA)) {
			List<Tarefa> tarefaASerRemovida = listaTarefas.stream().filter(acontecimentoComMesmoId).toList();
			Tarefa tarefa = tarefaASerRemovida.get(0);
			int indiceTarefa = Integer.parseInt(tarefa.toString().charAt(2) + "");

			tarefas.getChildren().remove(indiceTarefa);

		} else if (tipoAcontecimentoASerRemovido.equals(TipoAcontecimento.EVENTO)) {
			List<Evento> eventoASerRemovido = listaEventos.stream().filter(acontecimentoComMesmoId).toList();
			Evento evento = eventoASerRemovido.get(0);
			int indiceEvento = Integer.parseInt(evento.toString().charAt(2) + "");

			eventos.getChildren().remove(indiceEvento);

		} else if (tipoAcontecimentoASerRemovido.equals(TipoAcontecimento.LEMBRETE)) {
			List<Lembrete> lembreteASerRemovido = listaLembretes.stream().filter(acontecimentoComMesmoId).toList();
			Lembrete lembrete = lembreteASerRemovido.get(0);
			int indiceLembrete = Integer.parseInt(lembrete.toString().charAt(2) + "");

			lembretes.getChildren().remove(indiceLembrete);
		}
	}

	public static List<Evento> getEventos() {
		return listaEventos;
	}

	public static List<Lembrete> getLembretes() {
		return listaLembretes;
	}

	public static List<Tarefa> getTarefas() {
		return listaTarefas;
	}

	@FXML

	public void adicionarExemplos() {
		Tarefa tarefa1 = new Tarefa("Estudar para a prova", "16/09/2023", "20:00");
		Tarefa tarefa2 = new Tarefa("Fazer lição", "17/09/2023", "02:00");
		Tarefa tarefa3 = new Tarefa("X", "16/09/2023", "21:00");
		Tarefa tarefa4 = new Tarefa("Y", "17/09/2023", "00:00");
		tarefas.getChildren().addAll(tarefa1, tarefa2, tarefa3, tarefa4);

		listaTarefas.add(tarefa1);
		listaTarefas.add(tarefa2);
		listaTarefas.add(tarefa3);
		listaTarefas.add(tarefa4);

		Evento evento1 = new Evento("Aniversário Bel", "23/09/2023", "10:00", "16:00");
		Evento evento2 = new Evento("Dar o cu", "17/09/2023", "10:30", "17:00");

		eventos.getChildren().addAll(evento1, evento2);
		listaEventos.add(evento1);
		listaEventos.add(evento2);

		Lembrete lembrete1 = new Lembrete("Dormir cedo", "16/09/2023", "21:00");
		Lembrete lembrete2 = new Lembrete("Dormir tarde", "17/09/2023", "00:00");

		lembretes.getChildren().addAll(lembrete1, lembrete2);
		listaLembretes.add(lembrete1);
		listaLembretes.add(lembrete2);
	}
}
