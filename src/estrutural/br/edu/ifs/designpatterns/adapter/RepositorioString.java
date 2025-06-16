package estrutural.br.edu.ifs.designpatterns.adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 *
 */
public class RepositorioString {

	/*
	 *
	 */
	private String arquivo;

	/**
	 *
	 */
	public RepositorioString(String arquivo) {

		this.arquivo = arquivo;
	}

	/**
	 *
	 * @return
	 */
	public String recuperarDados() {

		/*
		 *
		 */
		try {

			/*
			 * Recuperando os dados do arquivo
			 */
			return Files.lines(Path.of(this.arquivo)).collect(Collectors.joining(";"));

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}
}
