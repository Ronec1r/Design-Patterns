/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Path;

import estrutural.br.edu.ifs.designpatterns.proxy.impl.ArquivoReal;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estrutural.br.edu.ifs.designpatterns.proxy.Arquivo;
import estrutural.br.edu.ifs.designpatterns.proxy.impl.ArquivoProxy;
import estrutural.br.edu.ifs.designpatterns.proxy.impl.Permissao;

/**
 *
 */
class TestProxy {

	private static String nome = "arquivos/teste.txt";

	/**
	 *
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		/*
		 * Remove o arquivo, caso já exista
		 */
		if (Files.exists(Path.of(nome))) {

			Files.delete(Path.of(nome));
		}
	}

	/**
	 *
	 * @throws Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {

		/*
		 * Remove o arquivo, caso não tenha sido removido
		 */
		if (Files.exists(Path.of(nome))) {

			Files.delete(Path.of(nome));
		}
	}

	/**
	 *
	 */
	@Test
	@DisplayName("Teste Proxy")
	void test() {

		/*
		 * Definição de uma mensagem padrão que será inserida no arquivo.
		 */
		String texto = "Testando escrita no arquivo.";

		/*
		 * Operações sobre um arquivo de um usuário sem nenhuma permissão
		 */
		Arquivo arquivo1 = new ArquivoProxy(nome, new Permissao(false, false));

		Exception e = assertThrows(IllegalStateException.class, () -> arquivo1.criar());
		assertEquals(e.getMessage(), "Acesso negado!");

		e = assertThrows(IllegalStateException.class, () -> arquivo1.escrever(texto));
		assertEquals(e.getMessage(), "Acesso negado!");

		e = assertThrows(IllegalStateException.class, () -> arquivo1.recuperar());
		assertEquals(e.getMessage(), "Acesso negado!");

		e = assertThrows(IllegalStateException.class, () -> arquivo1.remover());
		assertEquals(e.getMessage(), "Acesso negado!");

		/*
		 * Operações sobre um arquivo de um usuário apenas com permissão de escrita
		 */
		Arquivo arquivo2 = new ArquivoProxy(nome, new Permissao(false, true));

		assertDoesNotThrow(() -> arquivo2.criar());
		assertDoesNotThrow(() -> arquivo2.escrever(texto));

		e = assertThrows(IllegalStateException.class, () -> arquivo2.recuperar());
		assertEquals(e.getMessage(), "Acesso negado!");

		assertDoesNotThrow(() -> arquivo2.remover());

		/*
		 * Operações sobre um arquivo de um usuário com permissão de leitura e escrita
		 */
		Arquivo arquivo3 = new ArquivoProxy(nome, new Permissao(true, true));

		assertDoesNotThrow(() -> arquivo3.criar());
		assertDoesNotThrow(() -> arquivo3.escrever(texto));
		assertEquals(arquivo3.recuperar(), texto);
		assertDoesNotThrow(() -> arquivo3.escrever(texto));
		assertEquals(arquivo3.recuperar(), texto + "\n" + texto);
		assertDoesNotThrow(() -> arquivo3.remover());
	}
}