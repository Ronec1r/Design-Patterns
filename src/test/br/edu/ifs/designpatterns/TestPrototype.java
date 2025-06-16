/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import criacao.br.edu.ifs.designpatterns.prototype.Robo;
import criacao.br.edu.ifs.designpatterns.prototype.impl.RoboTanque;

/**
 *
 */
class TestPrototype {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Prototype")
	void test() {

		/*
		 * Definiçao de um Robô padrão que será utilizado como protótipo.
		 */
		Robo robo1 = new RoboTanque(100, 20, "Canhão de plasma");

		/*
		 * Clonagem das características desse protótipo para outros robôs.
		 */
		Robo robo2 = robo1.clonar();
		Robo robo3 = robo1.clonar();
		Robo robo4 = robo1.clonar();
		Robo robo5 = robo1.clonar();

		/*
		 * Verificando se os robôs não estão fazendo referência ao mesmo objeto.
		 */
		assertNotSame(robo1, robo2);
		assertNotSame(robo1, robo3);
		assertNotSame(robo1, robo4);
		assertNotSame(robo1, robo5);

		/*
		 * Verificando se os robôs possuem as mesmas características.
		 */
		assertEquals(robo1, robo2);
		assertEquals(robo1, robo3);
		assertEquals(robo1, robo4);
		assertEquals(robo1, robo5);
	}
}