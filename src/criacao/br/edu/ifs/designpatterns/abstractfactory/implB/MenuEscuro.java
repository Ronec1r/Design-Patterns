package criacao.br.edu.ifs.designpatterns.abstractfactory.implB;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Menu;

public class MenuEscuro implements Menu {
    String cor = "#4F4F4F";

    @Override
    public String obterCor() {
        return this.cor;
    }
}
