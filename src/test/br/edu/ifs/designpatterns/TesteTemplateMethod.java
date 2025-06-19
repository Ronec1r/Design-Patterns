/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comportamental.br.edu.ifs.designpatterns.template.Bebida;
import comportamental.br.edu.ifs.designpatterns.template.impl.Cafe;
import comportamental.br.edu.ifs.designpatterns.template.impl.Cappuccino;
import comportamental.br.edu.ifs.designpatterns.template.impl.Cha;

/**
 * 
 */
class TesteTemplateMethod {

	private static List<String> preparoCha;

	private static List<String> preparoCafe;

	private static List<String> preparoCappuccino;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		/*
		 * Configurando os preparos que serão utilizados na comparação com os dados
		 * recuperados
		 */
		preparoCha = new ArrayList<>();
		preparoCha.add("Preparar uma xícara");
		preparoCha.add("Adicionar um sachê de chá");
		preparoCha.add("Adicionar água quente");

		preparoCafe = new ArrayList<>();
		preparoCafe.add("Preparar uma xícara");
		preparoCafe.add("Adicionar uma colher de café");
		preparoCafe.add("Adicionar água quente");

		preparoCappuccino = new ArrayList<>();
		preparoCappuccino.add("Preparar uma xícara");
		preparoCappuccino.add("Adicionar uma colher de café");
		preparoCappuccino.add("Adicionar uma colher de leite em pó");
		preparoCappuccino.add("Adicionar uma colher de chocolate em pó");
		preparoCappuccino.add("Adicionar água quente");
	}

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Template Method")
	void test() {

		/*
		 * Obtenção do preparo de um chá
		 */
		Bebida bebida = new Cha();
		assertEquals(bebida.obterPreparo(), preparoCha);

		/*
		 * Obtenção do preparo de um café
		 */
		bebida = new Cafe();
		assertEquals(bebida.obterPreparo(), preparoCafe);

		/*
		 * Obtenção do preparo de um cappuccino
		 */
		bebida = new Cappuccino();
		assertEquals(bebida.obterPreparo(), preparoCappuccino);
	}
}