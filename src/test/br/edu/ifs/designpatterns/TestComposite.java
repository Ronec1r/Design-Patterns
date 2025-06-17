/**
 * 
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estrutural.br.edu.ifs.designpatterns.composite.Componente;
import estrutural.br.edu.ifs.designpatterns.composite.impl.Combo;
import estrutural.br.edu.ifs.designpatterns.composite.impl.Item;

/**
 * 
 */
class TestComposite {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Composite")
	void test() {

		/*
		 * Definição dos itens básicos de uma lanchonete
		 */
		Componente refrigerante = new Item("Refrigerante", 7.0);
		Componente batafrita = new Item("Batata Frita", 10.0);
		Componente hamburguer = new Item("Hamburguer", 12.0);

		/*
		 * Verificação do cálculo de preço de cada produto
		 */
		assertEquals(refrigerante.calcularPreco(), 7.0);
		assertEquals(batafrita.calcularPreco(), 10.0);
		assertEquals(hamburguer.calcularPreco(), 12.0);

		/*
		 * Criando um combo com três batatas fritas
		 */
		Combo combo1 = new Combo("Combo só batatas");
		combo1.adicionar(batafrita);
		combo1.adicionar(batafrita);
		combo1.adicionar(batafrita);

		/*
		 * A classe Combo deve estender as funcionalidades da classe Componente
		 */
		assertInstanceOf(Componente.class, combo1);

		/*
		 * Verificando o valor do combo
		 */
		assertEquals(combo1.calcularPreco(), 30.0);

		/*
		 * Criando um combo com dois refrigerantes
		 */
		Combo combo2 = new Combo("Combo só refrigerantes");
		combo2.adicionar(refrigerante);
		combo2.adicionar(refrigerante);

		/*
		 * Verificando o valor do combo
		 */
		assertEquals(combo2.calcularPreco(), 14.0);

		/*
		 * Criando um combo com hamburguer, batata e refrigerante
		 */
		Combo combo3 = new Combo("Combo básico");
		combo3.adicionar(refrigerante);
		combo3.adicionar(hamburguer);
		combo3.adicionar(batafrita);

		/*
		 * Verificando o valor do combo
		 */
		assertEquals(combo3.calcularPreco(), 29.0);

		/*
		 * Criando um super combo que contém os outros combos criados
		 */
		Combo combo4 = new Combo("Super Combo");
		combo4.adicionar(combo1);
		combo4.adicionar(combo2);
		combo4.adicionar(combo3);

		/*
		 * Verificando o valor do combo
		 */
		assertEquals(combo4.calcularPreco(), 73.0);
	}
}