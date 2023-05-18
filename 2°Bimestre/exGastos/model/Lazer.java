package exercicios.exGastos.model;

public class Lazer extends Gasto {
	private boolean importante;

	public Lazer(String nome, double valor, boolean importante) {
		super(nome, valor);
		this.importante = importante;
	}

	public boolean isImportante() {
		return importante;
	}

	public void setImportante(boolean importante) {
		this.importante = importante;
	}

	@Override
	public void mudarValor(double valor) {
		this.setValor(valor + (valor * 5 / 100));
	}
}
