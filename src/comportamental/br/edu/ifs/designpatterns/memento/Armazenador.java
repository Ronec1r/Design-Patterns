package comportamental.br.edu.ifs.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class Armazenador {
    private List<Memento> listaMementos;

    public Armazenador() {
        this.listaMementos = new ArrayList<Memento>();
    }

    public void armazenar(Memento memento){
        this.listaMementos.add(memento);
    }

    public Memento recuperar(){
        if(listaMementos.isEmpty()){
            throw new IllegalStateException("Histórico vazio");
        }
        Memento ultimoMemento = listaMementos.get(listaMementos.size()-1);
        listaMementos.remove(listaMementos.get(listaMementos.size()-1));
        return ultimoMemento;
    }

    public String recuperarHistorico(){
        return "";
    }

}
