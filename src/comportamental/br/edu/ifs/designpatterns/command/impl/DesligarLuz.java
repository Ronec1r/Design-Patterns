package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Luz;

public class DesligarLuz implements Comando {
    private Luz luz;

    public DesligarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void executar() {
        this.luz.desligar();
    }
}

