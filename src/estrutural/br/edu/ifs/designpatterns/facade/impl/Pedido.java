package estrutural.br.edu.ifs.designpatterns.facade.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Pedido {

	/*
	 * 
	 */
	private String id;

	private List<Produto> produtos;

	/**
	 * 
	 */
	public Pedido() {

		this.produtos = new ArrayList<Produto>();
	}

	/**
	 * 
	 * @return
	 */
	public double valorTotal() {

		return this.produtos.stream().mapToDouble(p -> p.getPreco()).sum();
	}

	/**
	 * 
	 * @param produto
	 */
	public void adicionar(Produto produto) {

		this.produtos.add(produto);
	}

	/**
	 * 
	 * @param produto
	 */
	public void remover(Produto produto) {

		this.produtos.remove(produto);
	}

	/**
	 * 
	 * @return
	 */
	public List<String> mostrarPedido() {

		return produtos.stream().map(p -> p.toString()).toList();
	}

	/**
	 * @return the id
	 */
	public String getId() {

		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		return this.mostrarPedido().toString();
	}
}