package estrutural.br.edu.ifs.designpatterns.decorator.impl;

import estrutural.br.edu.ifs.designpatterns.decorator.Component;

public class Cafe implements Component {
    private double custo=4;
    private String descricao="Café";

    @Override
    public double custo() {
        return this.custo;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
