/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import criacao.br.edu.ifs.designpatterns.singleton.MestreMagos;

/**
 *
 */
class TestSingleton {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Singleton")
	void test() {

		/*
		 * Instanciação de três Mestres dos Magos utilizando o padrão Singleton.
		 */
		MestreMagos mestre1 = MestreMagos.obterInstancia();
		MestreMagos mestre2 = MestreMagos.obterInstancia();
		MestreMagos mestre3 = MestreMagos.obterInstancia();

		/*
		 * Alteração de uma característica do primeiro mestre dos Magos. Tal alteração
		 * deverá se refletir nos outros mestres.
		 */
		mestre1.elevarNivel();
		assertEquals(mestre1.getNivelMagia(), mestre2.getNivelMagia());
		assertEquals(mestre1.getNivelMagia(), mestre3.getNivelMagia());

		/*
		 * Verificação que os Mestres dos Magos são o mesmo objeto.
		 */
		assertSame(mestre1, mestre2);
		assertSame(mestre1, mestre3);
	}
}