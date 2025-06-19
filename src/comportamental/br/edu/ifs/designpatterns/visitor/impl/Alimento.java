package comportamental.br.edu.ifs.designpatterns.visitor.impl;

import comportamental.br.edu.ifs.designpatterns.visitor.Mercadoria;
import comportamental.br.edu.ifs.designpatterns.visitor.Taxador;

public class Alimento extends Mercadoria {
    public Alimento(double custo) {
        super(custo);
    }

    @Override
    public double aceitar(Taxador taxador) {
        return taxador.visitar(this);
    }

}
