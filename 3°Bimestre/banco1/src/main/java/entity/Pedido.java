package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "pedido")
@Table
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private List<Produto> produtos;
	
	@Column
	private Double valorTotal = 0.0;
	
	public Pedido() {}
	
	public Pedido(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pedido(Pessoa pessoa, List<Produto> produtos) {
		this.pessoa = pessoa;
		this.produtos = produtos;

		for(Produto p : produtos) {
			valorTotal += p.getPreco();
		}
	}
	
	public void adicionarProduto(Produto p) {
		produtos.add(p);
		valorTotal += p.getPreco();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Pedido [" + id + "]: R$" + valorTotal + " Realizado por " + pessoa + ", Produtos: " + produtos;
	}
	
	
}
