package estrutural.br.edu.ifs.designpatterns.proxy.impl;

public class Permissao {
    private boolean leitura;
    private boolean escrita;

    public Permissao(boolean leitura, boolean escrita) {
        this.leitura = leitura;
        this.escrita = escrita;
    }

    public boolean podeLer(){
        return this.leitura;
    }

    public boolean podeEscrever(){
        return this.escrita;
    }
}
