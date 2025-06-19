package comportamental.br.edu.ifs.designpatterns.mediator.impl;

import comportamental.br.edu.ifs.designpatterns.mediator.Colaborador;
import comportamental.br.edu.ifs.designpatterns.mediator.Mediador;

public class Metereologia extends Colaborador {
    private boolean condicoesFavoraveis=false;
    private String ultimoResultado="";

    public Metereologia(String id, Mediador mediador) {
        super(id, mediador);
    }

    public String informarCondicoes(){

        return this.ultimoResultado;
    }

    public void setCondicoesFavoraveis(boolean condicoesFavoravies) {
        this.condicoesFavoraveis = condicoesFavoravies;
        this.ultimoResultado=mediador.notificar(this, "atualizarCondicoes");
    }



    public boolean isCondicoesFavoraveis() {
        return this.condicoesFavoraveis;
    }
}
