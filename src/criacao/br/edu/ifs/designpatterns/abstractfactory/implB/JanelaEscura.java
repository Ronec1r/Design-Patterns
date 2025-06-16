package criacao.br.edu.ifs.designpatterns.abstractfactory.implB;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Janela;

public class JanelaEscura implements Janela {
    String cor = "#4F4F4F";

    @Override
    public String obterCor() {
        return this.cor;
    }
}
