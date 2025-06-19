package comportamental.br.edu.ifs.designpatterns.mediator.impl;

import comportamental.br.edu.ifs.designpatterns.mediator.Colaborador;
import comportamental.br.edu.ifs.designpatterns.mediator.Mediador;

public class Aeronave extends Colaborador {

    public Aeronave(String id, Mediador mediador) {
        super(id, mediador);
    }

    public String solicitarPouso(){
        return mediador.notificar(this, "solicitarPouso");
    }

    public String solicitarDecolagem(){
        return mediador.notificar(this, "solicitarDecolagem");
    }

}
