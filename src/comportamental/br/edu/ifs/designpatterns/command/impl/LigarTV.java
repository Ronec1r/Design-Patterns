package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Televisao;

public class LigarTV implements Comando {
    private Televisao tv;

    public LigarTV(Televisao tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        this.tv.ligar();
    }

    @Override
    public String toString() {
        return "ligar " + tv.getNome();
    }
}

