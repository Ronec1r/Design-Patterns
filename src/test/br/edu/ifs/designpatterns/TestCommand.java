/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.ControleRemoto;
import comportamental.br.edu.ifs.designpatterns.command.Luz;
import comportamental.br.edu.ifs.designpatterns.command.Televisao;
import comportamental.br.edu.ifs.designpatterns.command.impl.DesligarLuz;
import comportamental.br.edu.ifs.designpatterns.command.impl.DesligarTV;
import comportamental.br.edu.ifs.designpatterns.command.impl.LigarLuz;
import comportamental.br.edu.ifs.designpatterns.command.impl.LigarTV;
import comportamental.br.edu.ifs.designpatterns.command.impl.AvancarCanalTV;
import comportamental.br.edu.ifs.designpatterns.command.impl.RetrocederCanalTV;

/**
 *
 */
class TestCommand {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Command")
	void test() {

		/*
		 * Instanciação dos aparelhos e do controle remoto
		 */
		Televisao tv = new Televisao("TV Sala");
		Luz luz = new Luz("Luz Sala");

		ControleRemoto controle = new ControleRemoto();

		/*
		 * Tentativa de ativação do controle sem a definição prévia de um comando
		 */
		Exception e = assertThrows(IllegalStateException.class, () -> controle.pressionarBotao());
		assertEquals(e.getMessage(), "Comando não definido");

		/*
		 * Verificação da situação da luz antes e depois da execução dos comandos para
		 * ligar e desligar a luz
		 */
		assertFalse(luz.estaLigada());

		Comando ligaLuz = new LigarLuz(luz);

		controle.definirComando(ligaLuz);
		controle.pressionarBotao();

		assertTrue(luz.estaLigada());

		Comando desligaLuz = new DesligarLuz(luz);

		controle.definirComando(desligaLuz);
		controle.pressionarBotao();

		assertFalse(luz.estaLigada());

		/*
		 * Verificação da situação da televisão antes e depois da execução dos comandos
		 * para ligar e desligar a TV
		 */
		assertFalse(tv.estaLigada());

		Comando ligarTV = new LigarTV(tv);

		controle.definirComando(ligarTV);
		controle.pressionarBotao();

		assertTrue(tv.estaLigada());

		/*
		 * Verificação da situação da televisão após múltiplas execuções do comando
		 * avançar canal
		 */
		assertEquals(tv.getCanal(), 1);

		Comando avancarCanalTV = new AvancarCanalTV(tv);

		controle.definirComando(avancarCanalTV);
		controle.pressionarBotao();
		controle.pressionarBotao();
		controle.pressionarBotao();

		assertEquals(tv.getCanal(), 4);

		/*
		 * Verificação da situação da televisão após múltiplas execuções do comando
		 * retroceder canal
		 */
		Comando retrocederCanalTV = new RetrocederCanalTV(tv);

		controle.definirComando(retrocederCanalTV);
		controle.pressionarBotao();
		controle.pressionarBotao();

		assertEquals(tv.getCanal(), 2);

		/*
		 * Verificação da situação após a execuçãodo comando desligar a TV
		 */
		Comando desligarTV = new DesligarTV(tv);

		controle.definirComando(desligarTV);
		controle.pressionarBotao();

		assertFalse(tv.estaLigada());

		/*
		 * Tentativa de execução de um comando com a televisão desligada
		 */
		controle.definirComando(retrocederCanalTV);

		e = assertThrows(IllegalStateException.class, () -> controle.pressionarBotao());
		assertEquals(e.getMessage(), "Televisão desligada");
	}
}