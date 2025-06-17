/**
 * 
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estrutural.br.edu.ifs.designpatterns.facade.Fachada;

/**
 * 
 */
class TestFacade {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Fachada")
	void test() {

		/*
		 * Construção da fachada do sistema.
		 * 
		 * Tal fachada tem a função de isolar os componentes do sistema, provendo um
		 * ponto único de acesso para, por exemplo, uma aplicação front-end.
		 */
		Fachada sistema = new Fachada();

		/*
		 * Verificando a 'base de dados' dos clientes
		 */
		assertTrue(sistema.listarClientes().isEmpty());

		/*
		 * Inserção de três clientes na 'base de dados' do sistema
		 */
		String idCliente1 = sistema.registrarCliente("Fulano da Silva");
		String idCliente2 = sistema.registrarCliente("Cicrano da Silva");
		String idCliente3 = sistema.registrarCliente("Beltrano da Silva");

		/*
		 * Verificação dos identificadores criados pelo sistema
		 */
		assertEquals(idCliente1, "Cli0001");
		assertEquals(idCliente2, "Cli0002");
		assertEquals(idCliente3, "Cli0003");

		/*
		 * Verificação da base de dados do sistema
		 */
		assertEquals(sistema.listarClientes().size(), 3);
		assertEquals(sistema.listarClientes().get(0), "Cli0001: Fulano da Silva");
		assertEquals(sistema.listarClientes().get(1), "Cli0002: Cicrano da Silva");
		assertEquals(sistema.listarClientes().get(2), "Cli0003: Beltrano da Silva");

		/*
		 * Verificando a 'base de dados' dos produtos
		 */
		assertTrue(sistema.listarProdutos().isEmpty());

		/*
		 * Inserção de três produtos na 'base de dados' do sistema
		 */
		String idProd1 = sistema.registrarProduto("Samsung Galaxy Tab S6 Lite", 1914.85);
		String idProd2 = sistema.registrarProduto("Smart TV 50\" 4K Ultra HD Samsung", 2374.05);
		String idProd3 = sistema.registrarProduto("Smartphone Samsung Galaxy A55", 1979.05);

		/*
		 * Verificação dos identificadores criados pelo sistema
		 */
		assertEquals(idProd1, "Pro0001");
		assertEquals(idProd2, "Pro0002");
		assertEquals(idProd3, "Pro0003");

		/*
		 * Verificação da base de dados do sistema
		 */
		assertEquals(sistema.listarProdutos().size(), 3);
		assertEquals(sistema.listarProdutos().get(0), "Pro0001: Samsung Galaxy Tab S6 Lite ... R$ 1914.85");
		assertEquals(sistema.listarProdutos().get(1), "Pro0002: Smart TV 50\" 4K Ultra HD Samsung ... R$ 2374.05");
		assertEquals(sistema.listarProdutos().get(2), "Pro0003: Smartphone Samsung Galaxy A55 ... R$ 1979.05");

		/*
		 * Verificando o total do pedido efetuado pelo cliente 1
		 */
		assertEquals(sistema.obterTotal(idCliente1), 0.0);

		/*
		 * Escolhendo produtos para o cliente 1
		 */
		sistema.escolherProduto(idCliente1, idProd1);
		assertEquals(sistema.obterTotal(idCliente1), 1914.85);
		sistema.escolherProduto(idCliente1, idProd2);
		assertEquals(sistema.obterTotal(idCliente1), 4288.90);
		sistema.escolherProduto(idCliente1, idProd3);
		assertEquals(sistema.obterTotal(idCliente1), 6267.95);

		/*
		 * Escolhendo produtos para o cliente 2
		 */
		sistema.escolherProduto(idCliente2, idProd2);
		assertEquals(sistema.obterTotal(idCliente2), 2374.05);

		/*
		 * Escolhendo produtos para o cliente 3
		 */
		sistema.escolherProduto(idCliente3, idProd3);
		assertEquals(sistema.obterTotal(idCliente3), 1979.05);
		sistema.escolherProduto(idCliente3, idProd3);
		assertEquals(sistema.obterTotal(idCliente3), 3958.1);

		/*
		 * Fechando os pedidos
		 */
		String idPed1 = sistema.fecharCompra(idCliente1);
		String idPed2 = sistema.fecharCompra(idCliente2);
		String idPed3 = sistema.fecharCompra(idCliente3);

		assertEquals(idPed1, "Ped0001");
		assertEquals(idPed2, "Ped0002");
		assertEquals(idPed3, "Ped0003");

		/*
		 * Fazendo mais um pedido para o cliente 2
		 */
		sistema.escolherProduto(idCliente2, idProd3);
		assertEquals(sistema.obterTotal(idCliente2), 1979.05);

		/*
		 * Fechando o pedido
		 */
		String idPed4 = sistema.fecharCompra(idCliente2);
		assertEquals(idPed4, "Ped0004");

		/*
		 * Verificando o histórico de pedidos armazenados na 'base de dados'
		 */
		assertEquals(sistema.listarPedidos(idCliente1).size(), 1);
		assertEquals(sistema.listarPedidos(idCliente2).size(), 2);
		assertEquals(sistema.listarPedidos(idCliente3).size(), 1);

		/*
		 * Verificando o conteúdo do pedido
		 */
		StringBuilder pedido = new StringBuilder();
		pedido.append("[Ped0002: ").append("[Pro0002: Smart TV 50\" 4K Ultra HD Samsung ... R$ 2374.05], ");
		pedido.append("Ped0004: ").append("[Pro0003: Smartphone Samsung Galaxy A55 ... R$ 1979.05]]");

		assertEquals(sistema.listarPedidos(idCliente2).toString(), pedido.toString());
	}
}