/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import estrutural.br.edu.ifs.designpatterns.flyweight.FabricaBlocos;
import estrutural.br.edu.ifs.designpatterns.flyweight.Flyweight;
import estrutural.br.edu.ifs.designpatterns.flyweight.impl.Bloco;

/**
 *
 */
class TesteFlyweight {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Flyweight")
	void test() {

		/*
		 * Construção de blocos do tipo Pedra e posicionamento nas coordenadas x, y e z.
		 * 
		 * Quando um bloco é construído, são adicionadas dois tipos de informações:
		 * 
		 * Informações extrínsecas: coordenadas x, y e z.
		 * 
		 * Informações intrínsecas: tipo de bloco e suas características (quebrável,
		 * inflamável e empilhável).
		 */
		boolean quebravel = true;
		boolean inflamavel = false;
		boolean empilhavel = true;

		Bloco blocoPedra1 = new Bloco(0, 0, 0, FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));
		Bloco blocoPedra2 = new Bloco(1, 0, 0, FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));
		Bloco blocoPedra3 = new Bloco(2, 0, 0, FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));

		/*
		 * Verificando se as informações intrínsecas fazem referência ao mesmo objeto.
		 * 
		 * Essa é a principal característica do padrão de projeto Fliweight.
		 */
		assertSame(blocoPedra1.getTipo(), FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));
		assertSame(blocoPedra2.getTipo(), FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));
		assertSame(blocoPedra3.getTipo(), FabricaBlocos.obterTipo("Pedra", quebravel, inflamavel, empilhavel));
		assertInstanceOf(Flyweight.class, blocoPedra1.getTipo());

		/*
		 * Verificando se as informações intrínsecas e extrínsecas estão sendo
		 * apresentadas corretamente.
		 */
		assertEquals(blocoPedra1.mostrar(), "Pedra, quebrável, inflamável, empilhável, x: 0, y: 0, z: 0");
		assertEquals(blocoPedra2.mostrar(), "Pedra, quebrável, inflamável, empilhável, x: 1, y: 0, z: 0");
		assertEquals(blocoPedra3.mostrar(), "Pedra, quebrável, inflamável, empilhável, x: 2, y: 0, z: 0");

		/*
		 * Construção de blocos do tipo Ar e posicionamento nas coordenadas x, y e z.
		 * 
		 * Quando um bloco é construído, são adicionadas dois tipos de informações:
		 * 
		 * Informações extrínsecas: coordenadas x, y e z.
		 * 
		 * Informações intrínsecas: tipo de bloco e suas características (quebrável,
		 * inflamável e empilhável).
		 */
		quebravel = false;
		inflamavel = false;
		empilhavel = false;

		Bloco blocoAr1 = new Bloco(3, 0, 0, FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));
		Bloco blocoAr2 = new Bloco(4, 0, 0, FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));
		Bloco blocoAr3 = new Bloco(5, 0, 0, FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));

		/*
		 * Verificando se as informações intrínsecas fazem referência ao mesmo objeto.
		 * 
		 * Essa é a principal característica do padrão de projeto Fliweight.
		 */
		assertSame(blocoAr1.getTipo(), FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));
		assertSame(blocoAr2.getTipo(), FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));
		assertSame(blocoAr3.getTipo(), FabricaBlocos.obterTipo("Ar", quebravel, inflamavel, empilhavel));
		assertInstanceOf(Flyweight.class, blocoAr1.getTipo());

		/*
		 * Verificando se as informações intrínsecas e extrínsecas estão sendo
		 * apresentadas corretamente.
		 */
		assertEquals(blocoAr1.mostrar(), "Ar, inquebrável, inflamável, não empilhável, x: 3, y: 0, z: 0");
		assertEquals(blocoAr2.mostrar(), "Ar, inquebrável, inflamável, não empilhável, x: 4, y: 0, z: 0");
		assertEquals(blocoAr3.mostrar(), "Ar, inquebrável, inflamável, não empilhável, x: 5, y: 0, z: 0");

		/*
		 * Construção de blocos do tipo Areia e posicionamento nas coordenadas x, y e z.
		 * 
		 * Quando um bloco é construído, são adicionadas dois tipos de informações:
		 * 
		 * Informações extrínsecas: coordenadas x, y e z.
		 * 
		 * Informações intrínsecas: tipo de bloco e suas características (quebrável,
		 * inflamável e empilhável).
		 */
		quebravel = true;
		inflamavel = false;
		empilhavel = true;

		Bloco areia1 = new Bloco(6, 0, 0, FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));
		Bloco areia2 = new Bloco(7, 0, 0, FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));
		Bloco areia3 = new Bloco(8, 0, 0, FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));

		/*
		 * Verificando se as informações intrínsecas fazem referência ao mesmo objeto.
		 * 
		 * Essa é a principal característica do padrão de projeto Fliweight.
		 */
		assertSame(areia1.getTipo(), FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));
		assertSame(areia2.getTipo(), FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));
		assertSame(areia3.getTipo(), FabricaBlocos.obterTipo("Areia", quebravel, inflamavel, empilhavel));
		assertInstanceOf(Flyweight.class, areia1.getTipo());

		/*
		 * Verificando se as informações intrínsecas e extrínsecas estão sendo
		 * apresentadas corretamente.
		 */
		assertEquals(areia1.mostrar(), "Areia, quebrável, inflamável, empilhável, x: 6, y: 0, z: 0");
		assertEquals(areia2.mostrar(), "Areia, quebrável, inflamável, empilhável, x: 7, y: 0, z: 0");
		assertEquals(areia3.mostrar(), "Areia, quebrável, inflamável, empilhável, x: 8, y: 0, z: 0");

		/*
		 * Construção de blocos do tipo Neve e posicionamento nas coordenadas x, y e z.
		 * 
		 * Quando um bloco é construído, são adicionadas dois tipos de informações:
		 * 
		 * Informações extrínsecas: coordenadas x, y e z.
		 * 
		 * Informações intrínsecas: tipo de bloco e suas características (quebrável,
		 * inflamável e empilhável).
		 */
		quebravel = true;
		inflamavel = false;
		empilhavel = true;

		Bloco neve1 = new Bloco(9, 0, 0, FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		Bloco neve2 = new Bloco(10, 0, 0, FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		Bloco neve3 = new Bloco(11, 0, 0, FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		
		/*
		 * Verificando se as informações intrínsecas fazem referência ao mesmo objeto.
		 * 
		 * Essa é a principal característica do padrão de projeto Fliweight.
		 */
		assertSame(neve1.getTipo(), FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		assertSame(neve2.getTipo(), FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		assertSame(neve3.getTipo(), FabricaBlocos.obterTipo("Neve", quebravel, inflamavel, empilhavel));
		assertInstanceOf(Flyweight.class, neve1.getTipo());
		
		/*
		 * Verificando se as informações intrínsecas e extrínsecas estão sendo
		 * apresentadas corretamente.
		 */
		assertEquals(neve1.mostrar(), "Neve, quebrável, inflamável, empilhável, x: 9, y: 0, z: 0");
		assertEquals(neve2.mostrar(), "Neve, quebrável, inflamável, empilhável, x: 10, y: 0, z: 0");
		assertEquals(neve3.mostrar(), "Neve, quebrável, inflamável, empilhável, x: 11, y: 0, z: 0");
	}
}