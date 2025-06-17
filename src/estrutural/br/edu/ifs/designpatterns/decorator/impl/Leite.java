package estrutural.br.edu.ifs.designpatterns.decorator.impl;

import estrutural.br.edu.ifs.designpatterns.decorator.Component;
import estrutural.br.edu.ifs.designpatterns.decorator.Decorator;

public class Leite extends Decorator{
    private String descricao=", com leite";
    private double custo=0.5;

    public Leite(Component componente) {
        super(componente);
    }

    @Override
    public double custo() {
        return this.custo+this.componente.custo();
    }

    @Override
    public String getDescricao() {
        return this.componente.getDescricao()+this.descricao;
    }
}
