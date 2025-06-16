package criacao.br.edu.ifs.designpatterns.abstractfactory.implA;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Menu;

public class MenuClaro implements Menu {
    String cor = "#FFFAFA";

    @Override
    public String obterCor() {
        return this.cor;
    }
}
