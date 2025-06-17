package estrutural.br.edu.ifs.designpatterns.facade.impl;

/**
 * 
 */
public class Produto {

	/*
	 * 
	 */
	private String id;

	private String nome;

	private double preco;

	/**
	 * @param id
	 * @param nome
	 * @param preco
	 */
	public Produto(String id, String nome, double preco) {

		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * @return the id
	 */
	public String getId() {

		return this.id;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		return new StringBuilder().append(id).append(": ").append(nome).append(" ... R$ ").append(preco).toString();
	}
}