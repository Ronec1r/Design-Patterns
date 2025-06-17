package estrutural.br.edu.ifs.designpatterns.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class Repositorio<G> {

	/*
	 * 
	 */
	private Map<String, G> dados;

	/**
	 * @param dados
	 * @param clientes
	 */
	public Repositorio() {

		this.dados = new HashMap<String, G>();
	}

	/**
	 * 
	 * @param id
	 * @param produto
	 */
	public void criar(String id, G dado) {

		this.dados.put(id, dado);
	}

	/**
	 * 
	 * @param id
	 */
	public void remover(String id) {

		this.dados.remove(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public G recuperar(String id) {

		return this.dados.get(id);
	}

	/**
	 * 
	 * @return
	 */
	public List<G> recuperar() {

		return this.dados.values().stream().sorted((d1, d2) -> d1.toString().compareTo(d2.toString())).toList();
	}

	/**
	 * 
	 * @param id
	 * @param dado
	 */
	public void atualizar(String id, G dado) {

		this.dados.replace(id, dado);
	}
}