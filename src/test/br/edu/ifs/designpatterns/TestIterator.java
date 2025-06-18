/**
 *
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import comportamental.br.edu.ifs.designpatterns.iterator.Agregador;
import comportamental.br.edu.ifs.designpatterns.iterator.Iterador;
import comportamental.br.edu.ifs.designpatterns.iterator.impl.Musica;
import comportamental.br.edu.ifs.designpatterns.iterator.impl.PlaylistArtistas;
import comportamental.br.edu.ifs.designpatterns.iterator.impl.PlaylistMusicas;

/**
 *
 */
class TestIterator {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Iterator")
	void test() {

		/*
		 * Definição das músicas que serão inseridas na playlist
		 */
		Musica musica01 = new Musica("Anna Júlia", "Los Hermanos");
		Musica musica02 = new Musica("Ideologia", "Cazuza");
		Musica musica03 = new Musica("Apesar de Você", "Chico Buarque");
		Musica musica04 = new Musica("Diário de um Detento", "Racionais MC's");
		Musica musica05 = new Musica("Como Nossos Pais", "Elis Regina");
		Musica musica06 = new Musica("O Bêbado e a Equilibrista", "Elis Regina");
		Musica musica07 = new Musica("Sinal Fechado", "Chico Buarque");
		Musica musica08 = new Musica("A Casa Pré-Fabricada", "Los Hermanos");
		Musica musica09 = new Musica("O Mundo é um Moinho", "Cartola");
		Musica musica10 = new Musica("Construção", "Chico Buarque");

		/*
		 * Definição de uma playlist de músicas
		 */
		PlaylistMusicas playlistMusicas = new PlaylistMusicas();
		playlistMusicas.adicionar(musica01);
		playlistMusicas.adicionar(musica02);
		playlistMusicas.adicionar(musica03);
		playlistMusicas.adicionar(musica04);
		playlistMusicas.adicionar(musica05);
		playlistMusicas.adicionar(musica06);
		playlistMusicas.adicionar(musica07);
		playlistMusicas.adicionar(musica08);
		playlistMusicas.adicionar(musica09);
		playlistMusicas.adicionar(musica10);

		/*
		 * A Playlist de Músicas devem implenentar a interface Agregador
		 */
		assertInstanceOf(Agregador.class, playlistMusicas);

		/*
		 * Obtenção do iterador que irá percorrer as músicas na ordem que foram
		 * inseridas na playlist
		 */
		Iterador<Musica> iterador = playlistMusicas.criarIterador();

		assertEquals(iterador.proximo(), musica01);
		assertEquals(iterador.proximo(), musica02);
		assertEquals(iterador.proximo(), musica03);
		assertEquals(iterador.proximo(), musica04);
		assertEquals(iterador.proximo(), musica05);
		assertEquals(iterador.proximo(), musica06);
		assertEquals(iterador.proximo(), musica07);
		assertEquals(iterador.proximo(), musica08);
		assertEquals(iterador.proximo(), musica09);
		assertEquals(iterador.proximo(), musica10);

		assertFalse(iterador.temProximo());

		/*
		 * Definição de uma playlist que agrupa as músicas por artista
		 */
		PlaylistArtistas playlistArtistas = new PlaylistArtistas();
		playlistArtistas.adicionar(musica01);
		playlistArtistas.adicionar(musica02);
		playlistArtistas.adicionar(musica03);
		playlistArtistas.adicionar(musica04);
		playlistArtistas.adicionar(musica05);
		playlistArtistas.adicionar(musica06);
		playlistArtistas.adicionar(musica07);
		playlistArtistas.adicionar(musica08);
		playlistArtistas.adicionar(musica09);
		playlistArtistas.adicionar(musica10);

		/*
		 * Obtenção do iterador que irá percorrer com base nos artista em ordem
		 * alfabética
		 */
		iterador = playlistArtistas.criarIterador();

		assertEquals(iterador.proximo(), musica09);
		assertEquals(iterador.proximo(), musica02);
		assertEquals(iterador.proximo(), musica03);
		assertEquals(iterador.proximo(), musica07);
		assertEquals(iterador.proximo(), musica10);
		assertEquals(iterador.proximo(), musica05);
		assertEquals(iterador.proximo(), musica06);
		assertEquals(iterador.proximo(), musica01);
		assertEquals(iterador.proximo(), musica08);
		assertEquals(iterador.proximo(), musica04);

		assertFalse(iterador.temProximo());
	}
}