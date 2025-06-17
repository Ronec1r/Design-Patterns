package estrutural.br.edu.ifs.designpatterns.composite.impl;

import estrutural.br.edu.ifs.designpatterns.composite.Componente;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Componente{
    private List<Componente> componentes = new ArrayList<>();

    public Combo(String nome) {
        super(nome);
    }

    public void adicionar(Componente componente){
        this.componentes.add(componente);
    }

    public void remover(Componente componente){
        this.componentes.remove(componente);
    }

    public Componente obter(int variavel){
        return componentes.get(variavel);
    }

    @Override
    public double calcularPreco(){
        double total=0;
        for (Componente componente : componentes){
            total+= componente.calcularPreco();
        }
        return total;
    }

}
