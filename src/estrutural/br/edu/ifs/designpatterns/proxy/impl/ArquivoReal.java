package estrutural.br.edu.ifs.designpatterns.proxy.impl;

import estrutural.br.edu.ifs.designpatterns.proxy.Arquivo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class ArquivoReal implements Arquivo {
    private final Path caminhoArquivo;

    public ArquivoReal(String caminhoArquivo) {
        this.caminhoArquivo = Paths.get(caminhoArquivo);
    }

    private Path getCaminho() {
        return this.caminhoArquivo;
    }


    @Override
    public void criar() {
        Path diretorioPai = getCaminho().getParent();
        try {
            if (diretorioPai != null) {
                Files.createDirectories(diretorioPai);
            }
            if (!Files.exists(getCaminho())) {
                Files.createFile(getCaminho());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro interno ao criar arquivo: " + e.getMessage(), e);
        }
    }

    @Override
    public String recuperar() {
        try {
            if (Files.exists(getCaminho())) {
                return Files.readAllLines(getCaminho(), StandardCharsets.UTF_8)
                        .stream()
                        .collect(Collectors.joining("\n"));
            }
            return ""; // Retorna string vazia se o arquivo não existir
        } catch (IOException e) {
            throw new RuntimeException("Erro interno ao recuperar arquivo: " + e.getMessage(), e);
        }
    }

    @Override
    public void escrever(String escrita) {
        try {
            boolean existeEnaoVazio = Files.exists(getCaminho()) && Files.size(getCaminho()) > 0;
            String conteudoParaEscrever = escrita;
            if (existeEnaoVazio) {
                conteudoParaEscrever = "\n" + escrita;
            }
            Files.write(getCaminho(), conteudoParaEscrever.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException("Erro interno ao escrever no arquivo: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover() {
        try {
            if (Files.exists(getCaminho())) {
                Files.delete(getCaminho());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro interno ao remover arquivo: " + e.getMessage(), e);
        }
    }
}
