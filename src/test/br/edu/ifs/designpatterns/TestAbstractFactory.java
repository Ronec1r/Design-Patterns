/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Botao;
import criacao.br.edu.ifs.designpatterns.abstractfactory.FabricaInterfaceGrafica;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Janela;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Menu;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implA.BotaoClaro;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implA.JanelaClara;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implA.MenuClaro;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implA.TemaClaro;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implB.BotaoEscuro;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implB.JanelaEscura;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implB.MenuEscuro;
import criacao.br.edu.ifs.designpatterns.abstractfactory.implB.TemaEscuro;

/**
 *
 */
class TestAbstractFactory {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Abstract Factory")
	void test() {

		/*
		 * Definindo uma fábrica para a construção de interfaces gráficas com modo
		 * escuro (noturno)
		 */
		FabricaInterfaceGrafica fabrica = new TemaEscuro();
		
		Janela janela = fabrica.criarJanela();
		Botao botao = fabrica.criarBotao();
		Menu menu = fabrica.criarMenu();

		assertEquals(janela.obterCor(), "#4F4F4F");
		assertEquals(botao.obterCor(), "#4F4F4F");
		assertEquals(menu.obterCor(), "#4F4F4F");

		assertInstanceOf(JanelaEscura.class, janela);
		assertInstanceOf(BotaoEscuro.class, botao);
		assertInstanceOf(MenuEscuro.class, menu);

		/*
		 * Definindo uma fábrica para a construção de interfaces gráficas com modo
		 * escuro (noturno)
		 */
		fabrica = new TemaClaro();

		janela = fabrica.criarJanela();
		botao = fabrica.criarBotao();
		menu = fabrica.criarMenu();

		assertEquals(janela.obterCor(), "#FFFAFA");
		assertEquals(botao.obterCor(), "#FFFAFA");
		assertEquals(menu.obterCor(), "#FFFAFA");

		assertInstanceOf(JanelaClara.class, janela);
		assertInstanceOf(BotaoClaro.class, botao);
		assertInstanceOf(MenuClaro.class, menu);
	}
}