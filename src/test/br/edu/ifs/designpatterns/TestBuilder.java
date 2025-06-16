/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import criacao.br.edu.ifs.designpatterns.builder.Construtor;
import criacao.br.edu.ifs.designpatterns.builder.Loja;
import criacao.br.edu.ifs.designpatterns.builder.impl.Computador;
import criacao.br.edu.ifs.designpatterns.builder.impl.ConstrutorComputador;

/**
 *
 */
class TestBuilder {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Builder")
	void test() {

		/*
		 * Instanciando uma loja de computadores
		 */
		Construtor construtor = new ConstrutorComputador();
		Loja loja = new Loja((ConstrutorComputador) construtor);

		/*
		 * Construindo notebook padrão
		 */
		Computador notebook = loja.construirNotebook();

		assertEquals(notebook.getProcessador(), "Core™ i7-1355U");
		assertEquals(notebook.getHD(), 512);
		assertEquals(notebook.getRAM(), 16);

		/*
		 * Construindo notebook gamer
		 */
		Computador notebookGamer = loja.construirNotebookGamer();

		assertEquals(notebookGamer.getProcessador(), "Core i7-13650HX");
		assertEquals(notebookGamer.getHD(), 1024);
		assertEquals(notebookGamer.getRAM(), 16);

		/*
		 * Construindo notebook ultra
		 */
		Computador notebookUltra = loja.construirNotebookUltra();

		assertEquals(notebookUltra.getProcessador(), "Core Ultra 7 155H");
		assertEquals(notebookUltra.getHD(), 1024);
		assertEquals(notebookUltra.getRAM(), 32);

	}
}