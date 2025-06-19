package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import comportamental.br.edu.ifs.designpatterns.memento.Armazenador;
import comportamental.br.edu.ifs.designpatterns.memento.impl.Jogo;

/**
 *
 */
class TestMemento {

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Memento")
	void test() {

		/*
		 * Iniciando e salvando o jogo:
		 * Saúde: 100
		 * Vidas: 3
		 */
		Jogo jogo = new Jogo();
		Armazenador armazenador = new Armazenador();
		armazenador.armazenar(jogo.salvar());

		/*
		 * Causando 50 pontos de dano e salvando o jogo:
		 * Saúde: 50
		 * Vidas: 3
		 */
		jogo.causarDano(20);
		jogo.causarDano(30);
		armazenador.armazenar(jogo.salvar());

		/*
		 * Causando 90 pontos de dano e salvando o jogo:
		 * Saúde: 100
		 * Vidas: 2
		 */
		jogo.causarDano(90);
		armazenador.armazenar(jogo.salvar());

		/*
		 * Causando 100 pontos de dano e salvando o jogo:
		 * Saúde: 100
		 * Vidas: 1
		 */
		jogo.causarDano(100);
		armazenador.armazenar(jogo.salvar());

		/*
		 * Causando 90 pontos de dano e salvando o jogo:
		 * Saúde: 10
		 * Vidas: 1
		 */
		jogo.causarDano(90);
		armazenador.armazenar(jogo.salvar());

		/*
		 * Causando 30 pontos de dano: Fim de jogo!
		 */
		Exception e = assertThrows(IllegalStateException.class, () -> jogo.causarDano(30));
		assertEquals(e.getMessage(), "Fim de Jogo");

		/*
		 * Restaurando o jogo:
		 * Saúde: 10
		 * Vidas: 1
		 */
		jogo.restaurar(armazenador.recuperar());
		assertEquals(jogo.toString(), "{saúde: 10, vidas: 1}");

		/*
		 * Restaurando o jogo:
		 * Saúde: 100
		 * Vidas: 1
		 */
		jogo.restaurar(armazenador.recuperar());
		assertEquals(jogo.toString(), "{saúde: 100, vidas: 1}");

		/*
		 * Restaurando o jogo:
		 * Saúde: 100
		 * Vidas: 2
		 */
		jogo.restaurar(armazenador.recuperar());
		assertEquals(jogo.toString(), "{saúde: 100, vidas: 2}");

		/*
		 * Restaurando o jogo:
		 * Saúde: 50
		 * Vidas: 3
		 */
		jogo.restaurar(armazenador.recuperar());
		assertEquals(jogo.toString(), "{saúde: 50, vidas: 3}");

		/*
		 * Restaurando para o início do jogo:
		 * Saúde: 100
		 * Vidas: 3
		 */
		jogo.restaurar(armazenador.recuperar());
		assertEquals(jogo.toString(), "{saúde: 100, vidas: 3}");

		/*
		 * Restaurando jogo com histórico vázio
		 */
		e = assertThrows(IllegalStateException.class, () -> jogo.restaurar(armazenador.recuperar()));
		assertEquals(e.getMessage(), "Histórico vazio");
	}
}