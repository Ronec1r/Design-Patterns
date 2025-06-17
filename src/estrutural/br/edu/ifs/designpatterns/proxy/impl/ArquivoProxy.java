package estrutural.br.edu.ifs.designpatterns.proxy.impl;

import estrutural.br.edu.ifs.designpatterns.proxy.Arquivo;


public class ArquivoProxy implements Arquivo {
    private ArquivoReal arquivoReal;
    private Permissao permissao;

    public ArquivoProxy(String nomeArquivo, Permissao permissao) {
        this.arquivoReal =  new ArquivoReal(nomeArquivo);
        this.permissao = permissao;
    }

    @Override
    public void criar() {
        if (!permissao.podeEscrever()) {
            throw new IllegalStateException("Acesso negado!");
        }
        this.arquivoReal.criar();
    }

    @Override
    public String recuperar() {
        if (!permissao.podeLer()) {
            throw new IllegalStateException("Acesso negado!"); // Exceção esperada pelo teste
        }
        return this.arquivoReal.recuperar();
    }

    @Override
    public void escrever(String escrita) {
        if (!permissao.podeEscrever()) {
            throw new IllegalStateException("Acesso negado!");
        }
        this.arquivoReal.escrever(escrita);
    }

    @Override
    public void remover() {
        if (!permissao.podeEscrever()) {
            throw new IllegalStateException("Acesso negado!");
        }
        this.arquivoReal.remover();
    }
}
