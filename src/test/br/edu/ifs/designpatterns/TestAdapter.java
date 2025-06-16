/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estrutural.br.edu.ifs.designpatterns.adapter.Repositorio;
import estrutural.br.edu.ifs.designpatterns.adapter.RepositorioLista;
import estrutural.br.edu.ifs.designpatterns.adapter.RepositorioString;
import estrutural.br.edu.ifs.designpatterns.adapter.impl.AdaptadorLista;
import estrutural.br.edu.ifs.designpatterns.adapter.impl.AdaptadorString;

/**
 * 
 */
class TestAdapter {

	static Map<String, String> alunos;

	/**
	 *
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		/*
		 * Configurando os dados dos alunos que serão utilizados na comparação com os
		 * dados recuperados
		 */
		alunos = new HashMap<>();

		alunos.put("2021001925", "GEOVANE SANTOS ROCHA");
		alunos.put("2020009061", "IAGO BARRETTO SOARES");
		alunos.put("2021004041", "JOÃO FERNANDES SANTOS FILHO");
		alunos.put("2020005812", "MARCO AURÉLIO FONSECA DE SOUZA");
		alunos.put("2021004524", "MATHEUS CAVALCANTI DOS SANTOS");
		alunos.put("2021002619", "RAFAEL DE JESUS CARVALHO");
		alunos.put("2020008340", "RONE CLAY OLIVEIRA ANDRADE");
		alunos.put("2019004518", "WILLIAM REZENDE SANTOS");
	}

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Adapter")
	void test() {

		final String arquivo = "src/arquivos/alunos.txt";

		/*
		 * Instanciando um repositório com um adaptador que recupera uma lista de dados
		 */
		Repositorio repositorio = new AdaptadorLista(new RepositorioLista(arquivo));


		/*
		 * Verificando os alunos obtidos a partir do repositório
		 */
		assertEquals(alunos, repositorio.obterAlunos());

		/*
		 * Instanciando um repositório com um adaptador que recupera uma string de dados
		 */
		repositorio = new AdaptadorString(new RepositorioString(arquivo));

		/*
		 * Verificando os alunos obtidos a partir do repositório
		 */
		assertEquals(alunos, repositorio.obterAlunos());

	}
}
