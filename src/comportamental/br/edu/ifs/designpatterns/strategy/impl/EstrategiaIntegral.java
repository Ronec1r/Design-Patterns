package comportamental.br.edu.ifs.designpatterns.strategy.impl;

import comportamental.br.edu.ifs.designpatterns.strategy.EstrategiaDesconto;

public class EstrategiaIntegral implements EstrategiaDesconto {
    @Override
    public double calculcarDesconto(double valor) {
        return valor;
    }
}
