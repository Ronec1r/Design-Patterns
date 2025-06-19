package comportamental.br.edu.ifs.designpatterns.visitor.impl;

import comportamental.br.edu.ifs.designpatterns.visitor.Taxador;

public class TaxadorIsencao implements Taxador {
    @Override
    public double visitar(Alimento alimento) {
        return alimento.getCusto();
    }

    @Override
    public double visitar(Cigarro cigarro) {
        return cigarro.getCusto()*2.50;
    }

    @Override
    public double visitar(Cerveja cerveja) {
        return cerveja.getCusto()*1.15;
    }

    @Override
    public double visitar(Vinho vinho) {
        return vinho.getCusto()*1.20;
    }
}
