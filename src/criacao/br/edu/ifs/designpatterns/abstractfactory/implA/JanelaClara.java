package criacao.br.edu.ifs.designpatterns.abstractfactory.implA;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Janela;

public class JanelaClara implements Janela {
    String cor = "#FFFAFA";

    @Override
    public String obterCor() {
        return this.cor;
    }
}
