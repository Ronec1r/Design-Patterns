/**
 * 
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comportamental.br.edu.ifs.designpatterns.visitor.Mercadoria;
import comportamental.br.edu.ifs.designpatterns.visitor.Taxador;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Alimento;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Cerveja;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Cigarro;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.TaxadorFederal;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.TaxadorIsencao;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Vinho;

/**
 * 
 */
class TestVisitor {

	/**
	 * 
	 */
	@Test
	@DisplayName("Test Visitor")
	void test() {

		/*
		 * Definição dos itens.
		 */
		Mercadoria alimento = new Alimento(10.0);
		Mercadoria cerveja = new Cerveja(7.0);
		Mercadoria cigarro = new Cigarro(4.0);
		Mercadoria vinho = new Vinho(30);

		/*
		 * Definição de uma entidade que irá taxar os itens.
		 */
		Taxador taxador = new TaxadorFederal();

		/*
		 * Verificação da aplicação das taxas.
		 */
		assertEquals(alimento.aceitar(taxador), alimento.getCusto() * 1.11);
		assertEquals(cigarro.aceitar(taxador), cigarro.getCusto() * 2.50);
		assertEquals(cerveja.aceitar(taxador), cerveja.getCusto() * 1.46);
		assertEquals(vinho.aceitar(taxador), vinho.getCusto() * 1.60);

		/*
		 * Definição de uma nova entidade que irá taxar os itens.
		 * 
		 * Após uma medida provisória do governo, alguns itens receberam insenção ou
		 * redução nas taxas.
		 */
		taxador = new TaxadorIsencao();

		assertEquals(alimento.aceitar(taxador), alimento.getCusto());
		assertEquals(cigarro.aceitar(taxador), cigarro.getCusto() * 2.50);
		assertEquals(cerveja.aceitar(taxador), cerveja.getCusto() * 1.15);
		assertEquals(vinho.aceitar(taxador), vinho.getCusto() * 1.20);
	}
}