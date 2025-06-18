package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Televisao;

public class RetrocederCanalTV implements Comando {
    private Televisao tv;

    public RetrocederCanalTV(Televisao tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        if(!this.tv.estaLigada()){
            throw new IllegalStateException("Televisão desligada");
        }
        if(this.tv.getCanal()>0){
            this.tv.setCanal(this.tv.getCanal()-1);
        }
    }
}

