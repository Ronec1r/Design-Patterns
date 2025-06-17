package estrutural.br.edu.ifs.designpatterns.facade.impl;

/**
 * 
 */
public class Cliente {

	/*
	 * 
	 */
	private String id;

	private String nome;

	private Pedido pedido;

	/**
	 * 
	 * @param id
	 * @param nome
	 */
	public Cliente(String id, String nome) {

		this.id = id;
		this.nome = nome;
		this.pedido = new Pedido();
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {

		this.pedido = pedido;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {

		return this.pedido;
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

	@Override
	public String toString() {

		return new StringBuilder().append(id).append(": ").append(nome).toString();
	}
}
