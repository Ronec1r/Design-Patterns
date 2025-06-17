package estrutural.br.edu.ifs.designpatterns.decorator.impl;

import estrutural.br.edu.ifs.designpatterns.decorator.Component;
import estrutural.br.edu.ifs.designpatterns.decorator.Decorator;

public class Creme extends Decorator {
    private String descricao=", com creme";
    private double custo=1;

    public Creme(Component componente) {
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
