package estrutural.br.edu.ifs.designpatterns.adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 */
public class RepositorioLista {

	/*
	 *
	 */
	private String arquivo;

	/**
	 *
	 */
	public RepositorioLista(String arquivo) {

		this.arquivo = arquivo;
	}

	/**
	 *
	 * @return
	 */
	public List<String> recuperarDados() {

		/*
		 *
		 */
		try {

			/*
			 * Recuperando os dados do arquivo
			 */
			return Files.lines(Path.of(this.arquivo)).toList();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}
}
