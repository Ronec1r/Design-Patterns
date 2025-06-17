/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import estrutural.br.edu.ifs.designpatterns.decorator.Component;
import estrutural.br.edu.ifs.designpatterns.decorator.Decorator;
import estrutural.br.edu.ifs.designpatterns.decorator.impl.Acucar;
import estrutural.br.edu.ifs.designpatterns.decorator.impl.Cafe;
import estrutural.br.edu.ifs.designpatterns.decorator.impl.Creme;
import estrutural.br.edu.ifs.designpatterns.decorator.impl.Leite;

/**
 *
 */
class TestDecorator {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Decorator")
	void test() {

		/*
		 * Definição de um componente que contém apenas café
		 */
		Component cafe = new Cafe();
		assertEquals(cafe.custo(), 4.0);
		assertEquals(cafe.getDescricao(), "Café");

		/*
		 * Definição de um componente que adiciona leite ao café
		 */
		Component cafeLeite = new Leite(cafe);
		assertEquals(cafeLeite.custo(), 4.5);
		assertEquals(cafeLeite.getDescricao(), "Café, com leite");

		/*
		 * Definição de um componente que adiciona leite e creme ao café
		 */
		Component cafeLeiteCreme = new Creme(cafeLeite);
		assertEquals(cafeLeiteCreme.custo(), 5.5);
		assertEquals(cafeLeiteCreme.getDescricao(), "Café, com leite, com creme");

		/*
		 * Definição de um componente que adiciona leite, creme e açúcar ao café
		 */
		Component cafeLeiteCremeAcucar = new Acucar(cafeLeiteCreme);
		assertEquals(cafeLeiteCremeAcucar.custo(), 5.8);
		assertEquals(cafeLeiteCremeAcucar.getDescricao(), "Café, com leite, com creme, com açúcar");

		/*
		 * Definição de um componente que adiciona apenas creme ao café
		 */
		Component cafeCreme = new Creme(cafe);
		assertEquals(cafeCreme.custo(), 5.0);
		assertEquals(cafeCreme.getDescricao(), "Café, com creme");

		/*
		 * Definição de um componente que adiciona apenas açúcar ao café
		 */
		Component cafeAcucar = new Acucar(cafe);
		assertEquals(cafeAcucar.custo(), 4.3);
		assertEquals(cafeAcucar.getDescricao(), "Café, com açúcar");

		/*
		 * Definição de um componente que adiciona açúcar duas vezes ao café
		 */
		Component cafeAcucarAcucar = new Acucar(cafeAcucar);
		assertEquals(cafeAcucarAcucar.custo(), 4.6);
		assertEquals(cafeAcucarAcucar.getDescricao(), "Café, com açúcar, com açúcar");
	}
}