package comportamental.br.edu.ifs.designpatterns.interpreter.conditional;

import comportamental.br.edu.ifs.designpatterns.interpreter.Expressao;
import comportamental.br.edu.ifs.designpatterns.interpreter.ExpressaoNaoTerminal;
import comportamental.br.edu.ifs.designpatterns.interpreter.sequential.ExpressaoSequencial;

public class ExpressaoCondicional extends ExpressaoNaoTerminal {
    private Expressao condicao;
    private Expressao expressaoVerdadeira;

    public ExpressaoCondicional(Expressao condicao, Expressao expressaoVerdadeira) {
        this.condicao = condicao;
        this.expressaoVerdadeira = expressaoVerdadeira;
        this.expressoes.add(condicao);
        this.expressoes.add(expressaoVerdadeira);
    }

    @Override
    public boolean interpretar() {
        if (condicao.interpretar()) {
            return expressaoVerdadeira.interpretar();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("se ").append(condicao.toString()).append(" então:\n");
        builder.append(expressaoVerdadeira.toString());
        return builder.toString();
    }
}