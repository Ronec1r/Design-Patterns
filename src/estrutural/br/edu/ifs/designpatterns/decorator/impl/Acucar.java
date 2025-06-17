package estrutural.br.edu.ifs.designpatterns.decorator.impl;

import estrutural.br.edu.ifs.designpatterns.decorator.Component;
import estrutural.br.edu.ifs.designpatterns.decorator.Decorator;

public class Acucar extends Decorator {
    private String descricao=", com açúcar";
    private double custo=0.3;

    public Acucar(Component componente) {
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
