/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import comportamental.br.edu.ifs.designpatterns.chain.Analisador;
import comportamental.br.edu.ifs.designpatterns.chain.impl.AnalistaCredito;
import comportamental.br.edu.ifs.designpatterns.chain.impl.AnalistaRisco;
import comportamental.br.edu.ifs.designpatterns.chain.impl.Emprestimo;
import comportamental.br.edu.ifs.designpatterns.chain.impl.Gerente;
import comportamental.br.edu.ifs.designpatterns.chain.impl.RequisicaoEmprestimo;

/**
 *
 */
class TestChainResposibility {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Chain Responsibility")
	void test() {

		/*
		 * Construção da cadeia de análise da solicitação do empréstimo
		 */
		Analisador analistaCredito = new AnalistaCredito();
		Analisador analistaRisco = new AnalistaRisco();
		Analisador gerente = new Gerente();

		/*
		 * Estabelecendo a ordem da cadeia de análise da solicitação do empréstimo
		 */
		analistaCredito.definirSucessor(analistaRisco);
		analistaRisco.definirSucessor(gerente);

		/*
		 * Requisição de um empréstimo acima da faixa de renda do solicitante
		 * 
		 * Não devem ser permitidos empréstimos acima de 30% da renda do solicitante
		 */
		RequisicaoEmprestimo requisicao1 = new RequisicaoEmprestimo(5000, 10000, 500);

		Exception e = assertThrows(IllegalStateException.class, () -> analistaCredito.processarRequisicao(requisicao1));
		assertEquals(e.getMessage(), "Analista de crédito: Reprovado! Renda insuficiente.");

		/*
		 * Requisição de um empréstimo de um cliente com baixa pontuação de renda
		 * 
		 * Não devem ser permitidos empréstimos para solicitantes com score de crédito
		 * menor do que 700 pontos
		 */
		RequisicaoEmprestimo requisicao2 = new RequisicaoEmprestimo(2000, 10000, 500);

		e = assertThrows(IllegalStateException.class, () -> analistaCredito.processarRequisicao(requisicao2));
		assertEquals(e.getMessage(), "Analista de risco: Reprovado! Score de crédito baixo.");

		/*
		 * Requisição de um empréstimo de um cliente dentro da normalidade
		 */
		RequisicaoEmprestimo requisicao3 = new RequisicaoEmprestimo(3000, 10000, 800);

		Emprestimo emprestimo = analistaCredito.processarRequisicao(requisicao3);
		assertEquals(emprestimo.getValor(), requisicao3.getValor());
	}
}