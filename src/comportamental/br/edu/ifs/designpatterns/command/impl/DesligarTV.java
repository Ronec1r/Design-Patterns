package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Televisao;

public class DesligarTV implements Comando {
    private Televisao tv;

    public DesligarTV(Televisao tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        this.tv.desligar();
    }
}

