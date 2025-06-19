package comportamental.br.edu.ifs.designpatterns.observer.impl;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeito {
    protected List<Observador> observadores;

    public Sujeito() {
        this.observadores = new ArrayList<>();
    }

    public void inscrever(Observador observador){
        this.observadores.add(observador);
    }

    public void remover(Observador observador){
        this.observadores.remove(observador);
    }

    abstract public void notificar();
}
