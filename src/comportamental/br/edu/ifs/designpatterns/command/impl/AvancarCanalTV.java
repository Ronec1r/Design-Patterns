package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Televisao;

public class AvancarCanalTV implements Comando {
    private Televisao tv;

    public AvancarCanalTV(Televisao tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        if(!this.tv.estaLigada()){
            throw new IllegalStateException("Televisão desligada");
        }
        this.tv.setCanal(this.tv.getCanal()+1);
    }
}
