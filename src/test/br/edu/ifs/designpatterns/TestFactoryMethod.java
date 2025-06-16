/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import criacao.br.edu.ifs.designpatterns.factorymethod.FabricaPersonagens;
import criacao.br.edu.ifs.designpatterns.factorymethod.Personagem;
import criacao.br.edu.ifs.designpatterns.factorymethod.impl.Anao;
import criacao.br.edu.ifs.designpatterns.factorymethod.impl.Elfo;
import criacao.br.edu.ifs.designpatterns.factorymethod.impl.Humano;
import criacao.br.edu.ifs.designpatterns.factorymethod.impl.Orc;

/**
 *
 */
class TestFactoryMethod {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Factory Method")
	void test() {

		/*
		 * Construção de um personagem que não existe
		 */
		Exception e = assertThrows(IllegalStateException.class, () -> FabricaPersonagens.criarPersonagem("outro"));
		assertEquals(e.getMessage(), "Personagem não encontrado!");

		/*
		 * Construção dos personagens
		 */
		Personagem orc = FabricaPersonagens.criarPersonagem("orc");
		Personagem anao = FabricaPersonagens.criarPersonagem("anão");
		Personagem elfo = FabricaPersonagens.criarPersonagem("elfo");
		Personagem humano = FabricaPersonagens.criarPersonagem("humano");

		/*
		 * Verificação das características de cada personagem
		 */
		assertInstanceOf(Orc.class, orc);
		assertEquals(orc.atacar(), "Ataque: garras");
		assertEquals(orc.defender(), "Defesa: absorver");
		assertEquals(orc.usarMagia(), "Magia: espirito maligno");

		assertInstanceOf(Anao.class, anao);
		assertEquals(anao.atacar(), "Ataque: machado");
		assertEquals(anao.defender(), "Defesa: escudo");
		assertEquals(anao.usarMagia(), "Magia: resistência");

		assertInstanceOf(Elfo.class, elfo);
		assertEquals(elfo.atacar(), "Ataque: arco e flecha");
		assertEquals(elfo.defender(), "Defesa: esquiva");
		assertEquals(elfo.usarMagia(), "Magia: cura");

		assertInstanceOf(Humano.class, humano);
		assertEquals(humano.atacar(), "Ataque: espada");
		assertEquals(humano.defender(), "Defesa: rolar");
		assertEquals(humano.usarMagia(), "Magia: raio de luz");
	}
}