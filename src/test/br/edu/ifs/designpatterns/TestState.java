/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comportamental.br.edu.ifs.designpatterns.state.Mario;

/**
 *
 */
class TestState {

	/*
	 * Nome dos estados permitidos
	 */
	private final String MARIO_PEQUENO = "Mario pequeno";
	private final String MARIO_SUPER = "Super Mario";
	private final String MARIO_FOGO = "Mario de fogo";
	private final String MARIO_VOADOR = "Mario voador";
	private final String MARIO_MORTO = "Mario morto";

	/*
	 * Nomes dos ataques permitidos
	 */
	private final String ATAQUE_PEQUENO = "Salto";
	private final String ATAQUE_SUPER = "Super salto";
	private final String ATAQUE_FOGO = "Bola de fogo";
	private final String ATAQUE_PENA = "Capa giratória";

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste State")
	void test() {

		/*
		 * Inicialização do personagem Mário, que inicia com as características do Mário
		 * Pequeno.
		 */
		Mario mario = new Mario();
		assertEquals(mario.atacar(), ATAQUE_PEQUENO);
		assertEquals(mario.obterEstado(), MARIO_PEQUENO);

		/*
		 * Alteração do estado do Mário, que passa a se comportar como Super Mário.
		 */
		mario.pegarCogumelo();
		assertEquals(mario.atacar(), ATAQUE_SUPER);
		assertEquals(mario.obterEstado(), MARIO_SUPER);

		/*
		 * Após a aplicação da transformação, não deve haver alteração do estado do
		 * Mário.
		 */
		mario.pegarCogumelo();
		assertEquals(mario.atacar(), ATAQUE_SUPER);
		assertEquals(mario.obterEstado(), MARIO_SUPER);

		/*
		 * Alteração do estado do Mário, que passa a se comportar como Mário de Fogo.
		 */
		mario.pegarFlor();
		assertEquals(mario.atacar(), ATAQUE_FOGO);
		assertEquals(mario.obterEstado(), MARIO_FOGO);

		/*
		 * Após a aplicação da transformação, não deve haver alteração do estado do
		 * Mário.
		 */
		mario.pegarFlor();
		assertEquals(mario.atacar(), ATAQUE_FOGO);
		assertEquals(mario.obterEstado(), MARIO_FOGO);

		/*
		 * Após a aplicação da transformação, não deve haver alteração do estado do
		 * Mário.
		 */
		mario.pegarCogumelo();
		assertEquals(mario.atacar(), ATAQUE_FOGO);
		assertEquals(mario.obterEstado(), MARIO_FOGO);

		/*
		 * Alteração do estado do Mário, que passa a se comportar como Mário Voador.
		 */
		mario.pegarPena();
		assertEquals(mario.atacar(), ATAQUE_PENA);
		assertEquals(mario.obterEstado(), MARIO_VOADOR);

		/*
		 * Após a aplicação da transformação, não deve haver alteração do estado do
		 * Mário.
		 */
		mario.pegarPena();
		assertEquals(mario.atacar(), ATAQUE_PENA);
		assertEquals(mario.obterEstado(), MARIO_VOADOR);

		/*
		 * Após a aplicação da transformação, não deve haver alteração do estado do
		 * Mário.
		 */
		mario.pegarCogumelo();
		assertEquals(mario.atacar(), ATAQUE_PENA);
		assertEquals(mario.obterEstado(), MARIO_VOADOR);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Super Mário.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_SUPER);
		assertEquals(mario.obterEstado(), MARIO_SUPER);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Mário Pequeno.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_PEQUENO);
		assertEquals(mario.obterEstado(), MARIO_PEQUENO);

		/*
		 * Alteração do estado do Mário, que passa a se comportar como Mário Voador.
		 */
		mario.pegarPena();
		assertEquals(mario.atacar(), ATAQUE_PENA);
		assertEquals(mario.obterEstado(), MARIO_VOADOR);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Super Mário.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_SUPER);
		assertEquals(mario.obterEstado(), MARIO_SUPER);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Mário Pequeno.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_PEQUENO);
		assertEquals(mario.obterEstado(), MARIO_PEQUENO);

		/*
		 * Alteração do estado do Mário, que passa a se comportar como Mário de Fogo.
		 */
		mario.pegarFlor();
		assertEquals(mario.atacar(), ATAQUE_FOGO);
		assertEquals(mario.obterEstado(), MARIO_FOGO);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Super Mário.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_SUPER);
		assertEquals(mario.obterEstado(), MARIO_SUPER);

		/*
		 * Alteração do estado do Mário, que volta a se comportar como Mário Pequeno.
		 */
		mario.sofreDano();
		assertEquals(mario.atacar(), ATAQUE_PEQUENO);
		assertEquals(mario.obterEstado(), MARIO_PEQUENO);

		/*
		 * Alteração do estado do Mário, que assume o estado de Morto (fim de Jogo).
		 */
		mario.sofreDano();
		assertEquals(mario.obterEstado(), MARIO_MORTO);

		/*
		 * Novas tentativas de mudança do estado do Mário não devem surtir efeito.
		 */
		Exception e = assertThrows(IllegalStateException.class, () -> mario.atacar());
		assertEquals(e.getMessage(), "Mario está sem vida!");

		e = assertThrows(IllegalStateException.class, () -> mario.pegarCogumelo(), "Mario está sem vida!");
		assertEquals(e.getMessage(), "Mario está sem vida!");

		e = assertThrows(IllegalStateException.class, () -> mario.pegarPena(), "Mario está sem vida!");
		assertEquals(e.getMessage(), "Mario está sem vida!");

		e = assertThrows(IllegalStateException.class, () -> mario.pegarFlor(), "Mario está sem vida!");
		assertEquals(e.getMessage(), "Mario está sem vida!");

		e = assertThrows(IllegalStateException.class, () -> mario.sofreDano(), "Mario está sem vida!");
		assertEquals(e.getMessage(), "Mario está sem vida!");
	}
}