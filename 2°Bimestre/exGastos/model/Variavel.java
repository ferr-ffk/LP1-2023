package exercicios.exGastos.model;

public class Variavel extends Gasto {
	private int tempoMeses;

	public int getTempoMeses() {
		return tempoMeses;
	}

	public void setTempoMeses(int tempoMeses) {
		this.tempoMeses = tempoMeses;
	}

	public Variavel() {
		super();
	}

	public Variavel(String nome, double valor, int tempoMeses) {
		super(nome, valor);
		this.tempoMeses = tempoMeses;
	}
	
	
}
