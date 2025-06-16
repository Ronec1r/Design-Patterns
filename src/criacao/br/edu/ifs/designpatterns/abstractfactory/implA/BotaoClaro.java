package criacao.br.edu.ifs.designpatterns.abstractfactory.implA;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Botao;

public class BotaoClaro implements Botao {
    String cor = "#FFFAFA";

    @Override
    public String obterCor() {
        return this.cor;
    }
}
